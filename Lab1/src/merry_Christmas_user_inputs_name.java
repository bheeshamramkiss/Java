import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 7, 2019
 * Description: This program displays a merry Christmas message with any given user inputted name
 *
 */
public class merry_Christmas_user_inputs_name {

	// Method sayMerry will display the main line in the console with the aid of a for loop
	public static void sayMerry (String name) {
		for (int i = 0; i<3; i++) {
			System.out.println("We wish " + name + " a merry Christmas");
		} // ends the for loop

		System.out.println("and a happy New Year");

	} // end of sayMerry method

	// displays another part of the song
	public static void yourKin (String name) {
		System.out.println ("Glad tidings we bring");
		System.out.println ("To " + name + " and " + name + "'s kin");
		System.out.println ("Glad tidings for Christmas");
		System.out.println ("and a happy New Year!");
	} // ends yourKin

	// the figgyPudding method produces and displays the figgy pudding block of the song
	public static void figgyPudding() {
		for (int i = 0; i<3; i++) {
			System.out.println("We want some figgy pudding");
		} // ends the for loop

		System.out.println("Please bring it right here!");

	} // ends figgyPudding
	
	public static void wontGo() {
		for (int i = 0; i<3; i++) {
			System.out.println("We won't go until we get some");
		} // ends the for loop
		
		System.out.println("So bring it out here!");
		
	} // ends wontGo
	
	public static void main(String[] args) {
		String name;
		name = JOptionPane.showInputDialog(null, "What is your name?");
		sayMerry(name);
		yourKin(name);
		figgyPudding();
		yourKin(name);
		wontGo();
		yourKin(name);
		sayMerry(name);
		yourKin(name);
	} // ends main

} // ends class
	