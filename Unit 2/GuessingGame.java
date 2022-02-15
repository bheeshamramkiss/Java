import javax.swing.* ;
/**
 * Date: Sept. 2017
 * Author: Bheesham Ramkissoon
 * Description: This is a guessing game where the user enterss a number from 1 to 10.
 */
public class GuessingGame {
    
    
    public static void main(String[] args) { 
        int userGuess, computerGuess; // variables for ser and computer guesses
        String answer = "yes"; // user answer to go again
        
        while (answer.equalsIgnoreCase("yes") == true){
            // ask user for their guess
            userGuess = Integer.parseInt (JOptionPane.showInputDialog(null, "Enter a number from 1 to 10"));
            computerGuess = (int)(Math.random()*10+1); // set the computer guess
            
            // checking if if user entered correct number
            if (userGuess == computerGuess){
                JOptionPane.showMessageDialog(null, "Yay. You did it. -_-\nThe Computer guessed: " + computerGuess + "\nYou guessed: " + userGuess );                                         
            }
            else if (userGuess > computerGuess){
                JOptionPane.showMessageDialog(null, "Sorry, too high. dummy\nThe Computer guessed: " + computerGuess + "\nYou guessed: " + userGuess);
            }
            else {
                JOptionPane.showMessageDialog(null, "Too low man......\n The Computer guessed: " + computerGuess + "\nYou guessed: " + userGuess);
            }
            
            //prompt user if they want to guess again
            answer = JOptionPane.showInputDialog(null, "Do you wanna play again? Enter yes or no");
        } // ends while
    } // ends manin
    
    
} // ends class
