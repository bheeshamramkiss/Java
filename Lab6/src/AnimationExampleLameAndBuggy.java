import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*; // for jar file

/**
 * AnimationExampleLameAndBuggy.java
 *
 *
 * @author Bheesham Ramkissoon
 * @date April 2, 2019
 * Description: paints as many minions on screen as per the user's desire and has them bounce around the frame
 * 
 * Method List:
 * spawnPicture(SmartMinion[] pics, int[] xPos, int[] yPos, int[] xVel, int yVel[], int i)
 * spawnPicture takes its given parameters and creates and places each image onto the drawingPanel
 * 
 * actionPerformed(ActionEvent e)
 * actionPerformed is a method from the ActionListener class that dictates that will happen when each button on the controlPanel
 * is pressed
 * 
 * main(String[] args)
 * the main method that runs first when the program runs. Prompts the user for the image file name, as well as the number of
 * images to be displayed
 */

public class AnimationExampleLameAndBuggy extends JFrame implements ActionListener {

	//instance variable for components
	private JPanel drawingPanel, controlPanel;
	private JButton btnStart, btnStop, btnExit, btnResume;

	// instance variables for picture arrays, speed and positions
	private SmartMinion pics[]; 
	private int xPos[], yPos[], xVel[], yVel[];
	private Timer timer; // animation timer
	private int width, height; // height and width of frame
	private Die d1, d2, d3, d4; // dice to randomize location and speeds
	private TextPicture title;

	/**
	 * Creates a new instance of AnimationExample.
	 */
	public AnimationExampleLameAndBuggy(int numPics, String fileName) {
		super("My Simple Animation Example"); // title for the frame

		// initialize the width of the frame
		width = 400;
		height = 600;

		setLayout(null); // layout for my frame

		controlPanel = new JPanel(); // panel for buttons
		drawingPanel = new JPanel(); // used only to set the boundaries to draw

		btnStart = new JButton("Let's move"); // create button
		btnStop = new JButton("Stop");
		btnExit = new JButton("Exit");
		btnResume = new JButton("Resume");

		// set the size and position of the panels
		drawingPanel.setBounds(0, 50, width, height - 150);
		drawingPanel.setLayout(null); // set layout of drawing panel

		controlPanel.setBounds(0, height - 100, width, 100);

		// add components to panels
		controlPanel.add(btnStart); // button to control panel
		controlPanel.add(btnStop);
		controlPanel.add(btnResume);
		controlPanel.add(btnExit);		

		// for each picture object, add the image
		// randomize its initial position using the Die class
		// and place the object on the drawingPanel
		// also creating a new title to be added at the top of the window

		title = new TextPicture();
		title.setTitle("King Soup!");
		title.setFont(new Font ("Monospaced", Font.BOLD, 30));
		title.setBounds(0, 0, width, 50);
		title.setxPos(115);
		title.setyPos(25);
		add(title);

		// setting the size of each array as per the user's given input
		pics = new SmartMinion[numPics];
		xPos = new int [numPics];
		yPos = new int [numPics];
		xVel = new int [numPics];
		yVel = new int [numPics];

		// for loop that creates all the pictures
		for (int i = 0; i < pics.length; i++) {
			pics[i] = new SmartMinion(new ImageIcon(fileName));
			pics[i].setBounds(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());

		}

		// creating the die objects and setting their limits
		d1 = new Die(drawingPanel.getWidth() - pics[0].getMyWidth());
		d2 = new Die(drawingPanel.getHeight() - pics[0].getMyHeight());
		d3 = new Die();
		d4 = new Die(200);

		// cycling through each individual picture and spawning them into the window (drawingPanel)
		for (int i = 0; i < pics.length; i++) {
			spawnPicture(pics, xPos, yPos, xVel, yVel, i);			
		}

		add(controlPanel); // add the button and drawing panels to the frame
		add(drawingPanel);

		timer = new Timer(15, this); // creates a timer and this class as the listener. set to fire every 20ms
		timer.setInitialDelay(5); // set the initial delay to 5 ms before it starts

		// add button as a listener in this frame
		btnStart.addActionListener(this);
		timer.addActionListener(this);
		btnStop.addActionListener(this);
		btnResume.addActionListener(this);
		btnExit.addActionListener(this);

		// set size and location of frame
		setSize(width, height);
		setLocation(100, 100);

		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/*
	 * Method to add each image to the drawingPanel
	 * by setting the x, y positions and velocities
	 */

	public void spawnPicture(SmartMinion[] pics, int[] xPos, int[] yPos, int[] xVel, int yVel[], int i) {
		// roll the dice to generate x, y positions and velocities
		d1.rollDie();
		d2.rollDie();
		d3.rollDie();
		d4.rollDie();

		// setting the x, y positions and velocities
		// place the image based on the first two dice
		xPos[i] = d1.getValue();
		yPos[i] = d2.getValue();

		pics[i].setxPos(xPos[i]);
		pics[i].setyPos(yPos[i]);

		// set the speed based on the value to the third die
		xVel[i] = d3.getValue();
		yVel[i] = d3.getValue();

		//setting the steps to move for each minion
		if(d4.getValue() > 100) {
			pics[i].setStepsToMove(d4.getValue());
		}
		else {
			pics[i].setStepsToMove(100);
		}

		drawingPanel.add(pics[i]);
	}

	// method for actions events
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnStart) { // if btn is clicked start timer
			for (int i = 0; i < pics.length; i++) {
				spawnPicture(pics, xPos, yPos, xVel, yVel, i);			
			}

			timer.start();
		} else if (e.getSource() == timer) {
			// if the timer fires, go through each of the
			// pictures and set its new position
			
			//subtracting 1 from the stepsToMove of each object, and them seeing if the stepsToMove left is 0 or not
			for (int k = 0; k < pics.length; k++) {
				pics[k].setStepsToMove((pics[k].getStepsToMove() - 1));
				
				// if there are still steps to move, move the images. if not, stop them
				if (pics[k].getStepsToMove() > 0) {
					xPos[k] += xVel[k];
					yPos[k] += yVel[k];
	
					// change the position of the first image
					pics[k].setxPos(xPos[k]);
					pics[k].setyPos(yPos[k]);
	
					// check for the boundaries to reverse direction
					if (xPos[k] > (drawingPanel.getWidth() - pics[k].getMyWidth())) {
						xVel[k] *= -1; // reverse speed
					} else if (xPos[k] < 0) {
						xVel[k] *= -1; // reverse speed
					} // if x pos
	
					if (yPos[k] > (drawingPanel.getHeight() - pics[k].getMyHeight())) {
						yVel[k] *= -1; // reverse speed
					} else if (yPos[k]< 0) {
						yVel[k] *= -1; // reverse speed
					} // if ypos
				}
				else {
					xPos[k] += 0;
					yPos[k] += 0;
				}
				
			}
			

		} // if timer
		
		else if (e.getSource() == btnStop){
			timer.stop();
		}
		
		else if (e.getSource() == btnResume){
			timer.start();
		}
		
		else if (e.getSource() == btnExit){
			JOptionPane.showMessageDialog(null, "Good-Bye.");
			System.exit(0);
		}

	}// actionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String fileName = JOptionPane.showInputDialog(null, "What is the filename of the picture you'd like displayed?", "supra2.png");
		int numPics = Integer.parseInt(JOptionPane.showInputDialog(null, "How many pictures would you like on screen?"));
		AnimationExampleLameAndBuggy animation = new AnimationExampleLameAndBuggy(numPics, fileName);
	}
}