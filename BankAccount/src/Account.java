/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date May 7, 2019
 * Description: The account class that will create an account with a pre-set balance and 
 * generates an account number for each account created.
 *
 */
public class Account {

	/*
	 * private instance variables
	 */
	private double balance;
	private String accountNumber;
	Customer customer;
	
	/**
	 * default constructor
	 */
	public Account() {
		balance = 0;
		// generate account number
		this.accountNumber = accountNumberGenerator();
		// initializes customer object
		this.customer = new Customer();
		
	}
	
	/*
	 * overloaded constructor thats allows the user to set balance
	 */
	public Account(Customer theOwner) {
		//sets the default balance to 0
		this.balance = 0;
		// generate account number
		this.accountNumber = accountNumberGenerator();
		// initializes customer object
		theOwner = new Customer(theOwner.getfName(), theOwner.getlName(), 
								theOwner.getAddress(), theOwner.getpNum());
		
		
	}
	
	/*
	 * method to generate an account number
	 * generates 12 different integer numbers, and stitches them into a returned string
	 */
	
	public String accountNumberGenerator() {
		String accountNumber = "";
		Die d1 = new Die(9);
		for (int i = 0; i < 12; i++) {
			d1.rollDie();
			accountNumber  = accountNumber + d1.getValue();
		}
		
		return accountNumber;
		
	}
	
	//method to deposit money into a customers' account
	public void deposit (double amount) {
		this.balance += amount;
	}
	
	//method to withdraw funds from a customers' account
	public boolean withdraw (double amountToWithdraw) {
		//checking if the amount to be withdrawn is not bigger than the current balance
		if (amountToWithdraw > this.balance) {
			return false;
		}
		
		//withdraws the amount if it is not bigger than the current balance
		else {
			this.balance -= amountToWithdraw;
			return true;
		}
	}
	
	/*
	 * getters setters
	 */
	

	public double getBalance() {
		return balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	/*
	 * self-testing main method
	 * 
	 */
	public static void main(String[] args) {
		// creating a customer object
		Customer c1 = new Customer("John", "Doe", "23 Murdoch Dr", "9058619959");
		
		

	}

}
