import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

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
		recordList = new VehicleRecord[maxSize];
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
		this.insertionSort(); // sorting the array by make before the binarySearch checks through the list

			if(this.binarySearch(recordToDelete.getMake()) != -1) { // if the record is found
				recordList[this.binarySearch(recordToDelete.getMake())] = recordList[this.size-1];
				size--;
				this.insertionSort(); // sorts after any deletions are made
				return true; //successful deletion
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
			this.insertionSort();
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

	/*
	 * Sorting methods
	 */

	// linear search method that searches for a specific model
	public int linearSearch (String modelWanted) {
		for (int i = 0 ; i < size; i++) {
			if (recordList[i].getModel().equalsIgnoreCase(modelWanted)) {
				return i; // return the location where the model the user searched for exists
			}

		}

		return -1; // not found
	}

	// insertion sort method that sorts the list by make alphabetically
	public void insertionSort() {
		for (int top = 1; top < size; top++) {
			VehicleRecord item = recordList[top];
			int i = top - 1; 
			while ((i >= 0) && (item.getMake().compareToIgnoreCase(recordList[i].getMake()) < 0)) { 
				recordList[i + 1] = recordList[i];
				i--; 
			} 	
			recordList[i+1] = item;
		}

	}

	// binary search method that searches for the make of a vehicle
	public int binarySearch(String makeWanted) {
		int low = 0; // low end of the array
		int high = size-1; //high end of the array
		int middle; 

		while(low <= high) {
			middle = ((high + low) / 2);
			if (recordList[middle].getMake().equalsIgnoreCase(makeWanted)) {
				return middle;
			}
			else if (recordList[middle].getMake().compareToIgnoreCase(makeWanted) > 0) {
				high = middle - 1;
			}
			else {
				low = middle + 1;
			}
		}

		return -1; // not found
	}

	// quickSort method that will sort the vehicles by their year of production
	public void quickSort() {
		quickSort(this.recordList, 0, this.recordList.length-1);
	}

	private void quickSort(VehicleRecord[] list, int low, int high) {
		final int moving_Left = 0;
		final int moving_Right = 1;

		if (low < high) {
			int left = low;
			int right = high;
			int currentDirection = moving_Left;
			VehicleRecord pivot = list[low];
			while (left < right) {
				if (currentDirection == moving_Left) {
					while((list[right].getYear() >= pivot.getYear()) && (left < right)) {
						right--;
					}
					list[left] = list[right];
					currentDirection = moving_Right;
				}
				if (currentDirection == moving_Right) {
					while ((list[left].getYear() <= pivot.getYear()) && (left < right)) {
						left++;
					}
					list[right] = list[left];
					currentDirection = moving_Left;

				}
			}
			list[left] = pivot; // or list [right], since equal
			quickSort(list, low, left -1);
			quickSort(list, right+ 1, high);
		}
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

		// testing the linear search method
		// adding a new model to search for 
		String newCar = "Lexus/GS300/1992/p";
		VehicleRecord vr4 = new VehicleRecord();
		vr4.processRecord(newCar);
		testList.insertRecord(vr4);

		// searching for a model that exists at the first index
		String modelToFind = "Corolla"; // model that is to be found 
		System.out.println("The model: " + modelToFind + " was found at index " + testList.linearSearch(modelToFind) + ".");

		//searching for another model that exists at the bottom of the array
		modelToFind = "GS300"; // model that is to be found 
		System.out.println("The model: " + modelToFind + " was found at index " + testList.linearSearch(modelToFind) + ".");

		//searching for a model that doesn't exist
		modelToFind = "Civic"; // model that is to be found 
		System.out.println("The model: " + modelToFind + " was found at index " + testList.linearSearch(modelToFind) +
				". It was not found, or does not exist");

		System.out.println("\nRecord list before insertion sort:");
		System.out.println("\n" + testList.toString());

		// testing the insertion sort method
		testList.insertionSort();
		System.out.println("\nRecord list after insertion sort:");
		System.out.println("\n" + testList.toString());

		// testing the binary search method by searching for the Lexus and Toyota makes. Should return the
		// index at which each is present. The Toyota make search should return at index 1, since it should
		// be the first place it is found
		System.out.println("Found at index: " + testList.binarySearch("Lexus"));
		System.out.println("Found at index: " + testList.binarySearch("Toyota"));
		System.out.println("\nRecord list after binarySearch/Pre-quickSort:");
		System.out.println("\n" + testList.toString());

		//since this list is already in order, a new record needs to be added out of order to test the 
		//quickSort method
		newCar = "Honda/CRV/2005/s";
		VehicleRecord vr5 = new VehicleRecord();
		vr5.processRecord(newCar);
		testList.insertRecord(vr5);
		System.out.println("\nRecord list after insertion of new car:");
		System.out.println("\n" + testList.toString());

		testList.quickSort();
		System.out.println("\nRecord list after the quick sort:");
		System.out.println("\n" + testList.toString());

	}

}
