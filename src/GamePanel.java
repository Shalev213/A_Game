import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private final Player player;
    private final Ball ball;

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
            while (true) {
                repaint();
                updateBall();
                if (checkCollision()){
                    this.ball.move(getX()-3, getY()-4);
                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                if (checkCollision()){
//                    this.ball.move(getX()-3, getY()-4);
//                }
            }
        }).start();
    }

    private void updateBall() {
        int x = ball.getX(), y = ball.getY();
        if (MainFrame.WindowWidth - 50 > x) {
            this.ball.setX(x + 3);
        } else {
            this.ball.setX(x - 4);
        }
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
    public boolean checkCollision() {
        boolean collision = false;
        if (this.player.calculateRectangle().intersects(this.ball.calculateRectangle())) {
            collision = true;
        }
        return collision;
    }
}
