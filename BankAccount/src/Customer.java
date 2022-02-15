/**
 * 
 */

/**
 * @author Ceyhon Wilson
 * @Date May 11, 2019
 * @Description This class stores the customers first and last name, address, and phone number
 * and allows the customer's information to be retrieved and updated.
 * @Methods 
 */
public class Customer {
	private String fName; // Declaring Customer's first and last name, address, and phone number
	private String lName;
	private String address;
	private String pNum;

	/**
	 * 
	 */

	public Customer() {
		this.fName = ""; // Initializing variables
		this.lName = "";
		this.address = "";
		this.pNum = "";
	}

	// overloaded constructor
	public Customer(String fN, String lN, String add, String pN) {
		this.fName = fN;
		this.lName = lN;
		this.address = add;
		this.pNum = pN;
	}

	// getters and setters
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	// toString method
	public String toString() {
		return this.getfName() + " " + this.getlName() + "/" + this.getAddress() + "/"  + this.getpNum() + "\n";
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {

	}

}
