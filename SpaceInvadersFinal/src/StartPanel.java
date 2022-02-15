import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date May 31, 2019
 * Description: The class for the start menu panel
 *
 * METHOD LIST:
 * StartPanel() -- Constructor for the JPanel
 * void main(String[] args) -- Main method used for self testing
 * void mouseClicked (MouseEvent e) -- Mouse listener
 */
public class StartPanel extends JPanel {

	/*
	 * private instance variables
	 * buttons for various instances on screen
	 * TextPictures for the main title
	 */

	static Font customFont;
	TextPicture title, bPlay, bHelp, bExit, bHighScores;

	/**
	 * default constructor
	 */
	public StartPanel() {

		// creating a custom font to use, via the use of the CustomFontMaker class
		CustomFontMaker.setFontSize(30f);
		customFont = CustomFontMaker.getCustomFont();
		
		// Panel stuff
		setSize(1000, 700);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);

		// buttons for play, help, exit and highscores. Will need to use a transparent button on top of a TextPicture
		// (since the labels need to have color, they need to be a TextPicture, something the buttons will not allow
		// given the font)

		// play
		bPlay = new TextPicture();
		bPlay.setFont(customFont);
		bPlay.setTitle("Play Game");
		bPlay.setxPos(350);
		bPlay.setyPos(250);
		bPlay.setBounds(0, 0, 1000, 700);
		bPlay.setColor(Color.GREEN);
		add(bPlay);

		// help.
		bHelp = new TextPicture();
		bHelp.setFont(customFont);
		bHelp.setTitle("Help");
		bHelp.setxPos(350);
		bHelp.setyPos(330);
		bHelp.setColor(Color.GREEN);
		bHelp.setBounds(0, 0, 1000, 700);
		add(bHelp);

		// high scores
		bHighScores = new TextPicture();
		bHighScores.setFont(customFont);
		bHighScores.setTitle("High Scores");
		bHighScores.setxPos(350);
		bHighScores.setyPos(410);
		bHighScores.setColor(Color.GREEN);
		bHighScores.setBounds(0, 0, 1000, 700);
		add(bHighScores);

		// exit
		bExit = new TextPicture();
		bExit.setFont(customFont);
		bExit.setTitle("Exit Game");
		bExit.setxPos(350);
		bExit.setyPos(490);
		bExit.setColor(Color.GREEN);
		bExit.setBounds(0, 0, 1000, 700);
		add(bExit);	

		// title stuff
		title = new TextPicture();
		title.setFont(customFont);
		title.setTitle("Space Invaders");
		title.setxPos(275);
		title.setyPos(50);
		title.setColor(Color.GREEN);
		title.setBounds(0, 0, 1000, 700);
		add(title);

		/*
		 * Mouse Listener that will change the screens as each appropriate button (which is in reality a TextPicture) is clicked
		 */
		addMouseListener(new MouseAdapter() {

			public void mouseClicked (MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				//JOptionPane.showMessageDialog(null, x + " ," + y);

				// play
				if ((x >= 350) && (x <= 605) && (y >= 215) && (y <= 250)) {
					//String userName = JOptionPane.showInputDialog(null, "Please Enter Your Username:");
					Frame.setState(Frame.getGamePan());
					Frame.update();
					Frame.getGamePan(true).setup();
				}

				// help
				if ((x >= 350) && (x <= 460) && (y >= 295) && (y <= 330)) {
					Frame.setState(Frame.getHelpPan());
					Frame.update();
				}

				// high scores
				if ((x >= 350) && (x <= 655) && (y >= 375) && (y <= 410)) {
					Frame.setState(Frame.getHighScoresPan());
					Frame.update();
				}

				// exit
				if ((x >= 350) && (x <= 600) && (y >= 455) && (y <= 490)) {
					System.exit(0);
				}

			}

		});


	}

	/**
	 * self testing main method
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1000, 700);

		StartPanel s = new StartPanel();
		f.add(s);
		f.setVisible(true);

	}


}
