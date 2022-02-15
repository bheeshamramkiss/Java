import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date March 22nd, 2019
 * Description: Creates a string and displays it in a JFrame, and allows for the string to be changed
 * alongside the color, font, and size
 * 
 * METHOD LIST:
 * setTitle: allows the user to change the title variable
 * setFont: allows the font to be changed.
 *
 */
public class TextPicture extends Picture {
	/*
	 * private variables
	 */
	private String title;
	private Font font;


	// generating setter methods for the title and font	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * simple constructor to create a String of text object
	 */
	public TextPicture() {
		super();
		this.font = new Font ("SansSerif", font.ITALIC, 12);
		this.title = "My Title";
		repaint();
	}

	/*
	 * paint method to draw
	 */

	public void paint (Graphics g) {
		g.setColor(getC());
		g.setFont(this.font);
		g.drawString(title, getxPos(), getyPos());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		TextPicture tP = new TextPicture();
		tP.setxPos(0);
		tP.setyPos(75);
		

		f.setSize(600, 400);
		f.add(tP);
		f.setVisible(true);
		
		//testing to ensure the title remains the same regardless of position, as well as testing the font
		// and title setters
		JOptionPane.showMessageDialog(null,  "You should now see a new font, position, title and color.");
		
		tP.setColor(Color.BLUE);
		tP.setxPos(200);
		tP.setyPos(150);
		tP.setTitle("Bheesham Ramkissoon");
		tP.setFont(new Font ("Monospaced", Font.BOLD, 30));
		
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null,  "tseeting...");
		
		f.setLayout(null);
		tP.setxPos(0);
		tP.setyPos(0);
		tP.setBounds(100, 100, 300, 200);
		f.setVisible(true);
		
		
		JOptionPane.showMessageDialog(null,  "That is all. Goodbye.");
		
		System.exit(0);



	}

}
