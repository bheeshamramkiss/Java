import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */

/**
 * @author Ceyhon Wilson and Bheesham Ramkissoon
 * @date may 20,2019
 * @description This class writes the user's account number and password into a file
 * @methods static void write(String accounts, Account accNum, loginGUI password): writes the user's account number and password into a file
 * static void main(String[] args): A self testing main
 */
public class AccountWriter {

	/**
	 * @param args
	 */
	
	public static void write(String accNum, String password) throws IOException{
		
		// checking to see if there is an accounts text file first, saving it's contents, and then re-writing 
		// the existing customer accounts with this new customer account
		String[] existingAccounts = Loader.loadFile("Accounts.txt");
		
		FileWriter fw = new FileWriter("Accounts.txt");
		PrintWriter bw = new PrintWriter(fw);
		
		for (int i = 0; i <existingAccounts.length; i++) {
			bw.println(existingAccounts[i]);
		}
		bw.println(accNum + "/" + password);
		bw.println("EOF");
		bw.close();
		}
	
	/*
	 * self-testing main
	 */
	
	public static void main(String[] args) {
		try {
			write("dangoose", "1234");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
