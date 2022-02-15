import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author topiwala
 * Date: March 23rd, 2019
 * Description: class whcih contains the elements of a picture class which allows a user to draw an eye
 * 
 * Method List: 
 * public Picture() : has no input parameters and is a default constructor which will draw a rectangle
 * public Picture (int x, int y, int width, int height) : has 4 input parameters which will allow for an eye to be created
 * 					by manipulating the width, height, and position of the image
 * public void setColor(int r, int g, int b) : allows user to set the color of a shape based on RGB values
 * public void setColor(Color c) : setter for the color
 * public Color getC(): getter for the color, which returns the color
 * public void paint (Graphics g): executed when a component/images needs to be rendered. this method overrides jcomponent 
 * public int getxPos : returns value of x position getter
 * public int setxPos(int xPos) : setting value of x position, to be returned using x position
 * public int getyPos : returns value of y position getter
 * public int setyPos(int yPos) : setting value of y position, to be returned using y position
 * public int getMyWidth :  retuns value of width of the shape
 * public int setMyWidth(int myWidth) : setting value for width of shape
 * public int getMyHeight :  retuns value of height of the shape
 * public int setMyHeight(int myHeight) : setting value for width of shape
 * 
 * 
 * Main(): contains self testing main method
 */

public class Picture extends JComponent { // extending JComponent because extending allows us to inherit

	/*
	 * private instance data
	 * for color location and size
	 */

	private Color c;
	private int xPos, yPos, myWidth, myHeight;

	/**
	 * default constructor
	 */

	public Picture() {

		// attributes of default object

		this.c = Color.RED; 
		this.xPos = 100;
		this.yPos = 10;
		this.myWidth = 200;
		this.myHeight = 50;

		repaint();
	}

	// creating a different constructor to create objects of
	// different positions and sizes
	// overloaded constructor

	public Picture(int x, int y, int width, int height) {

		this.c = Color.RED;
		this.xPos = x;
		this.yPos = y;
		this.myWidth = width;
		this.myHeight = height;

		// calling paint method instead of JComponent, because there is a paint method
		// made by us
		repaint();
	}



	// setters and getters
	
	// getter for x pos
	public int getxPos() {

		return xPos;
	}
	
	// setter for x pos
	public void setxPos(int xPos) {
		this.xPos = xPos;
		repaint();

	}
	
	// getter for y pos
	public int getyPos() {
		return yPos;


	}
	
	// setter for y pos
	public void setyPos(int yPos) {
		this.yPos = yPos;
		repaint();

	}

	// getting the width
	public int getMyWidth() {
		return myWidth;
	}
	
	// setting the width
	public void setMyWidth(int myWidth) {
		this.myWidth = myWidth;
		repaint();
	}
	
	// getting my height
	public int getMyHeight() {
		return myHeight;
	}
	
	// setting my height
	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
		repaint();
	}

	// setter and getter for color
	public void setColor(Color c) {

		this.c = c;
		// color needs to be redrawn in picture
		repaint();
	
	}
	
	// getter for color
	public Color getC() {
		
		return c;
	}
	
	/**
	 * 
	 * @param r
	 * @param g
	 * @param b
	 * method which allows for the changing of color for shapes or anything else 
	 */
	public void setColor(int r, int g, int b ) {
		
		this.c = new Color(r, g, b);
		repaint();
	}


	// paint method for picture

	public void paint (Graphics g) {

		// 'this' is not required, however, is used to clarify code

		g.setColor(this.c);
		g.drawRect(this.xPos, this.yPos, this.myWidth, this.myHeight);
		g.drawOval(this.xPos, this.yPos, this.myWidth, this.myHeight);
		g.fillOval((this.xPos + this.myWidth / 2) - (this.myHeight / 2), this.yPos, this.myHeight, this.myHeight);
		repaint();

	}


	/**
	 * @param args
	 * self-testing main method
	 */
	public static void main(String[] args) {

		// creating JFrame object
		JFrame f = new JFrame();

		// calling the constructor and painting to jframe
		//Picture p = new Picture();

		f.setSize(400, 350);
		//f.add(p);
		f.setVisible(true);

	
		// calling the second constructor for painting, which has the following input parameters
		Picture p1 = new Picture (100, 10, 200, 50);
		f.add(p1);
		f.setVisible(true);
		
		
		p1 = new Picture(100, 100, 250, 50);
		f.add(p1);
		f.setVisible(true);
		
		Picture p2 = new Picture (50, 200, 200, 50);
		f.add(p2);
		f.setVisible(true);
		
		Picture p3 = new Picture (100, 250, 200, 5);
		f.add(p3);
		f.setVisible(true);
		

		p1.setColor(Color.BLUE);
		f.setVisible(true);
		
		p1.setColor(100, 200, 30);

		f.setVisible(true);
	 

	}

}
