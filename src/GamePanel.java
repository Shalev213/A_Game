import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private Player player;
    private Ball ball;

    public GamePanel() {
        this.player = new Player(0,MainFrame.WindowHeight-220 );
        this.ball = new Ball(MainFrame.WindowWidth / 2 - 50, MainFrame.WindowHeight / 2 - 50);
        this.setBackground(Color.YELLOW);
        this.setSize(MainFrame.WindowWidth, MainFrame.WindowHeight);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.ball.paintComponent(g);
        g.setColor(new Color(26, 226, 20, 224));
        g.fillRect(0, MainFrame.WindowHeight - (MainFrame.WindowHeight / 6), MainFrame.WindowWidth, 70);
//        this.player.setY(getY()+ 410);
        this.player.paint(g);
    }

    public void maimGameLoop() {
        new Thread(() -> {
            while (true) {
                repaint();
                updateBall();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }

    private void updateBall() {
        int x = ball.getX(), y = ball.getY();
        boolean goingBack = false;
        if (MainFrame.WindowWidth - 50 > x) {
            this.ball.setX(x + 4);
        } else {
            this.ball.setX(x - 4);
        }
        if (MainFrame.WindowHeight - 150 > y) {
            this.ball.setY(y + 4);
        } else {
            this.ball.setY(y);
            this.ball.setX(x);
            JLabel label = new JLabel("The ball fell");
            label.setBounds(MainFrame.WindowWidth / 2 - 175, MainFrame.WindowHeight / 2 - 50, 350, 50);
            label.setFont(new Font("Arial", Font.ROMAN_BASELINE, 60));
            label.setForeground(new Color(235, 2, 2, 255));
            this.add(label);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
       System.out.println("keyTyped");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                this.player.setX(this.player.getX() + 2);
                System.out.println("right");
                break;
            case KeyEvent.VK_LEFT:
                this.player.setX(this.player.getX() - 2);
                break;
            case KeyEvent.VK_UP:
                this.player.setY(this.player.getY() + 2);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyTyped");

    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}
