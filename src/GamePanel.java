import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private final Player player;
    private final Ball ball;
    private boolean up = false;
    private boolean right = false;


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
        g.fillRect(0, MainFrame.WindowHeight - (MainFrame.WindowHeight / 6), MainFrame.WindowWidth, 70);
//        this.player.setY(getY()+ 410);
        this.player.paint(g);
        this.ball.paintComponent(g);
    }

    public void maimGameLoop() {
        new Thread(() -> {
            while (ball.getY()+Ball.SIZE + 70 !=MainFrame.WindowHeight) {
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
//                updateBall();
                if (checkRightCollision()){
                    up = true;
                    right = true;
//                    System.out.println(player.getX() + " " + player.getWidth()/2 +" " + ball.getX());
//                    this.ball.setX(this.ball.getX()+50);
//                    this.ball.setY(this.ball.getY()-150);
//                    System.out.println(player.getX() + " " + player.getWidth()/2 +" " + ball.getX());
                }
                if (checkLeftCollision()){
                    up = true;
                    right = false;

//                    System.out.println(player.getX() + " " + player.getWidth()/2 +" " + ball.getX());
//                    this.ball.setX(this.ball.getX() -50 );
//                    this.ball.setY(this.ball.getY() -150);
//                    System.out.println(player.getX() + " " + player.getWidth()/2 +" " + ball.getX());
                }

                if (checkCenterCollision()){
                    up = true;
//                    System.out.println(player.getX() + " " + player.getWidth()/2 +" " + ball.getX());
//                    this.ball.setX(this.ball.getX());
//                    this.ball.setY(this.ball.getY()-150);
//                    System.out.println(player.getX() + " " + player.getWidth()/2 +" " + ball.getX());
                }
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                if (checkRightCollision()){
//                    this.ball.move(getX()-3, getY()-4);
//                }
            }
            JLabel label = new JLabel("The ball fell");
            label.setBounds(MainFrame.WindowWidth / 2 - 175, MainFrame.WindowHeight / 2 - 50, 350, 50);
            label.setFont(new Font("Arial", Font.PLAIN, 60));
            label.setForeground(new Color(235, 2, 2, 255));
            this.add(label);

            while (true){
                this.player.setX(300);
            }
        }).start();
    }

    private void updateBall() {
        int x = ball.getX(), y = ball.getY();
//        if (ball.getX() < player.getX() && ball.getY()+30 == player.getY()){
//            this.ball.setX(x - 100);
//        }else if (ball.getX() > player.getX() && ball.getY() + 30 == player.getY()){
//            this.ball.setX(x + 100);
//
//        }
//        if (MainFrame.WindowWidth - 50 > x) {
//            this.ball.setX(x + 3);
//        } else {
//            this.ball.setX(x - 4);
//        }
        if (MainFrame.WindowHeight - 150 > y) {
            this.ball.setY(y + 2);
        } else {
            this.ball.setY(y);
            this.ball.setX(x);
            JLabel label = new JLabel("The ball fell");
            label.setBounds(MainFrame.WindowWidth / 2 - 175, MainFrame.WindowHeight / 2 - 50, 350, 50);
            label.setFont(new Font("Arial", Font.PLAIN, 60));
            label.setForeground(new Color(235, 2, 2, 255));
            this.add(label);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       System.out.println("keyTyped");

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("keyTyped");
        int x = player.getX(), y = player.getY();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                if (x < MainFrame.WindowWidth-Player.Width) {
                    this.player.setX(x + 6);
//                System.out.println("right");
                    this.repaint();
                }
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0) {
                    this.player.setX(x - 6);
                }
                break;
            case KeyEvent.VK_UP:
                this.player.setY(this.player.getY() - 5);
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
