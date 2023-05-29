import javax.swing.*;
public class MainFrame extends JFrame {
    public static StartPanel startPanel;
    public static GamePanel gamePanel;
    public static final int WindowWidth = 1000;
    public static final int WindowHeight = 600;
    public MainFrame(){
        this.setResizable(false);
        this.setSize(WindowWidth,WindowHeight); 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Ball In The Air");
        this.setLocationRelativeTo(null);
         startPanel = new StartPanel();
         gamePanel = new GamePanel();
         gamePanel.setVisible(false);
        this.getContentPane().add(gamePanel);
        this.getContentPane().add(startPanel);
    }
    public void MainFrame(){
        this.setVisible(true);
    }
}
