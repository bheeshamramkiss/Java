import javax.swing.*;
/**
 * Date: Oct. 2017
 * Author: Bheesham Ramkissoon
 * Description:
 */
public class FindVowels {
    
    
    public static void main(String[] args) { 
        String word;
        String letter = "", vowels = "";
        
        word  = JOptionPane.showInputDialog(null, "Enter a word plz skc bby");
        
        // remember its only less than length because if its a 6 letter word, its length is 7, but you're only checking 6 letters!
        for (int i = 0; i < word.length(); i++){
            letter = word.substring(i, i + 1);
            letter = letter.toUpperCase();
            
            char character = letter.charAt(0); // getting the first character of letter
            int ascii = (int)character; // converting to acii code
            
            // if letter is an a or e
            if ((ascii == 65) || (ascii == 69) || (ascii == 73) || (ascii == 79) || (ascii == 85)){
                vowels = vowels + letter;
            } // ends if
            
            JOptionPane.showMessageDialog(null, vowels);
            
        } // ends for
    } // main        
} // class
