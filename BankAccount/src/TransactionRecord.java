import java.text.DecimalFormat;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date May 20, 2019
 * Description: The transaction record class, that creates a record of a transaction made from a customer's bank
 * account
 *
 * METHOD LIST:
 * void processRecord(String): processes a string into a transactionRecord.
 * char getAccountType(): returns the char value that corresponds to which account the deposit/withdrawal was done to.
 * String getTransactionType(): returns the action that was done to an account.
 * double getAmount(): returns amount deposited/withdrawn from an account.
 * double startingBal(): returns the amount of money in an account pre-deposit/withdrawal.
 * double endingBal(): returns the amount of money in an account post-deposit/withdrawal.
 * String toString(): displays the details of a record.
 * void main(String[] args): main method used for self testing of the class.
 */
public class TransactionRecord {

	/*
	 * private instance variables
	 * number format to be used in the toString method
	 */
	
	private char accountType;
	private String transactionType;
	private double amount;
	private double startingBal;
	private double endingBal;
	DecimalFormat df = new DecimalFormat("0.00");
	
	
	/**
	 * standard constructor
	 */
	public TransactionRecord() {
		accountType = 0;
		transactionType = "";
		amount = 0.0;
		startingBal = 0.0;
		endingBal = 0.0;
	}
	
	/*
	 * overloaded constructor
	 */

	public TransactionRecord(char accountType, String transactionType, double amount, double startingBal, double endingBal) {
		this.accountType = accountType;
		this.transactionType = transactionType;
		this.amount = amount;
		this.startingBal = startingBal;
		this.endingBal = endingBal;
	}
	
	/*
	 * method to process a taken string of information and assign each piece of information to the appropriate
	 * variable
	 */
	public void processRecord(String info) {
		String tInfo[] = info.split("/");
		this.accountType = (tInfo[0].charAt(0));
		this.transactionType = (tInfo[1]);
		this.amount = Double.parseDouble((tInfo[2]));
		this.startingBal = Double.parseDouble((tInfo[3]));
		this.endingBal = Double.parseDouble((tInfo[4]));
	}


	/*
	 * getters
	 */
	
	public char getAccountType() {
		return accountType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public double getStartingBal() {
		return startingBal;
	}

	public double getEndingBal() {
		return endingBal;
	}
	
	/*
	 * toString() method that will convert the transaction record into a user-friendly interpretation
	 */

	public String toString() {
		// making the corresponding String for the appropriate char type

		return this.getAccountType() + "/" + this.getTransactionType() + "/" + df.format(this.getAmount()) +
				"/" + df.format(this.getStartingBal()) + "/" + df.format(this.getEndingBal()) + "\n";
	}
	
	/**
	 * self-testing main method
	 */
	public static void main(String[] args) {
		
		String tRString = "c/Deposit/300/1000/1300";

		TransactionRecord tR = new TransactionRecord();
		tR.processRecord(tRString);
		System.out.println(tR.toString());
		
	}

}
