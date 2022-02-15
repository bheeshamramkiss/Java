import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date May 28, 2019
 * Description: The Enemy class used to create enemy objects for the Space Invaders Game.
 *
 */
public class Enemy extends Picture{

	/*
	 * Private instance variables
	 */

	private int scale; // variable used to control the sizing of the enemy objects
	private ImageIcon laser;
	private int laserX, laserY;
	private boolean shoot;

	/**
	 * default constructor
	 */
	public Enemy() {
		setxPos(0);
		setyPos(0);
		setScale(1);
		setColor(Color.BLACK);
		repaint();
		try {
			laser = new ImageIcon(ImageIO.read(getClass().getResource("Player Laser.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error loading the player laser image.");
		}
		laserX = getxPos();
		laserY = getyPos();
		shoot = false;
	}

	/*
	 * overloaded constructor allowing the user to create an enemy at a given x and y position
	 * onscreen
	 */

	public Enemy(int x, int y, int scale) {
		setxPos(x);
		setyPos(y);
		setScale(scale);
		setColor(Color.BLACK);
		repaint();
		try {
			laser = new ImageIcon(ImageIO.read(getClass().getResource("Player Laser.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error loading the player laser image.");
		}
		laserX = getxPos();
		laserY = getyPos();
		shoot = false;
	}

	/*
	 * setter and getter for the enemy
	 */

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	/*
	 * paint method to paint the enemy
	 */

	public void paint (Graphics g) {

		if (shoot) {
			this.laser.paintIcon(this, g, laserX, laserY);
			shootForward();
			//shootTimer.start();
		}
		
		g.setColor(this.getC());

		// upper ear (left)
		g.fillRect((getxPos() + getScale() * 2), (getyPos() + scale * 0), scale * 1, scale * 1);

		// lower ear (left)
		g.fillRect((getxPos() + scale * 3),(getyPos() +  scale *  1), scale * 1, scale * 1); 

		// row under "ears"
		g.fillRect((getxPos() + scale * 2), (getyPos() +  scale * 2), scale * 7, scale * 1); 

		// row to the left of the left eye
		g.fillRect((getxPos() +  scale * 1), (getyPos() + scale * 3), scale * 2, scale * 1);

		// row under eyes
		g.fillRect((getxPos() +  scale * 0), (getyPos() + scale * 4), scale * 11, scale * 1);

		// row between eyes
		g.fillRect((getxPos() + scale * 4), (getyPos() + scale * 3), scale * 3, scale * 1); 

		// bottom left rectangle
		g.fillRect((getxPos() + scale * 0), (getyPos() + scale * 5), scale * 1, scale * 2);  

		// hanger piece for the bottom two "fangs" (left)
		g.fillRect((getxPos() + scale * 2), (getyPos() + scale * 5), scale * 1, scale * 2); 

		// bottom fangs (left)
		g.fillRect((getxPos() +  scale * 3), (getyPos() + scale * 7), scale * 2, scale * 1);

		// row in between the fangs
		g.fillRect((getxPos() + scale * 3), (getyPos() + scale * 5), scale * 6, scale * 1); 

		// bottom right rectangle
		g.fillRect((getxPos() + scale * 10),(getyPos() + scale * 5), scale * 1, scale * 2);

		// row to the right to of the right eye
		g.fillRect((getxPos() + scale * 8), (getyPos() + scale * 3), scale * 2, scale * 1); 

		// upper ear (right)
		g.fillRect((getxPos() + scale * 8), (getyPos() + scale * 0), scale * 1, scale * 1); 

		// lower ear (right)
		g.fillRect((getxPos() + scale * 7), (getyPos() + scale * 1), scale * 1, scale * 1); 

		// hanger piece for the bottom two "fangs" (right)
		g.fillRect((getxPos() + scale * 8), (getyPos() + scale * 5), scale * 1, scale * 2); 

		// bottom fangs (right)
		g.fillRect((getxPos() + scale * 6), (getyPos() + scale * 7), scale * 2, scale * 1); 

	}
	
	// Return boundaries of laser for collision detection
	public Rectangle bounds() {
		return (new Rectangle (laserX + 17, laserY + 19, 8, 29));
	}
	
	// Return boundaries of enemy for collision detection
	public Rectangle bounds(boolean n) {
		return (new Rectangle(getxPos() + scale * 0, getyPos() + scale * 0, scale * 11, scale * 8));
	}
	
	// Shoot method
	public void shoot() {
		laserX = getxPos() + 7;
		laserY = getyPos();
		shoot = true;
	}
	
	// Shooting laser forward
	public void shootForward() {
		laserY += 1;
	}
		
	// Setter for LaserX
	public void setLaserX(int x) {
		this.laserX = x;
	}

	/**
	 * self testing main method
	 */
	public static void main(String[] args) {

		// testing creation and display of an enemy object
		JFrame f = new JFrame();
		Enemy e1 = new Enemy();

		f.setSize(400, 350);
		f.add(e1);
		f.setVisible(true);

		// testing to see if the color of the enemy can be changed
		JOptionPane.showMessageDialog(null, "You should now see a red enemy object.");
		e1.setColor(Color.RED);
		f.setVisible(true);

		// testing to paint the enemy in a different position on the screen
		JOptionPane.showMessageDialog(null, "You should now see the enemy in a different location.");
		e1.setxPos(100);
		e1.setyPos(100);
		f.setVisible(true);

		// testing scale (and overloaded constructor)
		JOptionPane.showMessageDialog(null, "A new, bigger enemy has appeared!");
		f.remove(e1);
		f.setVisible(true);
		Enemy e2 = new Enemy(100, 100, 5);
		e2.setColor(Color.BLUE);
		f.add(e2);
		f.setVisible(true);




	}
}
