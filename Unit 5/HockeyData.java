import javax.swing.*;
/**
 * Date: November 29th 2017
 * Author: Bheesham Ramkissoon
 * Description: Takes 5 players and their goals. Averages them, and displays everything in a table
 */
public class HockeyData {
    
    
    public static void main(String[] args) { 
        String playerNames []; // declare array for names
        int playerGoals []; // declare array for goals
        
        playerNames = new String [5];
        playerGoals = new int [5];
        
        double average, sum = 0;
        
        for (int i = 0; i < playerGoals.length; i++){
            playerNames[i] = JOptionPane.showInputDialog(null, "Enter name for player " + (i + 1));
            playerGoals[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter goals for " + playerNames [i]));
            
            sum = sum + playerGoals[i];
            
        } // ends for
        
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
        
    } //ends main
    
} // ends class
