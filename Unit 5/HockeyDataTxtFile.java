import javax.swing.*;
import java.io.*;
/**
 * Date: November 29th 2017
 * Author: Bheesham Ramkissoon
 * Description: Reads a text file and displays the scores in a table
 */
public class HockeyDataTxtFile {
    
    
    public static void main(String[] args) throws IOException { 
        String playerNames []; // declare array for names
        int playerGoals []; // declare array for goals
        
        // open file for reading
        FileReader fileR = new FileReader ("Hockey.txt");
        BufferedReader input = new BufferedReader (fileR);
        
        playerNames = new String [5];
        playerGoals = new int [5];
        
        double average, sum = 0;
        
        for (int i = 0; i < playerGoals.length; i++){
            playerNames[i] = input.readLine ();
            playerGoals[i] = Integer.parseInt(input.readLine ());
            
            sum = sum + playerGoals[i];
            
        } // ends for
        
        fileR.close(); // closes the file
        
        average = sum / playerGoals.length; // calculating average
        
        String list = "Names\tGoals\n"; // starting the list 
        list = list + "=====\t=====\n";
        
        // adding the names and goals to the list
        for (int i = 0; i < playerGoals.length; i++){
            list = list + playerNames[i] + "\t" + playerGoals[i] + "\n";
        } // ends for
        
        list = list + "Average Goals " + average;
        
        // displaying the list
        JTextArea displayArea = new JTextArea ();
        displayArea.setText (list);
        JOptionPane.showMessageDialog (null, displayArea);
        
        // opening a file to write
        FileWriter fileW = new FileWriter("outputfile.txt");
        PrintWriter output = new PrintWriter (fileW);
        
        output.println ("Names Goals");
        output.println ("===== =====");
        
        // loop to save information into the file
        for (int j = 0; j < playerGoals.length; j++){
            output.println(playerNames[j] + " " + playerGoals[j]);
//            output.println(playerGoals[j]);
        }
        
        output.println (average);
        
        fileW.close(); // closes and writes to disk
        
    } //ends main
    
} // ends class
