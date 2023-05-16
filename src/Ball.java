import java.awt.*;

public class Ball {
    private int x, y;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(x, y, 50, 50);
    }


}
