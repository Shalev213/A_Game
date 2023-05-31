import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;




public class BackgroundSound {
    private boolean playOrNot;

    public BackgroundSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.playOrNot = false;
        File file = new File("src\\WAV_file\\manchester-united-football-club-55798.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);

        new Thread(() -> {
            while (true) {
                if(playOrNot){
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                }
                if (!playOrNot){
                    clip.stop();
                }
            }
        }).start();

    }
    public void playMusic(){
        this.playOrNot = true;
    }
    public void stopMusic(){

        this.playOrNot = false;
    }
}
