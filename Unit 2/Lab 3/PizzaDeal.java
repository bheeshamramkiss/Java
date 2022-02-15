import javax.swing.*; 
import java.text.*;
/**
 * Date: Sept. 2017
 * Author: Bheesham Ramkissoon
 * Description: Calculates total price when user inputs number of slices and number of pops
 */
public class PizzaDeal {
    
    
    public static void main(String[] args) { 
        int pizzaSlices, pops;
        Double total, subTotal, tax, pizzaPrice, popPrice; // variables for the amount of piza slices and the amount of pops
        String answer = "yes";
        
        // setting numbers to two decimal places
        NumberFormat number = NumberFormat.getInstance ();  
        number.setMaximumFractionDigits (2);
        
        while (answer.equalsIgnoreCase("yes") == true){
            // input
            pizzaSlices = Integer.parseInt(JOptionPane.showInputDialog(null, "Hello! How many slices of pizza do you want?"));
            pops = Integer.parseInt(JOptionPane.showInputDialog(null,"Right, and how many pops would you like?"));
            
            // processing
            if (pizzaSlices < 3){
                pizzaPrice = pizzaSlices * 2.00;
            }
            
            else {
                pizzaPrice = pizzaSlices * 1.00;
            }
            
            popPrice = pops * 0.50;
            
            subTotal = pizzaPrice + popPrice;
            
            tax = subTotal * 0.13;
                
            total = subTotal + tax;
                
            // output
            JOptionPane.showMessageDialog(null, "Thank you for your service! Your total is: \n$" + number.format(total) + ".");
            
            // asking them for another transaction
            answer = JOptionPane.showInputDialog(null, "Would you like to do another purchase? Enter yes or no.", "yes");
        } // ends while
    }
    
    
} // ends class
