import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

/**
 * @author Asad Asif
 * 2019 - 04 - 08
 * This creates a music player object which allows the user to play any music file
 * as long as its a .wav file. The object can start/stop music and change the music
 * 
 * AudioClip taken and edited from Bheesham's previous project
 * File to url path code taken from 
 * 	--https://stackoverflow.com/questions/6098472/pass-a-local-file-in-to-url-in-java
 */

/**
 * METHOD LIST
 * public MusicPlayer(String name) - Default constructor creates music player object
 * public void play() - plays music
 * public void stop() - stops music
 * public void update(String name) - updates the song / uses latest file name to create audio clip
 * public void setSong(String name) - changes the song file
 */
public class MusicPlayer {

	/**
	 * Creates Instances
	 */

	private String fileName;
	private AudioClip sound;
	private URL url;

	//  Default constructor
	public MusicPlayer(String name) throws MalformedURLException {
		update(name);
	}

	/**
	 * BEHAVIOURS 
	 */

	// Play Song
	public void play(){
		this.sound.play();
	}

	// Stop the song
	public void stop() {
		this.sound.stop();
	}
	
	// Creating the sound clip
	public void update(String name) throws MalformedURLException {
		this.fileName = name;
		url = new File("Music/" + name).toURI().toURL(); // Sets the file path	
		this.sound = Applet.newAudioClip(url); // creates the sound clip
	}

	// Setter
	public void setSong(String name) throws MalformedURLException{
		update(name);
	}
	
	//----------------Testing---------------------
	// Getter
	public String getSong() {
		return this.fileName;
	}
	//---------------Testing-----------------------


	/**
	 * Self Testing Main Method
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		
		// Creates the music player object and sets the song
		MusicPlayer music = new MusicPlayer("vodka haram haram remix bass.wav");
		music.play(); // Plays the song
		JOptionPane.showMessageDialog(null, "Wait");
		music.stop(); // Stops the song
		
		JOptionPane.showMessageDialog(null, "Wait");
		music.setSong("Khalid - Right Back (Audio).wav"); // Changing song
		music.play(); // Play song
		JOptionPane.showMessageDialog(null, music.getSong()); // Display song Name
		music.stop(); // Stopping song
		
	}

}
