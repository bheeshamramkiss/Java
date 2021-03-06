import javax.swing.*;
import java.text.*;
/**
 * Date: Oct. 2017
 * Author: Bheesham Ramkissoon
 * Description: Allows the user input any number, and it will display that number in different manipulations
 */
public class NumberMagic {
    
    
    public static void main(String[] args) { 
        double userInput;
        
        userInput = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter your number of choice!")); // prompting the user for their number
        
        NumberFormat format = new DecimalFormat("0.00"); // setting the decimal count to two places
        
        JOptionPane.showMessageDialog (null, "Your number rounded is; " + Math.round(userInput) 
                                           + "\nYour number square rooted; " + format.format(Math.sqrt(userInput)) 
                                           + "\nYour number to the power of 5 is; " + format.format(Math.pow(userInput,5)) 
                                           + "\nYour number to two decimal places " + format.format(userInput)); // displaying the various answers      
    } //ends main

    
} // ends class
