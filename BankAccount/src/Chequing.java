import java.text.DecimalFormat;

/**
 * @author Jacob Vongsa
 * @date May 11, 2019
 * Description: The Chequing Class
 *
 */

// Chequing Class partial template
// Very similar to the Savings account except the
// withdraw method is different.

public class Chequing extends Account {
	private double serviceFee, deductFeePercent;

	/**
	 * 
	 */
	public Chequing(Customer c) {
		super (c); // Inheriting from Account
		this.serviceFee = 1.50; // service fee is $1.50
		this.deductFeePercent = 0.005; // deduct fee is 0.5% (default), cn be changed later
	} // end Chequing()


	/**
	 * @return the serviceFee
	 */
	public double getServiceFee() {
		return serviceFee;
	} // end double getServiceFee()
    /**
	 * @param serviceFee the serviceFee to set
	 */
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	} // end setServiceFee(double serviceFee)

    /**
	 * @param deductFeePercent the deductFeePercent to set
	 */
	public void setDeductFeePercent(double deductFeePercent) {
		this.deductFeePercent = deductFeePercent;
	} // end setDeductFeePercent(double deductFeePercent)

	public void deductAmount (double withdrawAmount) {
		// deductFeePercent with 0.5% == 0.005
		double balance = getBalance(); // get balance from Account

		// clculated withdraw amount
		withdrawAmount = withdrawAmount + (this.deductFeePercent * balance);
		super.withdraw(withdrawAmount); // send withdrawAmount to the main
	} // end deductAmount (double withdrawAmount)

	public double depositServiceFee (double depositNumber) {
		// get deposit number from Account and add with set $1.50 to get double
		double depositServiceFee = this.serviceFee; // depositServiceFee is $1.50
		double depositServiceTotal = 0.0;

		// clculate depositServiceTotal
		depositServiceTotal = depositNumber - depositServiceFee;
		super.deposit(depositServiceTotal);
		return depositServiceTotal;
	} // end double depositServiceFee (double depositNumber)

	/**
	 * @param args
	 * self-test
	 */
	public static void main(String[] args) {
		Customer newC = new Customer ("Jacob", "Vongsa", "134 Binder Twine Trail", "647-767-0431");
		Chequing c = new Chequing(newC);

		// self-testing method 
		
		// setting up the formatting variables using DecimalFormat
	    DecimalFormat twoDecimals = new DecimalFormat (".00");  // 2 decimal places

	    //regular integer
		double depositAmount = 80.0, depositServiceTotal = 0.0;
		System.out.println("Deposit Amount: " + depositAmount);
		
		depositServiceTotal = c.depositServiceFee (depositAmount);

		System.out.println("\nDeposit Total After Paying Service Fee: $" + 
		                   (twoDecimals.format(depositServiceTotal)));
		c.getBalance();
		System.out.println("\nEnd Balance: $" + (twoDecimals.format(c.getBalance())));
		
		//zero deposit
		double depositAmount2 = 0.0, depositServiceTotal2 = 0.0;
		System.out.println("\nDeposit Amount: " + depositAmount2);
		
		depositServiceTotal2 = c.depositServiceFee (depositAmount2);

		System.out.println("\nDeposit Total After Paying Service Fee: $" + 
		                   (twoDecimals.format(depositServiceTotal2)));
		
		//negative number
		double depositAmount3 = -1.0;
		System.out.println("\nDeposit Amount: " + depositAmount3);

		System.out.println("\nError! Deposit must be a Real Value");
		
    } // end main
} // end class