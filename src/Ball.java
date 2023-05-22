import javax.swing.*;
import java.awt.*;

public class Ball {
    private int x, y;
    public static final int Width = 50;
    public static final int Height = 50;

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
//        g.setColor(Color.black);
//        g.fillOval(x, y, 50, 50);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\ball-removebg-preview (1).png");
        g.drawImage(imageIcon.getImage(), x, y, Width, Height, null);
    }


}
