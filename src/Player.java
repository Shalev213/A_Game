import javax.swing.*;
import java.awt.*;

public class Player {
    private int x,y ;

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
//        imageIcon.paintIcon(null, graphics,50,50);
        graphics.drawImage(imageIcon.getImage(), x,y, 200, 200, null);
//        graphics.setColor(Color.black);
//        graphics.fillOval(50,50,30,30);
    }
}
