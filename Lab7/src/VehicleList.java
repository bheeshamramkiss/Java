import java.util.Arrays;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date April 20, 2019
 * Description: Class that allows the user to manage an array of VehicleRecords.
 *
 */
public class VehicleList {

	/*
	 * instance variables
	 */

	private VehicleRecord recordList[];
	private int maxSize;
	private int size;

	/**
	 * 
	 */
	public VehicleList() {
		this.maxSize = 5;
		recordList = new VehicleRecord[5];
		this.size = 0;
	}

	/*
	 * insert method that will increment the size of the array, and insert the passed vehicle record into
	 * the array
	 * It will also return true if it has successfully inserted, and false if it could not.
	 */

	public boolean insertRecord(VehicleRecord record) {
		if (this.size < this.maxSize) {
			this.size++;
			recordList[this.size-1] = record;
			return true; // the record is successfully added into the record array
		}
		else {
			return false; // no more space would be available in the array for this case to occur
		}
	}

	/*
	 * Delete method
	 * Works by looping through the record array to find the record that matches the one given to delete
	 * if it is found, that particular index becomes the contents of the last index of the array, and the 
	 * array size decreases by one. Also returns true if delete was successful, false if the given record to
	 * delete is not found/does not exist
	 */

	public boolean deleteRecord(VehicleRecord recordToDelete) {
		for (int i = 0; i < this.size; i++) {
			if(recordList[i].getYear() == recordToDelete.getYear()) {
				recordList[i] = recordList[this.size-1];
				size--;
				return true; //successful deletion
			}
		}

		return false;
	}

	/*
	 * change method to switch or modify a particular record in the array
	 * returns true if change was done successfully, false if not
	 */

	public boolean change(VehicleRecord oldR, VehicleRecord newR) {
		if(deleteRecord(oldR)) {
			insertRecord(newR);
			return true;
		}
		return false;
	}

	public int getSize() {
		return size;
	}

	public VehicleRecord[] getList() {
		return this.recordList;
	}

	public String toString() {
		String listToDisplay = "";
		for (int i = 0; i < size; i++) {
			listToDisplay += "Vehicle Record " + i + ": " + recordList[i].toString() + "\n";
		}

		return listToDisplay;
	}

	/**
	 * self-testing main method to test for the insert, delete, and change methods
	 */
	public static void main(String[] args) {

		//creating a VehicleRecord list object
		VehicleList testList = new VehicleList();
		String vehicleRecord = "";

		// adding 5 vehicleRecords
		System.out.println("\nAdding 5 vehicles into the list via the insert function:\n");

		for (int i = 0; i <= testList.getList().length; i++) {
			vehicleRecord = "Toyota/Corolla/200" + i + "/p";

			VehicleRecord vR1 = new VehicleRecord();
			vR1.processRecord(vehicleRecord);

			// tests the insert functionality (also displays if each insertion was successful. Last one should be false since
			// maximum size allowed is 5)
			if (testList.insertRecord(vR1)){
				System.out.println("Added " + i + " Sucessfully.");
			}
			else {
				System.out.println("Addition Unsuccessful.");
			}
			//			System.out.println(testList.insertRecord(vR1));
		}

		System.out.println("\n" + testList.toString());

		/* 
		 * testing the delete functionality by creating another VehicleRecord, and passing it to the
		 * delete method
		 */
		String recordToDelete = "Toyota/Corolla/2002/p";
		VehicleRecord vR2 = new VehicleRecord();
		vR2.processRecord(recordToDelete);

		// passing the record to delete and displaying the full array to show that the deletion was done 
		// successfully/unsuccessfully
		System.out.println("Deleting the 2002 Corolla from the Records List:\n");

		//test that will display if the deletion was done or not
		if(testList.deleteRecord(vR2)) {
			System.out.println("Deleted Successfully!");
		}
		else {
			System.out.println("Deleted Unsuccessfully");
		}

		System.out.println("\n" + testList.toString()); // display the list with the deleted record

		/*
		 * testing to delete a record that does not exist
		 */
		recordToDelete = "Toyota/Corolla/2002/p";
		vR2.processRecord(recordToDelete);
		System.out.println("Deleting a record that does not exist:\n");

		//test that will display if the deletion was done or not
		if(testList.deleteRecord(vR2)) {
			System.out.println("Deleted Successfully!");
		}
		else {
			System.out.println("Deleted Unsuccessfully");
		}

		System.out.println("\n" + testList.toString()); // display the list with the deleted record

		// testing the change function--which relies on the insert and delete function to be fully working
		// in order to work properly
		String recordToReplace = "Toyota/Corolla/2019/p"; 	// creating the record we want to change to
		vR2.processRecord(recordToReplace);

		String recordToBeReplaced = "Toyota/Corolla/2004/p";	// the record that we want replaced	
		VehicleRecord vR3 = new VehicleRecord();
		vR3.processRecord(recordToBeReplaced);
		System.out.println("Changing the 2004 model out for the 2019 model:\n");
		if(testList.change(vR3, vR2)) {
			System.out.println("Successful change!");
		}
		else {
			System.out.println("Unsuccessful Change");
		}
		System.out.println("\n" + testList.toString());

	}

}
