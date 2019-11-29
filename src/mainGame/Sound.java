// written by: Luis Siavichay
// tested by: Luis Siavichay
// debugged by: Luis Siavichay

package mainGame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Sound implements Runnable {
	private boolean running = false;
    private Thread thread;

    public Sound() {
        this.start();
    }

    public void start() {
        if(running)
            return;
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    //
    private boolean playSong = false;
    private AudioInputStream inputStream;
    private String url;
    private Clip clip;

    @Override
    public void run() {
        while(running) {
            if(inputStream == null && playSong) {
                this.playSong = false;
                try {
                    this.inputStream = AudioSystem.getAudioInputStream(Sound.class.getResource(url));
                    this.clip.open(inputStream);
                    this.clip.loop(10);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // call to play .mp3 file
    public void playBackGround(String string) {
        if(this.clip != null) {
            this.clip.stop();
            this.clip.close();
        }
        try {
            this.clip = AudioSystem.getClip();
        }
        catch(LineUnavailableException e) {
            e.printStackTrace();
        }
        url = string + "PTAmusic.mp3";
        this.playSong = true;
        this.inputStream = null;
    }

    public void disposeSound() {
        if(this.clip != null) {
            this.clip.stop();
            this.clip.close();
        }
        this.clip = null;
        this.playSong = false;
        this.inputStream = null;
    }
}
