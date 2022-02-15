import java.text.NumberFormat;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 11, 2019
 * Description: Calculates the total price of a vehicle, with PDI included.
 *
 */
public class totalCarPrice {

	// this method will be used to calculate the tax and PDI of the vehicle
	public static double percentCalc (double number, double rate) {
		double result = number * (rate/100);
		return result;
	} // ends the numberCalc method
	
	public static void main(String[] args) {
		double carPrice, tax, hstRate, pdi, total;
		String carMake, carModel;

		//making a number format to keep to two decimal places
		NumberFormat nf = NumberFormat.getCurrencyInstance();

		// asking the user for car brand, model, and tax rate
		carMake = JOptionPane.showInputDialog (null, "Welcome to the car pricing tool! Let's begin with the vehicle make:");
		carModel = JOptionPane.showInputDialog (null, "Thank you! Now what about the model?");
		carPrice = Double.parseDouble(JOptionPane.showInputDialog(null,"The price?"));
		hstRate = Double.parseDouble(JOptionPane.showInputDialog (null, "Great! Please input the tax rate (in percent) "
				+ "that you would like to use:"));
		
		// calculating the tax, pdi, and final vehicle price
		pdi = percentCalc (carPrice, 2);
		tax = percentCalc ((carPrice + pdi), hstRate);
		total = carPrice + tax + pdi;
		
		//displaying the final information to the user
		JOptionPane.showMessageDialog (null, "Thank you for your time and patience! Here is your new car:"
				+ "\nMake: " + carMake + "\nModel: " + carModel + "\nMSRP: " + nf.format(carPrice) + "\nTax: " + nf.format(tax) + ""
				+ "\nPre-Delivery Inspection: " + nf.format(pdi) + "\nTotal: " + nf.format(total));
		
	}

}
