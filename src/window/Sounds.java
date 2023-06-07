package window;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class Sounds {
    public static File oSound;
    private static final File xSound;
    private static final File resetSound;
    private static final File winSound;
    static {
        try {
            oSound = new File(Objects.requireNonNull(Sounds.class.getResource("/oSound2.wav")).toURI());
            xSound = new File(Objects.requireNonNull(Sounds.class.getResource("/xSound2.wav")).toURI());
            resetSound = new File(Objects.requireNonNull(Sounds.class.getResource("/resetSound3.wav")).toURI());
            winSound = new File(Objects.requireNonNull(Sounds.class.getResource("/winSound.wav")).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
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
