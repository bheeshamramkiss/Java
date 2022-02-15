import javax.swing.*;
/**
 * Date: Oct. 2017
 * Author: Bheesham Ramkissoon
 * Description: Determines the fine for speeding given the speed the user was caught at
 */
public class SpeedingTicket {
    
    
    public static void main(String[] args) { 
        int speed;  // variable for the driver's speed
        String answer = "Yes"; // variable used to restart the program
        
        while (answer.equalsIgnoreCase("yes")){
            //input
            speed = Integer.parseInt(JOptionPane.showInputDialog(null, "Hey, what speed were you caught at?"));
            
            // processing - finding the fine the driver will get
            if (speed < 0){
                JOptionPane.showMessageDialog(null, "C'mon! Enter a valid speed please! Unless you were going in reverse, then uh, don't do it again. Like, ever.");
            }
            else if (speed > 0 && speed <= 100){
                JOptionPane.showMessageDialog(null, "Good job! You were doing the limit! So, your fine is $0!");
            }
            else if (speed > 100 && speed <= 120){
                JOptionPane.showMessageDialog(null, "Okay, so, you have a fine; it's $80.00.");
            }
            else if (speed > 120 && speed <= 130){
                JOptionPane.showMessageDialog(null, "Well, you're starting to really push it on this road. Your damage? $150.00 smackaroos from your wallet please.");
            }
            else if (speed > 130 && speed <= 140){
                JOptionPane.showMessageDialog(null, "Oh boy, that was too fast. For that, it's $300.00");
            }
            else if (speed > 140 && speed <= 200){
                JOptionPane.showMessageDialog(null, "I'm not evern going to say anything at this point. Except what I just said. Acutally no, I have one more thing to say; $500.00");
            }
            else {
                JOptionPane.showMessageDialog(null, "$10,000.00. That's all I have to say.");
            }
                       
            // prompting user to to play again
            answer = JOptionPane.showInputDialog(null, "Do you wanna calculate the fine for another speed you might have? Say yes if you want to, or no if otherwise." , "Yes");
        } // ends while
    } // ends main
    
    
} // ends class
