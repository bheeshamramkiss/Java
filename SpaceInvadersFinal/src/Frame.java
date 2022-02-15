import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date May 31, 2019
 * Description: All the frames. All of it.
 *
 * METHOD LIST:
 * Frame() -- default constructor that creates the window
 * StartPanel getStartPan() -- getter for the start screen panel
 * GamePanel getGamePan() -- getter for the game screen panel
 * HelpPanel getHelpPan() --  getter for the help screen panel
 * JPanel getState() -- getter for the current panel being displayed
 * setState(JPanel state2) -- setter used to change screen being displayed to the user
 * void update() -- once a new state is set, the update method clears all panels/components from the frame, and puts the new 
 * 					frame onto screen
 * void main (String[] args) -- self testing main method
 */
public class Frame {

	/*
	 * private instance variables
	 * 
	 * For the frame and each panel
	 */
	
	private static JFrame f;
	public static JPanel state;
	
	private static StartPanel startPan;
	private static GamePanel gamePan;
	private static HelpPanel helpPan;
	private static GameOverPanel gameOverPan;
	private static HighscorePanel highScoresPan;
	private static WinPanel winPan;
	
	/**
	 *  default constructor
	 */
	public Frame() {
		startPan = new StartPanel();
		gamePan = new GamePanel();
		helpPan = new HelpPanel();
		gameOverPan = new GameOverPanel("", "");
		highScoresPan = new HighscorePanel();
		winPan = new WinPanel("", "");
		
		state = startPan;
		
		f = new JFrame("Spacey Shooty Bois");
		f.setSize(1000,700);
        f.setLayout(new CardLayout(0, 0));
        f.setResizable(false);
        f.setVisible(true);
        f.add(getState());
	}

	/*
	 * getters and setters for the state, to allow the ability to change panels via update method
	 */
	
	public static StartPanel getStartPan() {
		return startPan;
	}

	public static GamePanel getGamePan() {
		gamePan = new GamePanel();
		return gamePan;
	}
	
	// overloaded getter to return just the gamePanel	
	public static GamePanel getGamePan(boolean n) {
		return gamePan;
	}

	public static HelpPanel getHelpPan() {
		return helpPan;
	}

	public static GameOverPanel getGameOverPan(String score, String time) {
		gameOverPan = new GameOverPanel(score, time);
		return gameOverPan;
	}
	
	public static HighscorePanel getHighScoresPan() {
		return highScoresPan;
	}
	
	public static WinPanel getWinPan(String score, String time) {
		winPan = new WinPanel(score, time);
		return winPan;
	}
	
	public static JPanel getState() {
		return state;
	}

	public static void setState(JPanel state2) {
		state = state2;
	}
	
	/*
	 * update method to change between panels
	 */
	
	public static void update() {

        f.getContentPane().removeAll(); // removes the current pane and all other components on screen
        f.getContentPane().add(getState()); // gets the new pane and adds it
        f.getContentPane().repaint(); // repaints it
        f.getContentPane().revalidate(); // idk (as in I do know) what this does but windows builder said i needed it so here it is
    }

	/**
	 * self testing main method
	 */
	public static void main(String[] args) {
		new Frame();

	}

}
