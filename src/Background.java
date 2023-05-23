import javax.swing.*;
import java.awt.*;

public class Background {
    public static final int X = 0;
    public static final int Y = 0;

    public void paint(Graphics graphics) {
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\background2.jpg");
        backgroundImage.paintIcon(null, graphics,X, Y);
    }
}
