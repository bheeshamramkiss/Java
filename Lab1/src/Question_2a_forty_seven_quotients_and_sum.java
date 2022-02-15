/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 7th, 2019
 * Description: Displays all the numbers from 3 to 47 that are divisible by 7 and their sum
 */
public class Question_2a_forty_seven_quotients_and_sum {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 3; i <= 47; i++) {
			if (i % 7 == 0) {
				System.out.println(i);
				sum += i;
			} // ends the if statement
		} // ends the for loop
		System.out.println("The sum of all these numbers is: " + sum);
	} // main

} // class
