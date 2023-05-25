import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private final Player player;
    private final Ball ball;
    private final int counterWidth = 170;
    private final int counterHeight =30;
    private JLabel points = new JLabel();
    private JLabel gameOver = new JLabel("The ball fell");
    private boolean up = false;
    private boolean right = false;
    private int counter = 0;
    private int fast = 10;
    private  int medium = 30;
    private int slowly = 50;
    private int speed = slowly;

    public GamePanel() {
        this.player = new Player(MainFrame.WindowWidth / 2 - Player.Width / 2,MainFrame.WindowHeight-220 );
        this.ball = new Ball(MainFrame.WindowWidth / 2 - 50,  MainFrame.WindowHeight / 3 - 50);
        this.setBackground(Color.YELLOW);
        this.setSize(MainFrame.WindowWidth, MainFrame.WindowHeight);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(26, 226, 20, 224));
        g.fillRect(0, MainFrame.WindowHeight - (MainFrame.WindowHeight / 6), MainFrame.WindowWidth, 64);
        this.player.paint(g);
        this.ball.paintComponent(g);
        points.setBounds(10,10, counterWidth,counterHeight);
        points.setFont(new Font("Arial", Font.BOLD, 30));
        this.add(points);
//        JLabel points = new JLabel();
//        points.setBounds(MainFrame.WindowWidth/2 - counterWidth/2, (MainFrame.WindowHeight/6)*5, counterWidth,counterHeight);

        gameOver.setBounds(MainFrame.WindowWidth / 2 - 175, MainFrame.WindowHeight / 2 - 50, 350, 50);
        gameOver.setFont(new Font("Arial", Font.PLAIN, 60));
        gameOver.setForeground(new Color(235, 2, 2, 255));
    }

    public void maimGameLoop() {
        new Thread(() -> {
            while (ball.getY()+Ball.SIZE  != MainFrame.WindowHeight - (MainFrame.WindowHeight / 6)) {
                points.setText("Points: " + String.valueOf(counter));
                if (!right){
                    this.ball.moveL();
                }else {
                    this.ball.moveR();
                }
                if (!up) {
                    this.ball.moveD();
                }else {
                    this.ball.moveU();
                }
                if (ball.getY() == 0){
                    up = false;
                }
                if (this.ball.getX() < MainFrame.WindowWidth && this.ball.getX() > 940){
                    right = false;
                } else if ( this.ball.getX() == 0) {
                    right = true;
                }
                if (checkRightCollision()){
                    up = true;
                    right = true;
                    counter ++;
                }
                if (checkLeftCollision()){
                    up = true;
                    right = false;
                    counter++;
                }
                if (checkCenterCollision()){
                    up = true;
//                    counter++;
                }
                if(counter >= 1 && counter < 3){
                    speed = medium;
                } else if (counter >= 3) {
                    speed = fast;
                }
                repaint();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

//            JLabel gameOver = new JLabel("The ball fell");
//            gameOver.setBounds(MainFrame.WindowWidth / 2 - 175, MainFrame.WindowHeight / 2 - 50, 350, 50);
//            gameOver.setFont(new Font("Arial", Font.PLAIN, 60));
//            gameOver.setForeground(new Color(235, 2, 2, 255));
            this.add(gameOver);
            this.repaint();

            int currentX = player.getX();
            while (true){
                this.player.setX(currentX);
            }
        }).start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int x = player.getX();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (x < MainFrame.WindowWidth-Player.Width) {
                    this.player.setX(x + 6);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0) {
                    this.player.setX(x - 6);
                }
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    public boolean checkRightCollision() {
        boolean collision = false;
        if (this.player.calculateRightRectangle().intersects(this.ball.calculateRectangle())) {
            collision = true;
        }
        return collision;
    }
    public boolean checkLeftCollision() {
        boolean collision = false;
        if (this.player.calculateLeftRectangle().intersects(this.ball.calculateRectangle())) {
            collision = true;
        }
        return collision;
    }
    public boolean checkCenterCollision() {
        boolean collision = false;
        if (this.player.calculateCenterRectangle().intersects(this.ball.calculateRectangle())) {
            collision = true;
        }
        return collision;
    }
}
