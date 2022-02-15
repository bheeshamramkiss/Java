
/**
 * @author Jacob Vongsa
 * @date May 11, 2019
 * Description: The Savings Class is a class which inherits from Account and deducts 1.25
 * once the withdrawal balance is lower than $2000.
 * It will not charge a fee if the withdrawal balance is greater than $2000.
 *
 */

// Savings Class partial template
// Very similar to the Chequing account except the
// withdraw method is different.

public class Savings extends Account // inherits from Account
{

	// class data (only some is here, you may need more)
	//fees for transactions
	private double deductionFee;
	private double maxBalance;

	//default constructor
	public Savings(Customer c) { 
		// constructor to create a Checking Account
		// should call the parent constructor
		super(c); //inheriting from Account

		//set deduction fee and max balance to be charged 
		deductionFee = 1.25;
		maxBalance = 2000;

	}

	// overloaded constructor that takes in a customer object and initializes data

	/**
	 * Savings Withdrawal Method
	 * @param amount the customer wishes to withdraw.
	 */

	public boolean withdraw (double withdrawAmt)
	{
		// checks if balance is sufficient
		// charges a fee if balance is below minimum
		// returns true if successful and false if not

		if (getBalance() < maxBalance) {
			withdrawAmt = withdrawAmt + deductionFee;
		}

		return super.withdraw(withdrawAmt);
	}

	/**
	 * Deduction Fee Method 
	 * @param fee
	 */
	public void setDeductionFee (double fee) {
		this.deductionFee = fee;
	}

	/**
	 * Max Balance for Charging Method 
	 * @param fee
	 */
	public void setMaxBalance (double fee) {
		this.maxBalance = fee;
	}

	// getters and setters as needed
	// other useful methods might be method to change the fee and others.
	// toString method


	public static void main(String[] args) { 
		// self-testing main

		//create a new customer object
		Customer newC = new Customer("Jacob", "Vongsa", "134 Binder Twine Trail", "647-767-0431");

		//create a new Saving Account with customer and an initial balance of $450
		Savings savings = new Savings (newC);
		//prints balance
		System.out.println("Initial Balance Upon Creation of Account: " + savings.getBalance());
		
		savings.deposit(200); //deposit $200
		//prints balance
		System.out.println("\nBalance After Depositing $200: " + savings.getBalance());

		savings.withdraw(100); //withdraw $100
		//prints balance
		System.out.println("\nBalance After Withdrawing $100 (Fee Active because Balance's less than $2000): " + savings.getBalance());
		
		savings.withdraw(300); //tries to withdraw more than available
		//prints balance
		System.out.println("\nInsufficient Funds, Balance is Currently " + savings.getBalance());

	}


}
