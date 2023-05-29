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
    private Image background;

    public StartPanel() {
        background = new ImageIcon("src/Pictures/background2.jpg").getImage();

        this.setLayout(null);
        this.setBackground(Color.cyan);
        JButton start = new JButton("Start");
        start.setFont(new Font("Arial", Font.BOLD, ButtonFont));
        start.setBounds(Button_X, Button_Y, ButtonWidth, ButtonHeight);
        start.setFocusable(false);
        JLabel title = new JLabel("Ball In The Air");
        title.setBounds(Title_X, Title_Y, TitleWidth, TitleHeight);
        title.setFont(new Font("Arial", Font.ITALIC, TitleFont));
        title.setForeground(Color.blue);
        JLabel instructions = new JLabel("<html>Welcome to our game!!!<br>The target of our game is: don't let the ball fall by using <br> the left and right keys to make Messi move.<br>~Every touch of the ball is a point! <br>  Click 'Start' to start the game");
        instructions.setBounds(Title_X / 4, Title_Y * 5, TitleWidth * 4, TitleHeight*2);
        instructions.setFont(new Font("Arial", Font.ITALIC, TitleFont*2/3));
        instructions.setForeground(new Color(0xE011E7E3, true));

        start.addActionListener((e) -> {
            MainFrame.gamePanel.setVisible(true);
            MainFrame.startPanel.setVisible(false);
            MainFrame.gamePanel.maimGameLoop();
            MainFrame.gamePanel.requestFocus();
        });

        this.add(title);
        this.add(instructions);
        this.add(start);
        this.setVisible(true);

    }
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(background, 0, 0, null);
    }
}
