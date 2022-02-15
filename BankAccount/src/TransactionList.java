import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date May 20, 2019
 * Description: The Transaction List class that allows the user to manage a list of transaction records
 *
 * METHOD LIST:
 * boolean insertRecord(TransactionRecord): inserts a transaction to the array of records list. Returns true if 
 * successful, false if unsuccessful
 * 
 * boolean deleteRecord(TransactionRecord): deletes a transaction to the array of records list. Returns true if 
 * successful, false if unsuccessful
 * 
 * boolean change(TransactionRecord, TransactionRecord): changes one record out for another in the records list.
 * Returns true if successful, false if unsuccessful
 * 
 * int getSize(): returns the current size of the array
 * 
 * TransactionRecord[] getList(): returns the entire array of records list.
 * 
 * String toString(): displays the entire list
 * 
 * void insertionSort(): sorts the record list by the transaction amount
 * 
 * int binarySearch(double) searches the entire list until it finds a transaction amount equal to the one given.
 * returns the index of the list where this record is located
 * 
 * String fileChooser(): file chooser that allows the user to go through their computer's file system to select a 
 * file
 * 
 * TransactionList loadFile(): loads a file into a TransactionList
 * 
 * void writeFile(TransactionList): writes an entire TransactionList to a txt file (user specifies the name and
 * location)
 * 
 * void main(String[] args): main method that is used for self-testing purposes
 */
public class TransactionList {

	/*
	 * private instance variables
	 */

	private TransactionRecord[] transactionList;
	private int maxSize;
	private int size;


	/**
	 * default constructor
	 */
	public TransactionList() {
		this.maxSize = 20;
		transactionList = new TransactionRecord[maxSize];
		this.size = 0;
	}

	/*
	 * insert method that will increment the size of the array, and insert the passed vehicle record into
	 * the array
	 * It will also return true if it has successfully inserted, and false if it could not.
	 */

