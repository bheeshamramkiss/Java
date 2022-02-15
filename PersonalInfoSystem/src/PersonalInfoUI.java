import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author manoj
 * @date February 15, 2019
 * Description: UI that will ask the user to choose to read from a file and return it in a formatted design.
 */
public class PersonalInfoUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input [];
		String output;
		String fileName;
		
		fileName = JOptionPane.showInputDialog (null, "Enter the File Name", "PersonalInfo.txt");
		
		try {
			input = InfoSysLoader.loadFile(fileName);
			
			String text = "";
			for (int i = 0; i < input.length; i++) {
				output = PersonalInfoProcessor.processInformation(input[i]);
				text += output + "\n\n";
			} // ends the for loop
			
			JTextArea displayArea = new JTextArea();
			displayArea.setText(text);
			displayArea.setEditable(false);
			JOptionPane.showMessageDialog(null, displayArea);
			
			
		}
		catch(NumberFormatException error) {
			JOptionPane.showMessageDialog(null, "File just went corrupto mode.");
		}
		catch(FileNotFoundException error) {
			JOptionPane.showMessageDialog(null, "File not found mane.");
		}
		catch(IOException error) {
			JOptionPane.showMessageDialog(null, "Unknown error; idk dawg.");
		}

	} // main

} // class
