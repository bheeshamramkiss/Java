import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date May 31, 2019
 * Description: The class for the help panel
 *
 * METHOD LIST:
 * HelpPanel() -- default constructor
 * void MouseClicked(MouseEvent e) -- mouse listener used to perform actions based on the computer cursor's position/actions
 * void main(String[] args) -- self testing main method
 */
public class HelpPanel extends JPanel{

	/*
	 * private instance variables
	 */

	private JTextArea displayArea;
	private String[] help;
	private String displayText;
	private TextPicture btnMenu;

	static Font customFont;

	/**
	 * 
	 */
	public HelpPanel() {

		// creating a custom font to use, via the use of the CustomFontMaker class
		CustomFontMaker.setFontSize(12f);
		customFont = CustomFontMaker.getCustomFont();
		


		// panel size, color and layout
		setSize(1000, 700);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);

		// reading the text file and storing the content of the txt help file into a string (via the use of infoSysLoader)
		try {
			help = TheLoaderClass.loadFile("HelpFile.txt");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "An error has occurred while loading");
		}


		//setting size of the displayArea
		displayArea = new JTextArea();
		displayArea.setBounds(25, 15, 950, 500);

		displayText = ""; // this pre-sets the text to something, otherwise when it is concatted later on, it will show null
		// in the actual textArea
		//setting text of the display area to the contents of the help string array
		for (int i = 0; i < help.length; i++) {
			displayText += help[i] + "\n";
		}
		displayArea.setText(displayText);

		// changing the font and color for consistency, not allowing the area to be editable, etc.
		displayArea.setFont(customFont);
		displayArea.setForeground(Color.GREEN);
		displayArea.setBackground(Color.BLACK);
		displayArea.setEditable(false);
		displayArea.setVisible(true);

		//adding the displayArea to the Panel
		add(displayArea);

		// creating the button (which is a TextPicture object in reality), setting its bounds, and adding it to the screen
		btnMenu = new TextPicture();
		btnMenu.setFont(customFont);
		btnMenu.setTitle("<-- Back to Main Menu");
		btnMenu.setxPos(50);
		btnMenu.setyPos(600);
		btnMenu.setBounds(0, 0, 1000, 700);
		btnMenu.setColor(Color.RED);
		add(btnMenu);


		/*
		 * Mouse Listener that will change the screens as each appropriate button (which is in reality a TextPicture) is clicked
		 */
		addMouseListener(new MouseAdapter() {

			public void mouseClicked (MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				//JOptionPane.showMessageDialog(null, x + " ," + y);

				// play
				if ((x >= 50) && (x <= 270) && (y >= 580) && (y <= 600)) {
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
		f.add(new HelpPanel());
		f.setVisible(true);


	}

}
