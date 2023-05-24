import javax.swing.*;
import java.awt.*;

public class Player {
    private int x, y;
    private ImageIcon imageIcon = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\Pictures\\player-removebg-preview.png");
    private int width;

    public static final int Width = 115;
    public static final int Height = 145;

    public Player(int x ,int y ) {
        this.x = x;
        this.y = y;
        this.width =imageIcon.getIconWidth();
    }


    public void move(int up){
        this.y += up;
    }
    public  int getWidth(){
        return this.width;
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
    public Rectangle calculateRightRectangle () {
        return new Rectangle(this.x + (2 * (Width/3)) + Width/15, this.y, Width/3, Height/8);
    }
    public Rectangle calculateLeftRectangle () {
        return new Rectangle(this.x-Width/15 , this.y, Width/3, Height/8);
    }
    public Rectangle calculateCenterRectangle () {
        return new Rectangle(this.x + Width/3, this.y, Width/3, Height/8);
    }



    public void paint(Graphics graphics) {
//        ImageIcon imageIcon = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\Pictures\\player-removebg-preview.png");
        graphics.drawImage(imageIcon.getImage(), x, y, Width, Height, null);
    }
}
