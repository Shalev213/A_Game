import javax.swing.*;
import java.awt.*;

public class Player {

    public void paint (Graphics graphics){
        ImageIcon imageIcon=new ImageIcon("C:\\Users\\USER\\OneDrive\\שולחן העבודה\\עבודות הגשה\\IMG-20230512-WA0015.jpg");
        imageIcon.paintIcon(null, graphics, 100, 100);
//        graphics.setColor(Color.black);
//        graphics.fillOval(50,50,30,30);
    }
}
