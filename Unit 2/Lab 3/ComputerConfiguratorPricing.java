import javax.swing.*;
import java.text.*;
/**
 * Date: Sept. 2017
 * Author: Bheesham Ramkissoon
 * Description: A program that will give the price for a computer given the hardrive and RAM selection
 */
public class ComputerConfiguratorPricing {
    
    
    public static void main(String[] args) { 
        int ramSize, hddSize;  // variables for the HDD capacity and RAM capacity selection
        double price, subTotal = 0, tax; // variables that will be used to calculate the total price of the computer
        String answer = "Yes";  // varibale to allow user to make another configuration for another computer
            
            // number formatting
            NumberFormat number = NumberFormat.getInstance ();  
        number.setMaximumFractionDigits (2);
        
        while (answer.equalsIgnoreCase("yes")){
            //Input
            ramSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Hello and welcome to the computer config. Please Input the desired RAM you want. We have:\n4GB\n8GB\n16GB"));
            hddSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Okay, and what size HDD would you like? We have: 500GB\n750GB"));
            
            //Processing
            if (ramSize == 16 && hddSize == 750){
                subTotal = 1229.99;
            }
            else if (ramSize == 4 && hddSize == 500){
                subTotal = 599.99;
            }
            else if (ramSize == 4 && hddSize == 750){
                subTotal = 799.50;
            }
            else if (ramSize == 8 && hddSize == 500){
                subTotal = 649.99;
            }
            else if (ramSize == 8 && hddSize == 750){
                subTotal = 899.99;
            }
            else if (ramSize == 16 && hddSize == 500){
                subTotal = 999.99;
            }
            else {
                JOptionPane.showMessageDialog(null, "ERROR; please input a valid RAM/HDD amount");
            }
            
            //making the prices
            tax = subTotal * 0.13;
            price = subTotal + tax;
            
            // output of final PC price
            JOptionPane.showMessageDialog(null, "Alright. With " + ramSize + "GB of RAM, and " + hddSize + "GB of HDD storage, the final price of your computer comes up to:\n" + number.format(price));
            
            // prompts user to configure another pc
            JOptionPane.showInputDialog(null, "Would you like to choose and purchase another computer?", "Yes");    
            
        } // ends while   
               } // ends main

    
} // ends class
