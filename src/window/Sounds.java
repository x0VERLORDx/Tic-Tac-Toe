package window;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sounds {
    public static URL oSound;
    private static final URL xSound;
    private static final URL resetSound;
    private static final URL winSound;
    static {
        oSound = Sounds.class.getResource("/oSound2.wav");
        // oSound = new File(Objects.requireNonNull(Sounds.class.getResource("/oSound2.wav")).toURI());
        xSound = Sounds.class.getResource("/xSound2.wav");
        resetSound = Sounds.class.getResource("/resetSound3.wav");
        winSound = Sounds.class.getResource("/winSound.wav");
    }
    public static void playXSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(xSound);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    public static void playOSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(oSound);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    public static void playResetSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resetSound);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
    public static void playWinSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(winSound);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
    }
}
