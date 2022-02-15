import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 
 */

/**
 * @author Asad
 *
 */
public class Player extends Picture implements ActionListener{

	private ImageIcon player;
	private ImageIcon laser;
	private int laserX, laserY;
	private int dx, dy;
	private Timer move;
	private boolean shoot;

	public Player(ImageIcon player) {
		super (); // call the Picture() constructor
		this.player = player;
		setMyWidth(player.getIconWidth());
		setMyHeight(player.getIconHeight());
		try {
			laser = new ImageIcon(ImageIO.read(getClass().getResource("Player Laser.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error loading the player laser image.");
		}
		laserX = getxPos();
		laserY = getyPos();
		dx = 0;
		dy = 0;
		move = new Timer(20, this);
		move.start();
		shoot = false;
		setFocusable(true);
	}

	// Overloaded constructor
	public Player(ImageIcon player, int xPos, int yPos) {
		super(xPos, yPos, player.getIconWidth(), player.getIconHeight());
		this.player = player;
		repaint();
		try {
			laser = new ImageIcon(ImageIO.read(getClass().getResource("Player Laser.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error loading the player laser image.");
		}
		laserX = getxPos();
		laserY = getyPos();
		dx = 0;
		dy = 0;
		move = new Timer(20, this);
		move.start();
		shoot = false;
		setFocusable(true);
	}

	// Paint method overloaded
	public void paint (Graphics g) {

		// If the shoot variable is true
		if(shoot) {
			this.laser.paintIcon(this, g, laserX, laserY);
			this.player.paintIcon(this, g, getxPos(), getyPos());
			shootForward();
		}
		else {
			this.player.paintIcon(this, g, getxPos(), getyPos());
		}
	}

	// Shoot method
	public void shoot() {
		laserX = getxPos() + 26;
		laserY = getyPos() - 25;
		shoot = true;
	}
	
	public void shootForward() {
		laserY -= 1;
	}
	
	// Creates rectangle around laser for collision detection
	public Rectangle bounds() {
		return (new Rectangle (laserX + 17, laserY + 19, 8, 29));
	}
	
	// Creates rectangle around player for collision detection
	public Rectangle bounds(boolean n) {
		return (new Rectangle (getxPos() + 20, getyPos(), 55, 100));
	}
	
	// Setter to reset laser
	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	
	// Getter for the laser location
	public int getLaserX() {
		return this.laserX;
	}
	
	public int getLaserY() {
		return this.laserY;
	}
	
	// Setter for laserX
	public void setLaserX(int x) {
		this.laserX = x;
	}
	
	// Setters for dx and dy
	public void setDX(int dx) {
		this.dx = dx;
	}
	
	public void setDY(int dy) {
		this.dy = dy;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == move) {
			setxPos(getxPos() + dx);
			setyPos(getyPos() + dy);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
