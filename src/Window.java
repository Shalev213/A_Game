import javax.swing.*;
public class Window extends JFrame {
    public static final int WindowWidth = 1000;
    public static final int WindowHeight = 600;
    public Window(){
        this.setResizable(false);
        this.setSize(WindowWidth,WindowHeight);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        MainWindow mainWindow = new MainWindow();
        this.add(mainWindow);
    }
    public void showWindow(){
        this.setVisible(true);
    }
}
