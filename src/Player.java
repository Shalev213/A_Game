import javax.swing.*;
import java.awt.*;

public class Player {
    private int x, y;
    public static final int Width = 115;
    public static final int Height = 145;

    public Player(int x ,int y) {
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



    public void paint(Graphics graphics) {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\USER\\Downloads\\player-removebg-preview.png");
        graphics.drawImage(imageIcon.getImage(), x, y, Width, Height, null);
    }
}
