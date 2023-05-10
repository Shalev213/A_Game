import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WindowWidth = 1000;
    public static final int WindowHeight = 600;
    public static final int ButtonWidth = 150;
    public static final int ButtonHeight = 100;
    public static final int Button_X = 425;
    public static final int Button_Y = 425;
    public static final int ButtonFont = 50;
    public static final int Title_X = 340;
    public static final int Title_Y = 25;
    public static final int TitleWidth = 320;
    public static final int TitleHeight = 100;
    public static final int TitleFont = 50;

    public Window(){
        this.setResizable(false);
        this.setSize(WindowWidth,WindowHeight);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        JButton start =new JButton("Start");
        start.setFont(new Font("Arial",Font.BOLD,ButtonFont));
        start.setBounds(Button_X, Button_Y, ButtonWidth, ButtonHeight);
        this.add(start);
         JLabel title =new JLabel("Ball In The Air");
         title.setBounds(Title_X, Title_Y, TitleWidth, TitleHeight);
         title.setFont(new Font("Arial",Font.ITALIC,TitleFont));
         title.setForeground(Color.blue);

         this.add(title);

    }
    public void showWindow(){
        this.setVisible(true);
    }
}
