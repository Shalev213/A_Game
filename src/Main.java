import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedOperationException, IOException, LineUnavailableException, UnsupportedAudioFileException {
        MainFrame window = new MainFrame();
        window.MainFrame();
       // Scanner s = new Scanner(System.in);
        File file = new File("C:\\Users\\USER\\IdeaProjects\\A_Game\\src\\Pictures\\סאונד פרוייקט.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

        Clip clip = AudioSystem.getClip();

            clip.open(audioInputStream);
        while (true) {
            clip.start();

           // String x = s.next();
        }

    }
}


