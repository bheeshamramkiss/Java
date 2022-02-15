import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date May 20, 2019
 */
public class Loader {
	/**
	 * Method to load from a file. Returns a string array.
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String [] loadFile (String fileName) throws IOException {
		
		// opening the file and reading through it once to determine the size of the array
		FileReader fr = new FileReader(fileName);
		BufferedReader input = new BufferedReader(fr); 

		// declaring an integer to store the size of the array
		int size = 0;

		// the contained condition allows the while to iterate such that it does not read "EOF" in the file's next line
		while (!input.readLine().equals("EOF")) {
			size++;
		}

		input.close();

		// opening the file once again to read and load all lines of the txt file into the array
		FileReader rf = new FileReader(fileName);
		BufferedReader in = new BufferedReader(rf);

		String fileInfo[] = new String [size];		

		for (int i = 0; i < size; i++) {
			fileInfo[i] = in.readLine();

		}

		in.close();

		return fileInfo;

	} // ends the loadFile 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String output [] = null;

		// call the loader method
		try {
			output = Loader.loadFile("PersonalInfo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch

		for (int k = 0; k < output.length; k++) {
			System.out.println(output[k]);
		} // for loop

	} // main

} // class
