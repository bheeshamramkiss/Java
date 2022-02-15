import javax.swing.*;
/**
 * Date: Oct. 2017
 * Author: Bheesham Ramkissoon
 * Description: Takes a 6 chatacter word and capitalizes the first letter
 */
public class CapitalizeWord {
    
    
    public static void main(String[] args) { 
       String input, output;
       String firstLetter, restOfWord;
       
        input = JOptionPane.showInputDialog(null, "Enter Word");
        
        firstLetter = input.substring(0, 1);
        
        restOfWord = input.substring (1);
        
        firstLetter = firstLetter.toUpperCase();
        
        output = firstLetter + restOfWord;
        
        JOptionPane.showMessageDialog(null, output);
    }

    
}
