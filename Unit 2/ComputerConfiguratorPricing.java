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
        String answer = "Yes";  // varibale to allow user to make another configuration for another computer
            
        // number formatting
        NumberFormat number = NumberFormat.getInstance ();  
        number.setMaximumFractionDigits (2);
        
        while (answer.equalsIgnoreCase("yes")){
            //Input
            ramSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Hello and welcome to the computer config. Please Input the desired RAM you want. We have:\n4GB\n8GB\n16GB"));
            hddSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Okay, and what size HDD would you like? We have: 500GB\n750GB"));
            
            //Processing / Output of final price
            if (ramSize == 4 && hddSize == 500){
                JOptionPane.showMessageDialog(null, "Alright. With " + ramSize + "GB of RAM, and " + hddSize + "GB of HDD storage, the price of your computer comes up to:" +
                                             "\nTotal: $599.99");
            }
            else if (ramSize == 4 && hddSize == 750){
                JOptionPane.showMessageDialog(null, "Alright. With " + ramSize + "GB of RAM, and " + hddSize + "GB of HDD storage, the price of your computer comes up to:" +
                                             "\nTotal: $799.50");
            }
            else if (ramSize == 8 && hddSize == 500){
                JOptionPane.showMessageDialog(null, "Alright. With " + ramSize + "GB of RAM, and " + hddSize + "GB of HDD storage, the price of your computer comes up to:" +
                                             "\nTotal: $649.99");
            }
            else if (ramSize == 8 && hddSize == 750){
                JOptionPane.showMessageDialog(null, "Alright. With " + ramSize + "GB of RAM, and " + hddSize + "GB of HDD storage, the price of your computer comes up to:" +
                                             "\nTotal: $899.99");
            }
            else if (ramSize == 16 && hddSize == 500){
                JOptionPane.showMessageDialog(null, "Alright. With " + ramSize + "GB of RAM, and " + hddSize + "GB of HDD storage, the price of your computer comes up to:" +
                                             "\nTotal: $999.99");
            }
            else if (ramSize == 16 && hddSize == 750){
                JOptionPane.showMessageDialog(null, "Alright. With " + ramSize + "GB of RAM, and " + hddSize + "GB of HDD storage, the price of your computer comes up to:" +
                                             "\nTotal: $1229.99");
            }
            else {
                JOptionPane.showMessageDialog(null, "ERROR; please input a valid RAM/HDD amount");
            }
            
            answer = JOptionPane.showInputDialog(null, "Would you like to choose and purchase another computer?", "Yes");    
            
        } // ends while   
               } // ends main

    
} // ends class
