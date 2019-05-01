package tutorial1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundClip {

    private AudioInputStream sound;	// AudioInputStream object
    private Clip clip;			// Audio clip
    private boolean loop;		// Boolean to allow looping
    private int fPosition;              // Integer that save the frame position of the clip

    /**
     * Default constructor
     */
    public SoundClip() {
	try {
	    clip = AudioSystem.getClip();
	} catch (LineUnavailableException e) {
	}
    }

    public int getfPosition() {
        return fPosition;
    }

    public void setfPosition(int fPosition) {
        this.fPosition = fPosition;
    }

    /**
     * Constructor with <b>path</b> parameter
     *
     * @param path Path to specified sound file
     * @param loop Boolean to allow looping
     */
    public SoundClip(String path, float offset, boolean loop) {
	this();	    // Calls default constructor
        fPosition = 0; //Fposition is set on 0
	// Attempt to get resource and save as URL
	URL url = null;
	try {
	    url = this.getClass().getResource(path);
	} catch (Exception e) {
	    System.out.println("" + path + " doesn't exist!");
	}

	// Attempt to load sound
	try {
	    sound = AudioSystem.getAudioInputStream(url);
	    clip.open(sound);
	} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
	    System.err.println("Error loading file! " + e);
	}

	// Modify volume of sound
	FloatControl fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	fc.setValue(offset);

	this.loop = loop;
    }

    /**
     * Method to start playback
     */
    public void play() {
	clip.stop();	// Stop sound if already playing
	if (sound == null) {	// If no sound is loaded, stop here
	    return;
	}
	clip.setFramePosition(getfPosition());

	// Loop when specified
	clip.loop((loop) ? Clip.LOOP_CONTINUOUSLY : 0);
    }
    public void stop(){
        clip.stop();
    }
    /**
     * Method to pause playback
     */
    public void pause(){
        setfPosition(clip.getFramePosition());
        clip.stop();
    }
    /**
     * Method that return true if the clip is stop and true if is running
     */
    public boolean isStop(){
        if(!clip.isRunning()){
            return true;
        } else { 
            return false;
        }
    }
}

