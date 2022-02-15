import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date March 18th, 2019
 * Description: Plays a dice game between the user and computer.
 * 
 * Method List:
 * 
 * pointsCalc (int, int), returns int: Calculates the amount of points to be awarded to the appropriate player based on the 
 * values given from each die
 * 
 * pointsAdjust (int), returns int: a method that will deduct the 10 points per roll, and add the calculated points to either
 * player's points variable
 * 
 * playGame (void): calls upon the above listed methods to roll the die, deduct their 10 points per roll, add 
 * won points, and declare a winner when one or both players cannot afford to roll once more.
 * 
 * actionPerfomed (actionEvent): This method tells the program what to do when specific buttons are clicked within the GUI.
 */
public class ComputerUserDiceGame extends JFrame implements ActionListener {

	// declaring a pair of dice and the 100 initial points for the user and computer, as well as some buttons to use to roll and 
	// exit the program
	private Die d1 = new Die(), d2 = new Die();
	private int cPoints = 100, uPoints = 100;
	private JButton btnRoll, btnExit;
	private JTextArea displayArea = new JTextArea();


	public ComputerUserDiceGame() {
		super ("User vs. Computer");
		setLayout (null);

		// creating each button
		btnRoll = new JButton ("Roll Die");
		btnExit = new JButton ("Exit");

		// setting the location of the buttons, text area, and adding them to the window
		displayArea.setBounds(45, 10, 400, 80);
		btnRoll.setBounds(45, 95, 400, 20);
		btnExit.setBounds(175, 120, 150, 20);
		displayArea.setText("Computer Points: " + cPoints + "\tUser Points: " + uPoints);
		displayArea.setEditable(false);

		// adding each element to the window
		add(displayArea);
		add(btnExit);
		add(btnRoll);
		btnRoll.addActionListener(this);
		btnExit.addActionListener(this);

		setSize (500, 200);
		setResizable (false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // properly shuts down the program when it is closed via the "x" at
														// the top corner of the window
		setVisible(true);


	} // ends constructor

	// method to calculate the points that will be awarded to each player
	public int pointsCalc (int d1V, int d2V) {
		int points = 0, x = 0;
		x = d1V + d2V;

		points = (int) Math.sqrt((Math.pow(x, 2) + (3 * x) + 2));

		return points;
	} // ends the points calculation method

	// creating a method that rolls the dice, deducts 10 points, sends the die values for points calculation, and adds it to the 
	// respective player's points
	public int pointsAdjust(int userPoints) {

		// deducting 10 points for rolling the die
		userPoints -= 10;

		d1.rollDie();
		d2.rollDie();

		userPoints += pointsCalc(d1.getValue(), d2.getValue());

		return userPoints;
	}

	// this method is called when the game is played. It will cycle through multiple rolls of
	// die until a winner is declared
	public void playGame() {
		while ((uPoints >= 10) && (cPoints >= 10)) {
			uPoints = pointsAdjust(uPoints);
			cPoints = pointsAdjust(cPoints);
			displayArea.setText("Computer: " + cPoints + " User: " + uPoints);
		} // while

		// displaying the winner
		if (uPoints > cPoints) {
			displayArea.setText("\n\n\t     User Wins with " + uPoints + " to " + cPoints + ".");
		}

		else if (cPoints > uPoints) {
			displayArea.setText("\n\n\t     Computer Wins with " + cPoints + " to " + uPoints + ".");
		}

		else {
			displayArea.setText("Computer and User tie! Computer: " + cPoints + " User: " + uPoints + ".");
		}

	} // ends playGame

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new ComputerUserDiceGame();



	} // main

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnRoll) {

			// resetting the points so that if the user chooses to play a second time, the points will reset
			cPoints = 100;
			uPoints = 100;

			playGame(); // plays the game when the user hits roll die

			// this renames the button appropriately for the user if they want to play again, and removes
			// the clutter of making another button
			btnRoll.setText("Play Again?");

		}

		else if (evt.getSource() == btnExit) {
			JOptionPane.showMessageDialog(null, "Goodbye, Thank you for playing!");
			System.exit(0); // properly closes down the program
		}

	}

} // class
