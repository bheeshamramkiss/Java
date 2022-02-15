import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Ceyhon Wilson
 * @date May 20, 2019
 * 
 *
 */
public class CustomerWriter {

	public static void write(Customer c1) throws IOException{
		String[] existingCustomers = Loader.loadFile("CustomerInfo.txt");

		FileWriter fw = new FileWriter("CustomerInfo.txt");
		PrintWriter bw = new PrintWriter(fw);

		for (int i = 0; i <existingCustomers.length; i++) {
			bw.println(existingCustomers[i]);
		}

		bw.println(c1.getfName() +"/"+ c1.getlName()+"/"+ c1.getAddress()+"/"+c1.getpNum());
		bw.println("EOF");
		bw.close();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args){
		//creating a VehicleRecord list object
		Customer  c1 = new Customer();

		//testing the fileWriter
		System.out.println("\nWriting the current list to a file called CustomerInfo.txt");
		try {
			write(c1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error writing");
			e.printStackTrace();
		}
	}
}
