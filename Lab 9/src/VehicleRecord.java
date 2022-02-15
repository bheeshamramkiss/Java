/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date April 18, 2019
 * Description: A class that allows for storage of a vehicle make, model, year and type
 *
 */
public class VehicleRecord {

	/*
	 * Instance variables
	 */

	String make;
	String model;
	int year;
	char type;

	/**
	 * 
	 */
	public VehicleRecord() {
		// initializing the instance variables
		this.make = "";
		this.model = "";
		this.year = 0;
		this.type = 0;
	}


	//method to process the vehicle information

	public void processRecord(String info) {
		String vInfo[] = info.split("/");
		this.setMake(vInfo[0]);
		this.setModel(vInfo[1]);
		this.setYear(Integer.parseInt(vInfo[2]));
		this.setType(vInfo[3].charAt(0));
	}

	/*
	 * getters
	 */

	public String getMake() {
		return make;
	}


	public String getModel() {
		return model;
	}


	public int getYear() {
		return year;
	}


	public char getType() {
		return type;
	}

	/*
	 * method to deliver the appropriate message from the given char
	 */

	public void setMake(String make) {
		this.make = make;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public void setType(char type) {
		this.type = type;
	}


	public String charToString(char c) {
		if(c == 'p') {
			return "Passenger";
		}

		else if(c == 'v') {
			return "Van";
		}

		else if (c == 's') {
			return "SUV";
		}

		else if (c == 't') {
			return "Truck";
		}

		else {
			return "Invalid Vehicle Type";
		}

	}

	/*
	 * toString() method that will convert the vehicle record into a user-friendly interpretation
	 */

	public String toString() {
		// making the corresponding String for the appropriate char type

		return this.getMake() + "/" + this.getModel() + "/" + this.getYear() + "/" + this.getType() + "\n";
	}

	/**
	 * Self-Testing Main
	 */
	public static void main(String[] args) {
		// testing the creation, processing, setters, and getters
		String vRString = "Toyota/Land Cruiser/2018/s";

		VehicleRecord vR = new VehicleRecord();
		vR.processRecord(vRString);

		System.out.println(vR.toString());

	}

}
