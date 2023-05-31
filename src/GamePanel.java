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
    private boolean ballFell = false;
    private boolean up = false;
    private boolean right = false;
    private int counter = 0;
    private int veryFast = 7;
    private int fast = 10;
    private  int medium = 15;
    private int slow = 25;
    private int speed = slow;
    private int pointLocation = 10;
    private Image backgroundImage;
    private BackgroundSound backgroundSound;


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
        this.backgroundImage = Toolkit.getDefaultToolkit().getImage("src\\Pictures\\background1.jpg");
        g.drawImage(backgroundImage, 0, 0, getWidth() , getHeight() , this);
        g.setColor(new Color(26, 226, 20, 224));

        this.player.paint(g);
        this.ball.paintComponent(g);
        points.setBounds(pointLocation,pointLocation, counterWidth,counterHeight);
        points.setFont(new Font("Arial", Font.BOLD, 30));
        points.setForeground(Color.CYAN);
        this.add(points);


        gameOver.setBounds(MainFrame.WindowWidth / 2 - 175, MainFrame.WindowHeight / 2 - 50, 350, 50);
        gameOver.setFont(new Font("Arial", Font.PLAIN, 60));
        gameOver.setForeground(new Color(235, 2, 2, 255));
    }

    public void maimGameLoop() {
        new Thread(() -> {
            int collisionCounter = 0;

            while (ball.getY()+ball.getSize()  != MainFrame.WindowHeight - (MainFrame.WindowHeight / 6)) {
                points.setText("Points: " + String.valueOf(counter));
                if (ball.getY() == 0){
                    collisionCounter = 0;
                }
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
                    collisionCounter++;
                    if (collisionCounter == 1){
                        counter++;
                    }

                }else if (checkLeftCollision()){
                    up = true;
                    right = false;
                    collisionCounter++;
                    if (collisionCounter == 1){
                        counter++;
                    }
                }
                if (checkCenterCollision()){
                    up = true;
                }
                if(counter >= 5 && counter < 10){
                    speed = medium;
                } else if (counter >= 10 && counter < 15) {
                    speed = fast;
                } else if (counter >= 15) {
                    speed = veryFast;
                }
                repaint();
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.ballFell = true;
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
                    this.player.setX(x + 16);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0) {
                    this.player.setX(x - 16);
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
    public boolean isBallFell(){
        return ballFell;
    }
}
