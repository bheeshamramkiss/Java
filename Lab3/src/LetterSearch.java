import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 26, 2019
 * Description: Asks the user for a phrase and then for what letter they would want to search for.
 * Returns the amount of said letter present, as well as what indexes they are present at
 *
 */
public class LetterSearch {

	public static void main(String[] args) {

		int count = 0;
		String indexes = "\n";

		// Asking the user to enter a phrase, what letter they would like to search for, and assigning said
		// letter to a char variable
		String phrase = JOptionPane.showInputDialog(null, "Please enter a phrase of your choice!");
		String character = JOptionPane.showInputDialog(null, "Thank you! What letter would like to search for?");
		char c = character.charAt(0);

		//changing both the phrase and character the user inputs to upper case, so the program does not skip the count if
		//the character is out of case
		phrase = phrase.toUpperCase();
		c = Character.toUpperCase(c);
		
		// looping through the phrase to search for the given letter
		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == c) {
				count += 1;
			} // ends if statement
		} // for loop

		// searching the string and reporting the indexes at which the specified letter(s) are located
		for (int k = 0; k < phrase.length(); k++) {
			if (phrase.charAt(k) == c) {
				indexes += k + "\n";
			}
		}

		JOptionPane.showMessageDialog(null,  "There are " + count + " " + character +
				"'s present in the given phrase, and these are the indexes at which they are found: " + indexes);

	} // main

} // class
