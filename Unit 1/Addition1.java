import java.util.*; 
import javax.swing.*;
/**
 * Date: Sept. 2017
 * Author: Bheesham Ramkissoon
 * Description: A program that asks for two numbers and their name
 *              and adds the two numbers
 */
public class Addition1 {
    
    
    public static void main(String[] args) { 
       int firstNumber;   // Declaring variables for two numbers, sum, and user's name
       int secondNumber;
       int sum;
       String userName;
       
       // setup for keyboard input
       Scanner input = new Scanner (System.in);
       
       //prompt user for user name and get it
       System.out.println("Enter your name");
       userName = input.next();
       
       // ask user for first and second numbers and get them
       System.out.println ("Enter first number");
       firstNumber = input.nextInt();
       
       //ask user for second number and get it
       System.out.println("Enter second number");
       secondNumber = input.nextInt();
       
       sum = firstNumber + secondNumber;  //add the numbers
       
       // output
       JOptionPane.showMessageDialog(null, "Hi " + userName + "! Your result is " + sum + ".");
       
    }

}
