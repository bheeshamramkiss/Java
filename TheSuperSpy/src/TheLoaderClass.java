import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * @author Tanveer M. and Bheesham Ramkissoon
 * @date March 3, 2019
 * Description: This class will load all lines from a specified text file into a String array and return it. This class also
 * contains a file writing method that will write each index of it's given array into a text file
 * METHOD LIST:
 * loadFile: loads the contents of a given txt file name into a string array and returns it
 * writeFile: writes the contents of a given array (presumed to be the encrypted message) into a text file.
 * No returns, just a void method.
 */
public class TheLoaderClass {
	/**
	 * This program sends the
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static String [] loadFile(String fileName) throws IOException {

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


	}


	/**
	 * @param args
	 * Self testing main method
	 */
	public static void main(String[] args) {
		String output[] = null;
		String output2 = "";


		try {
			output = TheLoaderClass.loadFile("TheWolfInSheepsClothingFable.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i=0; i < output.length; i++) {
			System.out.println(output[i]);
		}

		//testing the fileWriter
		for (int k = 0; k < output.length; k ++) {
			output2 += output[k] + "\n";
		}

		try {
			writeFile(output2, "TheWolfInSheepsClothingFableEncrypted.txt", 454533);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // main



	public static void writeFile(String message, String fileName, int encryptionKey) throws IOException{
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(encryptionKey + "\n");
		bw.write(message);
		bw.write("EOF");
		bw.close();

	} // ends the file writing method
}




