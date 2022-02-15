import javax.swing.JOptionPane;
import java.text.*;
/**
 * Date: Sept. 2017
 * Author: Bheesham Ramkissoon
 * Description: A program that will give the price for a computer given the hardrive and RAM selection
 */
public class ddmComputerConfigPricing {
    
    
    public static void main(String[] args) { 
        
        String answer = "Yes";  // varibale to allow user to make another configuration for another computer
        
        // number formatting
        NumberFormat number = NumberFormat.getInstance ();  
        number.setMaximumFractionDigits (2);
        
        
        while (answer.equalsIgnoreCase("Yes")){
            String[] choices = { "4GB RAM, 500GB HDD", "4GB RAM, 750GB HDD", "8GB RAM, 500GB HDD", "8GB RAM, 750GB HDD", "16GB RAM, 500GB HDD", "16GB RAM, 750GB HDD" };
            String input = (String) JOptionPane.showInputDialog(null, "Choose your PC configuration",
                                                                "A1 PC Services", JOptionPane.QUESTION_MESSAGE, null,
                                                                
                                                                choices, // array for the choices
                                                                choices [0]); // beings the drop down with the first selective option
            
            double price, subTotal = 0, tax; // variables that will be used to calculate the total price of the computer
            
            // forming the prices with a comparative if statement
            if (input.equals ("4GB RAM, 500GB HDD")){
                subTotal = 599.99; 
            }
            else if (input.equals ("4GB RAM, 750GB HDD")){
                subTotal = 799.50;
            }
            else if (input.equals ("8GB RAM, 500GB HDD")){
                subTotal = 649.99;
            }
            else if (input.equals ("8GB RAM, 750GB HDD")){
                subTotal = 899.99;
            }
            else if (input.equals ("16GB RAM, 500GB HDD")){
                subTotal = 999.99;
            }
            else if (input.equals ("16GB RAM, 750GB HDD")){
                subTotal = 1229.99;
            }
            
            //making the prices
            tax = subTotal * 0.13;
            price = subTotal + tax;
            
            // output of final PC price
            JOptionPane.showMessageDialog(null,"The final price of your computer, with taxes, comes up to:\n$" + number.format(price));
            
            // prompts user of they want to make another PC
            answer = JOptionPane.showInputDialog("Would you like to make another PC?", "Yes");
        } // ends while
    } // ends main    
} // ends class
