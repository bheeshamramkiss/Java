import javax.swing.*;
import java.text.*;
/**
 * Date: Sept. 2017
 * Author: Bheesham Ramkisson
 * Description: Converts percentages to levels
 */
public class MarkConverter {
    
    
    public static void main(String[] args) { 
       Double percent; // decaring variables for percentile
       String answer = "yes";
       
       // keeps numbers to two decimal places
       NumberFormat number = NumberFormat.getInstance ();  
       number.setMaximumFractionDigits (2);
       
       // input
       while (answer.equalsIgnoreCase("yes") == true){
       percent = Double.parseDouble(JOptionPane.showInputDialog(null, "Hello! What is your precentile mark?"));
       
       // processing
       if (percent >= 80 && percent <= 100){
       JOptionPane.showMessageDialog(null, "Yay. You have a level 4.");
       JOptionPane.showInputDialog(null,"Would you like to enter again? Please say yes or no.", "Yes");
       }
       else if (percent >= 70 && percent <=79){
       JOptionPane.showMessageDialog(null, "Yay. You have a level 3.");
       JOptionPane.showInputDialog(null,"Would you like to enter again? Please say yes or no.", "Yes");
       }
       else if (percent >= 60 && percent <=69){
       JOptionPane.showMessageDialog(null, "Yay. You have a level 2.");
       JOptionPane.showInputDialog(null,"Would you like to enter again? Please say yes or no.", "Yes");
       }
       else if (percent >= 50 && percent <=59){
       JOptionPane.showMessageDialog(null, "Yay. You have a level 1.");
       JOptionPane.showInputDialog(null,"Would you like to enter again? Please say yes or no.", "Yes");
       }
       else if (percent >= 0 && percent <=49){
       JOptionPane.showMessageDialog(null, "Yay. You have a level R.");
       JOptionPane.showInputDialog(null,"Would you like to enter again? Please say yes or no.", "Yes");
       }
       else if (percent < 0){
       JOptionPane.showMessageDialog(null, "Please input a POSITIVE percentile.");
       JOptionPane.showInputDialog(null,"Would you like to play again? Please say yes or no.", "Yes");
       }
       } // ends while
    } // ends main

    
} // ends class
