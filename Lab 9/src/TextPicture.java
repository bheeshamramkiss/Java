import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author topiwala
 * Date: March 23rd, 2019
 * Description: class which inherits from Picture class and displays and modifies through changing font, color, and position
 * 
 * Method List: 
 * 
 * public void setFont(Font font) : sets for the font of the text
 * public void setTitle(String title) : sets the title to be used 
 * public TextPicture() : default constructor which just takes a text and outputs it using the coordinates from the super class
 * public TextPicture(String titleNew, Font fontNew, int x, int y) : overloaded constructor which inherits constructor from the super class, and font is set using the 
 * 																	setFont and setTitle getter methods.
 * public void paint(Graphics g): paint method which overrides the paint methodf from the super class. this paints the text to the screen.
 * Main(): self testing main method
 * 
 **/

public class TextPicture extends Picture{


	/**
	 * Private Variables
	 */

	private String title = "";
	private Font font;


	// setters and getters for the font and title
	
	/**
	 * settter for the font
	 */
	public void setFont(Font font) {
		this.font = font;
		
		// repainting
		repaint();
	}

	/**
	 * settter for the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	/**
	 * default constructor which just outputs title to the screen
	 */
	public TextPicture(String titleNew) {
		
		// calling super class to inherit its methods and such
		super();
		
		this.title = titleNew;
		
		repaint();
	}

	/**
	 * 
	 * @param titleNew
	 * @param fontNew
	 * @param x
	 * @param y
	 * overloaded constructor which modifies the title using font, and uses x and y coordinates to change position of title
	 */
	
	public TextPicture(String titleNew, Font fontNew, int x, int y) {
		// TODO Auto-generated constructor stub
		
		super();
		this.title = titleNew;
		
		// setting font and title using assosciated setter methods
		setFont(fontNew);
		setTitle(titleNew);
		
		// setting x and y positions using the setter methods in the super class
		setxPos(x);
		setyPos(y);
		
		// repainting using the paint method
		repaint();
	}
	
	/**
	 * paint method which overrides the paint method of the super class
	 */
	public void paint(Graphics g) {
		
		// setting color, font, and drawing the string using the by using the getters from the super class
		g.setColor(getC());
		g.setFont(this.font);
		g.drawString(this.title, getxPos(), getyPos());
		
		// repaint
		repaint();
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// jframe initialization
		JFrame f = new JFrame("TextPicture");
		
		// testing string
		String titleInput = "hello world testing";
		
		// initialiation of different fonts and sizes
		Font font = new Font("Monospaced", Font.PLAIN, 20);
		Font font2 = new Font("Arial Black", Font.PLAIN, 15);
		
		// text picture value, which takes in the text (default constructor)
		TextPicture text2 = new TextPicture(titleInput);
		
		// setting size of frame, adding element to frame, and setting the frame to be visible
		f.setSize(400, 350);
		f.add(text2);
		f.setVisible(true);
		
		// using overloaded constructor
		TextPicture text = new TextPicture(titleInput, font, 100, 100);
		
		// setting color of text to blue
		text.setColor(Color.BLUE);
		
		f.setSize(400, 350);
		f.add(text);
		f.setVisible(true);
		
		// delay
		//JOptionPane.showMessageDialog(null, "wait");
		
		// color to red
		text.setColor(Color.RED);
		
		// delay
		//JOptionPane.showMessageDialog(null, "wait");
		
		// changing font, x position, and y position, and color of the text
		text.setFont(font2);
		text.setxPos(150);
		text.setyPos(300);
		text.setColor(Color.blue);
		
		// adding element to frame and setting the changes to be visible
		f.add(text);
		f.setVisible(true);



	}

}
