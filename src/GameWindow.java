import javax.swing.*;
import java.awt.*;

public class GameWindow extends JPanel {
    private Player player;
    public GameWindow () {
        this.player=new Player();
        this.setBackground(Color.YELLOW);
        this.setSize(1000,600);


    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this.player.paint(graphics);
    }
}