	public boolean insertRecord(TransactionRecord record) {
		if (this.size < this.maxSize) {
			this.size++;
			transactionList[this.size-1] = record;
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

	public boolean deleteRecord(TransactionRecord recordToDelete) {
		this.insertionSort(); // sorting the array by make before the binarySearch checks through the list
		for (int i = 0; i < this.size; i++) {
			if(this.binarySearch(recordToDelete.getAmount())!= -1) { // if the record is found
				transactionList[this.binarySearch(recordToDelete.getAmount())] = transactionList[this.size-1];
				size--;
				this.insertionSort(); // sorts after any deletions are made
				return true; //successful deletion
			}
		}

		return false;
	}

	/*
	 * change method to switch or modify a particular record in the array
	 * returns true if change was done successfully, false if not
	 */

	public boolean change(TransactionRecord oldR, TransactionRecord newR) {
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

	public TransactionRecord[] getList() {
		return this.transactionList;
	}

	public String toString() {
		String listToDisplay = "";
		for (int i = 0; i < size; i++) {
			listToDisplay += transactionList[i].toString();
		}

		return listToDisplay;
	}

	/*
	 * Sorting methods
	 */

	// insertion sort method that sorts the list by transaction amount
	public void insertionSort() {
		for (int top = 1; top < size; top++) {
			TransactionRecord item = transactionList[top];
			int i = top - 1; 
			while ((i >= 0) && (item.getAmount() < (transactionList[i].getAmount()))) { 
				transactionList[i + 1] = transactionList[i];
				i--; 
			} 	
			transactionList[i+1] = item;
		}

	}

	// binary search method that searches for a transaction amount
	public int binarySearch(double d) {
		int low = 0; // low end of the array
		int high = size-1; //high end of the array
		int middle; 

		while(low <= high) {
			middle = ((high + low) / 2);
			if (transactionList[middle].getAmount() == d) {
				return middle;
			}
			else if (transactionList[middle].getAmount() > d) {
				high = middle - 1;
			}
			else {
				low = middle + 1;
			}
		}

		return -1; // not found
	}

	/*
	 * Methods to read from a file, add a read file into the TransactionList, and write a TransactionList to a textFile
	 */

	public String fileChooser() {

		/*
		 * using JFileChooser to allow user to choose the name that the fileLoader and writer will use
		 */

		// variable initialization and declaration
		JFileChooser saveFile = new JFileChooser();
		String finalFile = "";

		// filter, so only text files can be seen. minimizes chances of error
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		saveFile.setFileFilter(filter);
		// checking if the "OK" button was pressed
		int returnVal = saveFile.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			// getting name of file
			File selectedFile = saveFile.getSelectedFile();
			finalFile = selectedFile.getName();
		}

		//debug
		//System.out.println("File found");

		return finalFile;
	}

	public TransactionList loadFile () throws IOException {
		// open file to read
		String fileName = fileChooser();
		FileReader fr = new FileReader (fileName);
		BufferedReader input = new BufferedReader (fr);

		// declaring an integer to store the size of the array
		int size = 0;

		// the contained condition allows the while to iterate such that it does not read "EOF" in the file's next line
		while (!input.readLine().equals("EOF")) {
			size++;
		}

		input.close();

		//creating a string array that will hold all the records in their make/model/year/type form
		//as well as the TransactionRecord array that will be returned
		String fileInfo[] = new String[20];
		TransactionList list = new TransactionList();


		// opening the file once again to read and load all lines of the txt file into the array
		FileReader rf = new FileReader (fileName);
		BufferedReader in = new BufferedReader(rf);

		// loop each line of the txt file, and process each one of those lines into TransactionRecords
		for (int i = 0; i < size; i++) {
			fileInfo[i] = in.readLine();
			TransactionRecord TransactionRecords = new TransactionRecord();
			TransactionRecords.processRecord(fileInfo[i]);
			list.insertRecord(TransactionRecords);
		} // ends the for loop

		// close the file
		in.close();

		//return the array
		return list;

	} // ends the loadFile 

	public void writeFile(TransactionList list) throws IOException{
		String fileName = fileChooser();
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);

		// call the toString method and write the entire toString into the file
		bw.write(list.toString());			
		bw.close();

	} // ends the file writing method


	/**
	 * self-testing main method
	 */
	public static void main(String[] args) {

		//creating a transactionList
		TransactionList tL = new TransactionList();

		// adding 20 records
		try {
			tL = tL.loadFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: File not found, or other unknown error.");
		}

		System.out.println("\nAdding 20 records:\n" + tL.toString());

		//deleting the last record (amount of $319.00)
		String recordToDelete = "c/Deposit/319.00/1000.00/1300.00";
		TransactionRecord t1 = new TransactionRecord();
		t1.processRecord(recordToDelete);

		// passing the record to delete and displaying the full array to show that the deletion was done 
		// successfully/unsuccessfully
		System.out.println("Deleting the last transaction:\n");

		//test that will display if the deletion was done or not
		if(tL.deleteRecord(t1)) {
			System.out.println("Deleted Successfully!");
		}
		else {
			System.out.println("Deleted Unsuccessfully");
		}

		System.out.println("\n" + tL.toString()); // display the list with the deleted record

		/*
		 * testing to delete a record that does not exist
		 */
		recordToDelete = "c/Deposit/326.00/1234.00/1300.00";
		t1.processRecord(recordToDelete);
		System.out.println("Deleting a record that does not exist:\n");

		//test that will display if the deletion was done or not
		if(tL.deleteRecord(t1)) {
			System.out.println("Deleted Successfully!");
		}
		else {
			System.out.println("Deleted Unsuccessfully");
		}

		System.out.println("\n" + tL.toString()); // display the list with the deleted record

		// testing the change function--which relies on the insert and delete function to be fully working
		// in order to work properly
		String recordToReplace = "c/Deposit/500.00/750.00/1250.00"; 	// creating the record we want to change to
		t1.processRecord(recordToReplace);

		String recordToBeReplaced = "c/Deposit/303.00/1000.00/1300.00";	// the record that we want replaced	
		TransactionRecord vR3 = new TransactionRecord();
		vR3.processRecord(recordToBeReplaced);
		System.out.println("Changing the $303 deposit out for the $500 deposit:\n");
		if(tL.change(vR3, t1)) {
			System.out.println("Successful change!");
		}
		else {
			System.out.println("Unsuccessful Change");
		}
		System.out.println("\n" + tL.toString());

		// testing the binary search method

		// searching for a deposit amount that exists at the first index
		double amount = 300.00; // model that is to be found
		System.out.println("The record with amount: " + amount + " was found at index " + tL.binarySearch(amount) + ".");

		//searching for another model that exists at the bottom of the array
		amount = 500.00; // model that is to be found 
		System.out.println("The record with amount: " + amount + " was found at index " + tL.binarySearch(amount) + ".");

		//searching for a model that doesn't exist
		amount = 234.00; // model that is to be found 
		System.out.println("The record with amount: " + amount + " was found at index " + tL.binarySearch(amount) +
				". It was not found, or does not exist");

		/*
		 * testing insertion sort. need to add another record since the current list is already in order,
		 * and if the methods works or not, we cannot tell
		 */

		String recordToAdd = "c/Deposit/257.36/1000.00/1300.00";
		TransactionRecord t5 = new TransactionRecord();
		t5.processRecord(recordToAdd);
		tL.insertRecord(t5);

		System.out.println("\nRecord list before insertion sort:");
		System.out.println("\n" + tL.toString());

		// testing the insertion sort method
		tL.insertionSort();
		System.out.println("\nRecord list after insertion sort:");
		System.out.println("\n" + tL.toString());

		//testing the fileWriter
		System.out.println("\nWriting the current list to a file called test.txt");
		try {
			tL.writeFile(tL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An unknown error has occurred. File write unsuccessful.");
		}

	}

}
