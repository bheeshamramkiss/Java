import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date June 13, 2019
 * Description: Creates a custom font and allows for resizing.
 * 
 * METHOD LIST:
 * Font getCustomFont() -- getter for the font
 * void setFontSize(Float size) -- setter to allow for the resizing of the font
 * void main(String[] args) -- self testing main method
 *
 */
public class CustomFontMaker {

	/*
	 * private instance variables
	 */
	
	private static Font customFont;	

	//getter to return the font
	public static Font getCustomFont() {
		
		return customFont;
	}

	// setter that allows for resizing the font
	public static void setFontSize(Float size) {
		
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("8-bit pusab.ttf")).deriveFont(size);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * self testing main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
