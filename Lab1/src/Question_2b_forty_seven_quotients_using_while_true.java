/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 7th, 2019
 * Description: Displays all numbers from 3 to 47 that are divisible by 47, and shows their sum at the end
 *
 */
public class Question_2b_forty_seven_quotients_using_while_true {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		int counter = 3;
		while (true) {
			if (counter % 7 == 0) {
				System.out.println(counter);
				sum += counter;
			} // ends the if
			
			else if (counter >= 48) {
				break;
			} // else if
			
			counter +=1;
			
		} // ends the while
		
		System.out.println("The sum of all these numbers is: " + sum);
		
	} // main

} // class
