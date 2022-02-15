import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author manoj
 * @date February 14, 2019
 */
public class InfoSysLoader {
	/**
	 * Method to load from a file. Returns a string array.
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String [] loadFile (String fileName) throws IOException {
		// open file to read
		FileReader fr = new FileReader (fileName);
		BufferedReader input = new BufferedReader (fr);

		// read the number of items in the file
		int size = Integer.parseInt(input.readLine());

		// create the string array
		String fileInfo[] = new String [size];

		// loop through the file and load the array
		for (int i = 0; i < fileInfo.length; i++) {
			fileInfo[i] = input.readLine();
		} // ends the for loop

		// close the file
		input.close();

		//return the array
		return fileInfo;

	} // ends the loadFile 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String output [] = null;

		// call the loader method
		try {
			output = InfoSysLoader.loadFile("PersonalInfo.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // catch

		for (int k = 0; k < output.length; k++) {
			System.out.println(output[k]);
		} // for loop

	} // main

} // class
