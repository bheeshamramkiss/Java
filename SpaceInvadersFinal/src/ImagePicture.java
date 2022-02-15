import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date March 20th, 2019
 * Description:
 *
 */
public class ImagePicture extends Picture {

	/*
	 * instance variable
	 */
	
	private ImageIcon image;
	
	/**
	 * 
	 */
	public ImagePicture(ImageIcon img) {
		super (); // call the Picture() constructor
		this.image = img;
		setMyWidth(img.getIconWidth());
		setMyHeight(img.getIconHeight());
		repaint();
	}
	
	/*
	 * Overloaded Constructor
	 */
	
	public ImagePicture(ImageIcon img, int x, int y) {
		super(x, y, img.getIconWidth(), img.getIconHeight());
		this.image = img;
		repaint();
	}
	
	/*
	 * override paint method from Picture
	 */
	public void paint (Graphics g) {
		this.image.paintIcon(this, g, getxPos(), getyPos());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		ImagePicture p = new ImagePicture(new ImageIcon("minion.png"));
		
		f.setSize(400, 350);
		f.add(p);
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Hollup bud...");
		
		ImagePicture p1 = new ImagePicture(new ImageIcon("minion.png"), 100, 100);
		f.add(p1);
		f.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "Hollup");
		p1.setxPos(0);
		
		p1.repaint();
		
	}

}
