package models;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    Clip clip;

    public Sound() {

    }

    public void setFile(String soundName) {
        try {
            File file = new File(soundName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void repeat() {
        play();
        clip.loop(100);
    }

}
