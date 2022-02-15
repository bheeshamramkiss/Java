/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date March 6th, 2019
 * Description: Creates 6 die and rolls until their values are equal. Displays the number of rolls
 * executed and the value of the die when they are all equal
 *
 */
public class SixDiceGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Die d1, d2, d3, d4, d5, d6;
		int counter = 0;
		
		// creating 6 die objects
		d1 = new Die();
		d2 = new Die();
		d3 = new Die();
		d4 = new Die();
		d5 = new Die();
		d6 = new Die();
		
		while (true) {
			counter++;

			
			if ((d1.checkValues(d2)) && (d2.checkValues(d3)) && (d3.checkValues(d4)) && (d4.checkValues(d5)) && (d5.checkValues(d6)) == true ) {
				break;
			} // if
			
			d1.rollDie();
			d2.rollDie();
			d3.rollDie();
			d4.rollDie();
			d5.rollDie();
			d6.rollDie();
			
		} // while
		
		System.out.println("It took " + counter + " rolls to get six identical die values of: " + d1.getValue());

	} //main

} // class
