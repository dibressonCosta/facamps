package asteroids;

import java.applet.*;
import javax.sound.sampled.*;
import sun.audio.*;

public class Sons {

    AudioClip explosaoSound;
    AudioClip laserSound;
    AudioClip fundoSound;

    public Sons() {
        try {
            explosaoSound = Applet.newAudioClip(getClass().getResource("/explosaoAst.wav"));
            laserSound = Applet.newAudioClip(getClass().getResource("/laser1.wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void music() {
        AudioStream BGM;
        AudioData MD;
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream test = AudioSystem.getAudioInputStream(getClass().getResource("/fundoSound.wav"));
            clip.open(test);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
