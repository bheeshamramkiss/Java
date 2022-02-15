import java.text.NumberFormat;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 10th, 2019
 * Description: Will calculate the final velocity of a free falling object given the initial velocity and height fallen
 */
public class Free_fall_speed_calculator {

	// this method converts the speed in meters per second (m/s) into kilometers per hour (km/h)
	public static double speedConverter (double velocityFinal) { // this method converts the speed from meters per second into km/h
		double kmh = velocityFinal*3.6;
		return kmh;
	} // ends the speed converter method

	// this method uses the initial speed and height fallen given by the user to calculate the final speed
	// of a falling object, using the math functionality from the Java API
	public static double speedCalculator(double initialSpeed, double heightFallen) {
		double finalSpeed = Math.sqrt((Math.pow(initialSpeed, 2) + (2*9.8*heightFallen)));
		return finalSpeed;
	} // ends the speedCaclulator method

	public static void main(String[] args) {

		//making a number format to keep the velocties to three decimal places
		NumberFormat nf = NumberFormat.getNumberInstance();

		double velocityInitial [] = new double [4];
		double heightFallen [] = new double [4];
		double velocityFinal [] = new double [4]; // variables for the height the object has falled, and both final and initial velocities
		String response = "y"; // variable for the user's response on whether they want to make another calculation or not.
		while (response.equalsIgnoreCase("y") == true) {

			for (int i = 0; i < velocityInitial.length; i++) {
				// asks the user for the inital velocity in meters per second
				velocityInitial [i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Hello! This program will calculate the final velocity\nof a free falling object"
						+ " given its initial velocity and total drop height.\n Let's start initial velocity (m/s) #" + (i+1) + " if you would be so kind please"
						+ "(if there is none, just put zero)."));

				// asks the user for the height that the object has fallen in meters
				heightFallen [i] = Double.parseDouble(JOptionPane.showInputDialog (null, "Thank you! Now, what is total height #" + (i+1) + " from which this object"
						+ " fell in meters please?"));

				// calculates the final velocity of the falling object by passing the initial speed and height to another method
				velocityFinal [i] = speedCalculator (velocityInitial [i], heightFallen [i]);

				// displaying the final velocity in m/s and km/h by calling the speedConverter method
				JOptionPane.showMessageDialog(null,  "Final speed #" + (i+1) + " of this falling object is:\n" + nf.format(velocityFinal [i]) + "m/s and\n"
						+ nf.format(speedConverter(velocityFinal [i])) + "km/h." );

			} // ends the for loop


			JOptionPane.showMessageDialog(null, "Your final speeds are:\n#1: " + nf.format(velocityFinal[0]) + "m/s and " + nf.format(speedConverter(velocityFinal [0])) + "km/h" + "\n#2: " + nf.format(velocityFinal[1])
					+ "m/s and "+ nf.format(speedConverter(velocityFinal [1])) + "km/h" + "\n#3: " + nf.format(velocityFinal [2]) + "m/s and " + nf.format(speedConverter(velocityFinal [2])) + "km/h" + "\n"
							+ "#4: " + nf.format(velocityFinal[3]) + "m/s and " + nf.format(speedConverter(velocityFinal [3])) + "km/h");

			response = JOptionPane.showInputDialog(null, "Would you like to make another calculation? Type 'y' or 'Y' for yes\n"
					+ " or 'n' or 'N' for no.");
		} // while


		JOptionPane.showMessageDialog(null,  "Good-Bye.");

	} // main

} // class
