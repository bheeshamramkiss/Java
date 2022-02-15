import javax.swing.*;
import java.text.*;
/**
 * Date: November 2017
 * Author: Bheesham Ramkissoon & Emmanuel Joseph
 * Description:hsi program calculates and displays a computer configuration and price, based on a model.
 * Method List:
 * calcPercent
 * checkModel
 * priceModel
 */
public class NerdyHerdComputers {
    
    
    public static void main(String[] args) { 
        
        // asking for a computer model
        String computerModel = JOptionPane.showInputDialog(null, "Input a computer brand name - Asus, Acer, or Dell");        
        String modelToDisplay = NerdyHerdComputers.checkModel(computerModel);
        
        System.out.println(modelToDisplay);
        
        // determining the price
        double price = NerdyHerdComputers.priceModel(computerModel);        
        System.out.println(price);
        
        // asking for a discount rate and calculating it
        double discountRate = Double.parseDouble(JOptionPane.showInputDialog(null, "What discount rate do you want?"));        
        double discount = NerdyHerdComputers.calcPercent(price, discountRate);
        
        NumberFormat decimals = new DecimalFormat("$0.00"); // formatting to 2 decimal spots
        System.out.println(decimals.format(discount));
        
        //ask for tax
        double taxRate = Double.parseDouble(JOptionPane.showInputDialog(null, "What percent rate of tax do you have?"));        
        double tax = NerdyHerdComputers.calcPercent(price - discount, taxRate);
        System.out.println(decimals.format(tax));
        
        // calculating final price
        double subTotal = price - discount;
        double finalPrice = subTotal + tax;
        
        // displaying the final configuration
        System.out.println (modelToDisplay +"\n Price: "+ price +"\n Discount Taken Off: "+ decimals.format(discount) 
                                +"\n Tax Amount: "+ decimals.format(tax) +"\n Total: " + decimals.format(finalPrice) 
                                + "\n Thank you for making your purchase!");
        
    }
    
    public static String checkModel (String model){
        if (model.equalsIgnoreCase("Asus")){
            return "Asus Ultrabook 14, 8GB of RAM and 256GB SSD";
        }
        
        else if (model.equalsIgnoreCase("Acer")){
            return "Acer Inspire 15, 4GB RAM, 1TB HDD";
        }
        
        else if (model.equalsIgnoreCase("Dell")){
            return "Dell Inspiron 17, 8GB RAM, 1TB HDD";
        }
        
        else {
            return "Model not in stock"; // displays if neither Asus, Acer or Dell is entered
        }
        
    } // ends checkModel
    
    public static double priceModel (String model){
        double price = 0.00;
        
        if (model.equalsIgnoreCase("Asus")){
            price = 1049.99;
        }
        
        else if (model.equalsIgnoreCase("Acer")){
            price = 499.99;
        }
        
        else if (model.equalsIgnoreCase("Dell")){
            price = 899.99;
        }
        
        else { // if neither Asus, Acer, or Dell is entered, the price will be set as -1
            price = -1;
        }
        
        return price;
        
    } // ends the priceModel function
    
    public static double calcPercent (double amount, double rate) {
        double percent = 0, discountRate =0;
        
        percent = amount * rate / 100;
        
        return percent;
        
    }
    
    
}
