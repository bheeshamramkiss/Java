import javax.swing.*;
/**
 * Date: Oct. 2017
 * Author: Bheesham Ramkissoon
 * Daecription: The program asks the user for the capital cities of Canada. It gives the user 3 tries
 */
public class CanadaCapitals {
    
    
    public static void main(String[] args) { 
        String capital; // variables for user answer
        int tries = 0; // variables for tries
        
        // prompting the user for the capital city of Canada
        capital = IO.readString("What is the capital of Canada?", new ImageIcon("CanadaFlag.jpg"));
        
        tries++; // incrementing the tries by 1
        
        // evauating the answer to see is correct, and if it's been less than 3 tries
        while (capital.equalsIgnoreCase("Ottawa") != true && tries < 3){
            capital = IO.readString("Incorrect, try again!\nWhat is the capital of Canada?", new ImageIcon("CanadaFlag.jpg"));
            tries++;
        } // ends while
        
        // checking if user got the answer
        if (capital.equalsIgnoreCase("Ottawa") == true){
            IO.display("GJ CONGRATS YOU KNOW ONE THING ABOUT CANADA");
        }
        else {
            IO.display("Unfortunately, you didn't get the correct answer. Feel free to try again!");
        }
    } //  ends main
    
    
} // ends main
