import javax.swing.*;
/**
 * Date: November 8, 2017
 * Author: Bheesham Ramkissoon
 * Description: Takes as word or phrase enetered by a user and flips it backward, and then tells them if it is a palindrome or not.
 */
public class PalindromesFinal {
    
    
    public static void main(String[] args) { 
        String forwardPhrase, reversePhrase = ""; // variables for the forwardPhrase/word and that forwardPhrase/word backwards
        int len;
        
        forwardPhrase = JOptionPane.showInputDialog(null, "Please enter a sentence or a word."); // prompting the user for forwardPhrase/word
        
        forwardPhrase = forwardPhrase.toLowerCase(); // converting the forwardPhrase to lower case
        
        // deleting the spaces in the forwardPhrase    
        forwardPhrase = forwardPhrase.replaceAll(" " , "");
        forwardPhrase = forwardPhrase.replaceAll("[^a-zA-Z]", "");
        
        len = forwardPhrase.length();
        
        // reversing the forwardPhrase/word using for loop
        for (int i = len - 1; i >= 0; i--){
            reversePhrase = reversePhrase + forwardPhrase.substring (i, i + 1);
        }
        
        // displaying the forwardPhrase/word backwards
        JOptionPane.showMessageDialog(null, "The reversed sentence is: " + reversePhrase);
        
        // checking to see if the forwardPhrase/word is a palindrome
        if (reversePhrase.equals(forwardPhrase) == true){
            JOptionPane.showMessageDialog(null, "This is a Palindrome!");
        } //ends if
        
        else {
            JOptionPane.showMessageDialog(null, "This isn't a Palindrome!");
        } //ends else
        
    } // ends main
    
} // ends class
