import javax.swing.*;
import java.awt.*;
import java.awt.Window;

public class StartPanel extends JPanel {
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

    public StartPanel() {
        this.setLayout(null);
        this.setBackground(Color.cyan);
        JButton start = new JButton("Start");
        start.setFont(new Font("Arial", Font.BOLD, ButtonFont));
        start.setBounds(Button_X, Button_Y, ButtonWidth, ButtonHeight);
        start.setOpaque(false);
        start.setFocusable(false);
        JLabel title = new JLabel("Ball In The Air");
        title.setBounds(Title_X, Title_Y, TitleWidth, TitleHeight);
        title.setFont(new Font("Arial", Font.ITALIC, TitleFont));
        title.setForeground(Color.blue);

        start.addActionListener((e) -> {
            MainFrame.gamePanel.setVisible(true);
            MainFrame.startPanel.setVisible(false);
        });
        this.add(title);
        this.add(start);
        this.setVisible(true);
    }

}
