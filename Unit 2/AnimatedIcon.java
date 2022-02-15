import javax.swing.*;
import java.awt.*;
/**
 * Date: Oct. 2017
 * Author: Bheesham Ramkissoon
 * Description: Draws a red ball, and animates it going from top left to bottom right in a diagonal direction
 */
public class AnimatedIcon extends JFrame {
    int x = 0, y = 100, xSpeed = 10, ySpeed = 10; // x and y positions, and the speeds respectively
    double k = 1.0;
    ImageIcon rocket, backGnd; // variables for the background and rocket image
    
    public AnimatedIcon() { 
        /* YOUR CONSTRUCTOR CODE HERE*/
        super ("Moving a rocket"); // Name to be displayed at the top of the window
        rocket = new ImageIcon ("rocket.png");
        backGnd = new ImageIcon ("background.jpg");
        
        setSize (660, 650); // sets the size of the frame
        setVisible (true); // displays the frame    
        
    } // end of constructor
    
    public void paint (Graphics g){
        for (int i = 0; i <= 1000; i++){
            backGnd.paintIcon (this, g, 0, 0);
            
            x = x + xSpeed; // moves the x and y position over 1
            y = y + ySpeed;
            
            rocket.paintIcon(this, g, x, y);
            
            if ((x > 450) || (x <= 0)){
                xSpeed = xSpeed * -1;
            }
            
            if ((y > 450) || (y <40)){
                ySpeed = ySpeed * -1;
            }
            for (int j = 0; j< 500000; j++){
                k = Math.pow (k, 20);
            }
        }
        
    } // ends paint
    
    
    
    public static void main(String[] args) {
        new AnimatedIcon(); // creates a AnimatedIcon frame        
    } // ends main
    
    
} // ends class
