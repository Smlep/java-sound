package sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ClipTest {
    static void run(){
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("src/main/resources/wav/jungle.wav")));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(5.0f);

            clip.start();
            do {
                Thread.sleep(15);
            } while (clip.isRunning());

            clip.drain();
            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
