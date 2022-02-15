/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @Date February 10th, 2019
 * Description: This program will display the matches that are played between 6 hockey teams in a tournament
 */
public class hockeyMatches {

	public static void main(String[] args) {
		for (int i = 1; i <= 6; i++) {
			for (int k = 1; k <= 6; k++) {
				if (i==k) {
					continue;
				} // ends the if command
				System.out.println("Team " + i + " will play team " + k);
			} // ends the inner for loop
		} // ends the for

	} // main

} // class
