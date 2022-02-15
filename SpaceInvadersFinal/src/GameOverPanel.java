import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date June 17, 2019
 * Description: Panel to display when the player loses
 *
 */
public class GameOverPanel extends JPanel {

	/*
	 * private instance variables
	 */
	
	private TextPicture winMsg, scoreArea, timeArea;
	private TextPicture btnPlayAgain, btnMenu;
	
	
	static Font customFont;
	
	/**
	 *  default constructor
	 */
	public GameOverPanel(String score, String time) {

		// creating a custom font to use, via the use of the CustomFontMaker class
		CustomFontMaker.setFontSize(30f);
		customFont = CustomFontMaker.getCustomFont();

		// panel size, color and layout
		setSize(1000, 700);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);
		
		// setting the size and text for the winning message
		winMsg = new TextPicture();
		winMsg.setFont(customFont);
		winMsg.setTitle("YOU LOSE :(");
		winMsg.setxPos(325);
		winMsg.setyPos(90);
		winMsg.setBounds(0, 0, 1000, 700);
		winMsg.setColor(Color.GREEN);
		
		// setting size and text for the score		
		scoreArea = new TextPicture();
		scoreArea.setFont(customFont);
		scoreArea.setTitle("Your Score: " + score);
		scoreArea.setxPos(200);
		scoreArea.setyPos(250);
		scoreArea.setBounds(0, 0, 1000, 700);
		scoreArea.setColor(Color.WHITE);
		
		// setting size and text for the time taken	
		timeArea = new TextPicture();
		timeArea.setFont(customFont);
		timeArea.setTitle("Time Taken: " + time);
		timeArea.setxPos(200);
		timeArea.setyPos(350);
		timeArea.setBounds(0, 0, 1000, 700);
		timeArea.setColor(Color.WHITE);
		
		// setting the font size smaller for the buttons onscreen
		CustomFontMaker.setFontSize(15f);
		customFont = CustomFontMaker.getCustomFont();
		
		// buttons to play again and return to the main menu
		btnMenu = new TextPicture();
		btnMenu.setFont(customFont);
		btnMenu.setTitle("<-- Back to Main Menu");
		btnMenu.setxPos(50);
		btnMenu.setyPos(600);
		btnMenu.setBounds(0, 0, 1000, 700);
		btnMenu.setColor(Color.RED);
		
		btnPlayAgain = new TextPicture();
		btnPlayAgain.setFont(customFont);
		btnPlayAgain.setTitle("Play Again?");
		btnPlayAgain.setxPos(650);
		btnPlayAgain.setyPos(600);
		btnPlayAgain.setBounds(0, 0, 1000, 700);
		btnPlayAgain.setColor(Color.GREEN);
		
		// adding each component onto the panel
		add(winMsg);
		add(scoreArea);
		add(timeArea);
		add(btnMenu);
		add(btnPlayAgain);
		
		/*
		 * Mouse Listener that will change the screens as each appropriate button (which is in reality a TextPicture) is clicked
		 */
		addMouseListener(new MouseAdapter() {

			public void mouseClicked (MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				// play
				if ((x >= 650) && (x <= 800) && (y >= 580) && (y <= 600)) {
					// disposing of the game window so when it is called again the game resets			
					Frame.setState(Frame.getGamePan());
					Frame.update();
					Frame.getGamePan(true).setup();
				}
				
				// main menu
				if ((x >= 50) && (x <= 332) && (y >= 580) && (y <= 600)) {
				Frame.setState(Frame.getStartPan());
				Frame.update();
			}

			}
		});
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1000, 700);
		f.add(new GameOverPanel("300", " 2:16"));
		f.setVisible(true);

	}

}
