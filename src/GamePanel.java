import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private Player player;
    private Ball ball;

    public GamePanel() {
        this.player = new Player();
        this.ball = new Ball(MainFrame.WindowWidth / 2 - 50, MainFrame.WindowHeight / 2 - 50);
        this.setBackground(Color.YELLOW);
        this.setSize(MainFrame.WindowWidth, MainFrame.WindowHeight);
        this.addKeyListener(this);
        this.requestFocusInWindow();
        this.maimGameLoop();
        this.setFocusable(true);
        this.requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.player.paint(g);
        this.ball.paintComponent(g);
        g.setColor(new Color(34, 149, 30, 224));
        g.fillRect(0, MainFrame.WindowHeight - (MainFrame.WindowHeight / 6), MainFrame.WindowWidth, 100);
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
        if (MainFrame.WindowWidth - 50 < x) {
            this.ball.setX(x + 2);
        } else {
            this.ball.setX(x - 2);
        }
        if (MainFrame.WindowHeight - 50 < y) {
            this.ball.setY(y + 2);
        } else {
            this.ball.setY(y - 2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
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


    }

    @Override
    public void keyReleased(KeyEvent e) {


    }
}
