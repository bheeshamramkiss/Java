import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Mansi Thind
 *
 */
public class HighscoreList {

	//instance variables
	private  HighscoreRecord list[];
	private  int size;
	private  int maxSize;

	public HighscoreList() {
		this.maxSize = 5;
		this.list = new HighscoreRecord[maxSize];
		this.size = 0;
	}

	public boolean insert(HighscoreRecord record) {
		if(maxSize>size) {
			list[size] = record;
			size++;
			return true;
		}

		return false;
	}

	public void change(HighscoreRecord newR) {

		sortInt(0, list.length-1);
		for(int i =0; i<list.length;i++) {

			if((newR.getScore()>list[i].getScore())) {
				HighscoreRecord temp = list[i];
				list[i] = newR;
				newR = temp;
				
			}
		}
	}

	//Binary Search for userName
	public int binarySearch(String searchKey, int search) {

		int low = 0; // low end of the list
		int high = size - 1; //high end of the list
		int middle; // middle

		while (low <= high) {
			middle = (high + low)/2;
			
			if(search == 0) {

				if(list[middle].getUserName().equalsIgnoreCase(searchKey)){
					return middle;
				}
				else if (list[middle].getUserName().compareToIgnoreCase(searchKey) > 0) {
					high = middle -1;
				}
				else {
					low = middle + 1;
				}
			}
			else {
				if(list[middle].getScore() == search){
					return middle;
				}
				else if (list[middle].getScore() > search) {
					low = middle +1;
				}
				else {
					high = middle - 1;
				}
			}
		}
		return -1; // not found
	}

	public HighscoreRecord [] getList() {
		return this.list;
	}

	public String [] readFile() throws IOException {
		//open the file to read and connecting to input
		FileReader f = new FileReader("Highscores.txt");
		BufferedReader input = new BufferedReader(f);

		String file[] = new String[maxSize];

		for(int i =0; i<file.length;i++) {
			file[i] = input.readLine();
			
		}

		input.close();

		return file;
	}

	public void saveFile(String fileName) throws IOException {
		//open file
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));

		String file = toFileString();
		
		String[] words = file.split("/");
		
		for(int i = 0; i<maxSize; i++) {
			writer.write(words[i]);
	        writer.newLine();
		}

		//close file
		writer.close();
	}

	public String toString() {
		String theList = "";
		for (int i = 0; i < this.size; i++) {

			theList = theList + list[i].toDisplayString() + "\n";
		}
		return theList;
	}

	public String toFileString() {

		String myList = "";

		for(int i=0; i< this.size;i++) {
			myList = myList + list[i].getUserName() + ", " + list[i].getScore() + ", " + list[i].getTime() + "/";

		}

		return myList;

	}

	public void sortInt(int lower, int higher) {
		int i = lower;
		int j = higher;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = list[lower+(higher-lower)/2].getScore();
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is less then the pivot value, and also we will identify a number 
			 * from right side which is greater then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (list[i].getScore() > pivot) {
				i++;
			}
			while (list[j].getScore() < pivot) {
				j--;
			}
			if (i <= j) {

				HighscoreRecord temp = list[i];
				list[i] = list[j];
				list[j] = temp;

				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lower < j) {
			sortInt(lower, j);
		}
		if (i < higher) {
			sortInt(i, higher);
		}
	}

	public void sortString(int lower, int higher) {
		int i = lower;
		int j = higher;
		// calculate pivot number, I am taking pivot as middle index number
		String pivot = list[lower+(higher-lower)/2].getUserName();
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is less then the pivot value, and also we will identify a number 
			 * from right side which is greater then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (list[i].getUserName().compareTo(pivot) <0) {
				i++;
			}
			while (list[j].getUserName().compareTo(pivot) > 0) {
				j--;
			}
			if (i <= j) {

				HighscoreRecord temp = list[i];
				list[i] = list[j];
				list[j] = temp;

				//move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lower < j) {
			sortString(lower, j);
		}
		if (i < higher) {
			sortString(i, higher);
		}
	}

	public static void main(String[] args) {

		HighscoreList hList = new HighscoreList();
		String [] array = new String [5];

		try {
			array = hList.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i = 0;i<5;i++) {
			System.out.println(array[i]);
		}
		
		/*
		
		
		for(int i =0; i<hList.getList().length;i++) {
			HighscoreRecord hR = new HighscoreRecord();
			hR.processRecord(array[i]);
			hList.insert(hR);
		}

		System.out.println("Regular Display: \n" + hList);
		
		
		HighscoreRecord info = new HighscoreRecord();
		
		String newRecord = "Anisha, 280, 2:50";
		info.processRecord(newRecord);
		hList.change(info);
		System.out.println("Change Records with a higher score: \n" + hList);
		
		HighscoreRecord info1 = new HighscoreRecord();
		
		String newRecord1 = "Navraj, 150, 3:10";
		info1.processRecord(newRecord1);
		hList.change(info1);
		System.out.println("Does not change score with lower score: \n" + hList );
		
		hList.sortString(0, hList.getList().length-1);
		System.out.println("List sorted by UserName: \n" + hList);
		
		System.out.println("Mansi was found in position " + hList.binarySearch("Mansi", 0));
		
		hList.sortInt(0, hList.getList().length-1);
		System.out.println("List sorted by scores: \n" + hList);
		
		System.out.println("The score of 280, was found in position " + hList.binarySearch("", 280));
		
		try {
			hList.saveFile("testFile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}

}

