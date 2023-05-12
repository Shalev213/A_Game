import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainWindow extends JPanel {
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

    public MainWindow () {
        this.setLayout(null);

        JButton start =new JButton("Start");
        start.setFont(new Font("Arial",Font.BOLD,ButtonFont));
        start.setBounds(Button_X, Button_Y, ButtonWidth, ButtonHeight);

        GameWindow gameWindow= new GameWindow();

        start.addActionListener((e) -> {
            Window window1= new Window();
            window1.add(gameWindow);
            window1.showWindow();
//            this.setVisible(false);
//            this.dispatchEvent(new WindowEvent(,WindowEvent.WINDOW_CLOSING));
        });

        JLabel title =new JLabel("Ball In The Air");
        title.setBounds(Title_X, Title_Y, TitleWidth, TitleHeight);
        title.setFont(new Font("Arial",Font.ITALIC,TitleFont));
        title.setForeground(Color.blue);


        this.add(title);
        this.add(start);
    }

}
