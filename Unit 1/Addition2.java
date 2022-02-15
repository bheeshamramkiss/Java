import javax.swing.*;
/**
 * Date: Sept. 2017
 * Author: Bheesham Ramkissoon
 * Description: A program that asks for two numbers and their name
 *              and adds the two numbers
 */
public class Addition2 {
    
    
    public static void main(String[] args) { 
       int firstNumber;   // Declaring variables for two numbers, sum, and user's name
       int secondNumber;
       int sum;
       String userName;
       
       // as for user name and two numbers
        userName = JOptionPane.showInputDialog (null, "Enter your name.");
        
        firstNumber = Integer.parseInt(JOptionPane.showInputDialog (null, "Enter first number"));
        
        secondNumber = Integer.parseInt (JOptionPane.showInputDialog (null, "Enter second number"));
        
        sum = firstNumber + secondNumber;  //add the numbers
        
        //output
        JOptionPane.showMessageDialog (null, "Hi " + userName + "! Your result is " + sum + ".");
       
    }
    
}
