import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date March 19, 2019
 * Description:
 *
 * METHOD LIST:
 * 
 */
public class Picture extends JComponent{
	/*
	 * Private instance data
	 * for colour, location and size
	 */
	private Color c;
	private int xPos, yPos, myWidth, myHeight;
	
	/**
	 * Default Constructor
	 */
	public Picture() {
		this.c = Color.RED;
		this.xPos = 0;
		this.yPos = 0;
		this.myWidth = 50;
		this.myHeight = 25;
		repaint();
	}
	
	// setters and getters
	public void setColor(Color c) {
		this.c = c;
		repaint();
	}
	
	// overloaded setter
	public void setColor (int r, int g, int b) {
		this.c = new Color (r, g, b);
		repaint();
	}
	
	public void setxPos(int xPos) {
		this.xPos = xPos;
		repaint();
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
		repaint();
	}

	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
		repaint();
	}

	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
		repaint();
	}

	// getters for color, x position, y position, etc.
	
	public Color getC() {
		return c;
	}

	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getMyWidth() {
		return myWidth;
	}

	public int getMyHeight() {
		return myHeight;
	}

	// paint method for Picture
	public void paint (Graphics g) {
		g.setColor(this.c);
		g.drawRect(this.xPos, this.yPos, this.myWidth, this.myHeight);
	}
	
	// create a different constructor to allow me to
	// create objects of different locations and sizes
	// overloaded constructor
	public Picture(int x, int y, int w, int h) {
		this.c = Color.RED;
		this.xPos = x;
		this.yPos = y;
		this.myWidth = w;
		this.myHeight = h;
		repaint();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		Picture p = new Picture();
		
		f.setSize(400, 350);
		f.add(p);
		f.setVisible(true);
		
		Picture p1 = new Picture (100, 100, 25, 50);
		
		f.add(p1);
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Wait, I'm an i3. Can't process that fast.");
		
		p1.setColor(Color.BLUE);
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Wait again you bean...");
		
		p.setxPos(200);
		p.setyPos(172);
		p.setMyHeight(70);
		p.setMyWidth(17);
		
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Wait YOU NUBBER BUBBER");
		
		p1.setColor(100, 200, 30);
		f.setVisible(true);

	}

}
