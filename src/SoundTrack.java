import java.io.*;
import java.net.URL;
import javax.sound.midi.Instrument;
import javax.sound.midi.Patch;
import javax.sound.midi.Soundbank;
import javax.sound.midi.SoundbankResource;
import javax.sound.sampled.*;
import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundTrack extends JFrame implements Soundbank {
    private String soundtype;
    private File soundfile;
    public void SoundTrack(String soundeffect) {
        soundtype = soundeffect;
        try {
            switch (soundtype) {
                case "wind":
                    soundfile = new File("C:\\Users\\User\\IdeaProjects\\MyGame\\src\\wav\\windblow.wav");
                    break;
                case "inflate":
                    soundfile = new File("C:\\Users\\User\\IdeaProjects\\MyGame\\src\\wav\\Ballooninflating.wav");
                    break;
                case "shoot":
                    soundfile = new File("C:\\Users\\User\\IdeaProjects\\MyGame\\src\\wav\\arrowshotshort.wav");
                    break;
                case "boom":
                    soundfile = new File("C:\\Users\\User\\IdeaProjects\\MyGame\\src\\wav\\BalloonPopping.wav");
                    break;
                case "pop":
                    soundfile = new File("C:\\Users\\User\\IdeaProjects\\MyGame\\src\\wav\\popsound.wav");
                    break;
                case "wee":
                    soundfile = new File("C:\\Users\\User\\IdeaProjects\\MyGame\\src\\wav\\movesound.wav");
                    break;
                case "eew":
                    soundfile = new File("C:\\Users\\User\\IdeaProjects\\MyGame\\src\\wav\\eewsound.wav");
                    break;
                // Open an audio input stream.
            }
            Clip clip;
            try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundfile)) {
                // Get a sound clip resource.
                clip = AudioSystem.getClip();
                // Open audio clip and load samples from the audio input stream.
                clip.open(audioIn);
            }
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public String getVendor() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }


    @Override
    public SoundbankResource[] getResources() {
        return new SoundbankResource[0];
    }


    @Override
    public Instrument[] getInstruments() {
        return new Instrument[0];
    }
    @Override
    public Instrument getInstrument(Patch patch) {
        return null;
    }
}