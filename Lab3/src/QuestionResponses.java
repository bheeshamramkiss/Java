import java.io.IOException;
import java.lang.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 19, 2019
 * Description: Displays the questions and answers to question 1 of this lab in a neat format.
 *
 */
public class QuestionResponses {

	//method to change integers 
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//variables for the user given/returned string(s), the questions array that is loaded from a text file
		// an answers array that will contain the actual answers to each questions
		//and a display area where the formatted strings will be displayed
		String user1, user2, output = "";
		String question [] = null;
		String answers [] = new String [14];
		String returnType [] = new String [14];
		JTextArea displayArea = new JTextArea();
		JPanel panel = new JPanel();
		displayArea.setEditable(false); // preventing from the display area from being editable

		// this calls the loadFile method to
		// load the questions into the question array from the
		// questions.txt file
		question = InfoSysLoader.loadFile("questions.txt"); 

		// asking the user for their two desired strings
		user1 = JOptionPane.showInputDialog(null, "Please enter your first phrase of choice.");
		user2 = JOptionPane.showInputDialog(null, "Please enter your second phrase.");

		// adding the answers to the each index of the answers array
		answers [0] = String.valueOf(user1.charAt(1));
		answers [1] = user1.toUpperCase();
		answers [2] = user1.concat(user2);
		answers [3] = user2.concat(user1);
		answers [4] = user2.replace('5', '8');
		answers [5] = user2.replace('6', '8');
		answers [6] = user1.substring(5);
		answers [7] = user1.substring(4, 7);
		answers [8] = Integer.toString(user2.indexOf("45"));
		answers [9] = Integer.toString(user2.indexOf(5));
		answers [10] = Boolean.toString(user2.equals("45"));
		answers [11] = Integer.toString(user1.length());
		answers [12] = user1.substring(0,2).concat(" hat");
		answers [13] = user1.split(" ")[1];	

		//adding the appropriate return type to each index of the returnType array
		returnType [0] = "char";
		returnType [10] = "Boolean";
		returnType [1] = returnType [2] = returnType [3] = returnType [4] = returnType [5] = returnType [6] = returnType [7] = returnType [12] = "String";
		returnType [8] = returnType [9] = returnType [11] = "Integer";
		returnType [13] = "String Array";
		
		// adding the commands, headings and other pieces of information to the output
		output = "String 1: " + user1 + "\nString 2: " + user2;

		for (int i = 0; i < question.length; i++) {
			output += "\n" + question[i] + "\t" + answers [i] + "\t" + returnType[i];
		} // ends for loop

		// putting the output into the displayArea
		displayArea.setText(output);

		// this adds the displayArea to the JPanel, which is shown later on when called in JOptionPane
		panel.add(displayArea); 

		// displaying the users previously entered strings, the appropriate questions, their answers, along with the appropriate
		// return type
		JOptionPane.showMessageDialog(null,  panel);


	} // main

} // class
