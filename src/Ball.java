import javax.swing.*;
import java.awt.*;

public class Ball {
    private int x, y;
    private final int size = 50;

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

    public int getSize() {
        return size;
    }

    public void moveR(){
        if (x + size < MainFrame.WindowWidth) {
            this.x += 3;
        }
    }
    public void moveL(){
        if (x > 0) {
            this.x -= 3;
        }
    }
    public void moveU(){
        if (y > 0) {
            this.y -= 3;
        }
    }
    public void moveD(){
        if (y + size + 70 < MainFrame.WindowHeight) {
            this.y += 3;
        }
    }

    public Rectangle calculateRectangle () {
        return new Rectangle(this.x, this.y, size, size /2);
    }

    public void paintComponent(Graphics g) {
        ImageIcon imageIcon = new ImageIcon("src\\Pictures\\ball-removebg-preview (1).png");
        g.drawImage(imageIcon.getImage(), x, y, size, size, null);
    }
}
