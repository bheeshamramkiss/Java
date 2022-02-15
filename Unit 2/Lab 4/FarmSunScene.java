import java.awt.*;
import javax.swing.*;
/**
 * Date: Oct. 2017
 * Author: Bheesham Ramkissoon
 * Description: Has a bouncing sun above a farm house
 */
public class FarmSunScene extends JFrame{
     
     ImageIcon sun, farm;
     int sunX = 50, sunY = 50, farmX = 302, farmY = 200, sunSpeedY = 1; // varables for the sun and farm positionss
     double slow = 1;
     public FarmSunScene() { 
          /* YOUR CONSTRUCTOR CODE HERE*/
          super ("Farm Happiness");
          setSize (800, 600);
          // assigning the farm and sun variables to images
          sun = new ImageIcon ("SunWithGlasses.png");
          farm = new ImageIcon ("FarmHouse.png");
          setVisible (true);        
     } // ends the constructor
     
     public void paint (Graphics g){ 
         for (int i = 0; i <=10000; i++){    
               // drawing the background
               g.setColor (new Color (96, 192, 230));
               g.fillRect (0 , 0, 800, 600);
               
               // drawing the grass
               g.setColor (new Color (52, 206, 0));   
               g.fillRect (0, 450, 800, 150);
               
               sun.paintIcon (this, g, sunX, sunY);
               farm.paintIcon (this, g, farmX, farmY);
               
               sunY = sunY + sunSpeedY; // this allows the y corrdinate of the sun to be moved by its speed factor
               
               // speeds of the sun
               if ((sunY >= 350) || (sunY < 50)){
                    sunSpeedY = sunSpeedY * -1;
               }
               
               for (int t = 0; t < 5000; t++){
                    slow = Math.pow(slow, 20);
               }
               
               //sun.paintIcon (this, g, sunX, sunY);
               //farm.paintIcon (this, g, farmX, farmY);
               
          } // ends for
     } // ends paint method
     
     public static void main(String[] args) { 
          new FarmSunScene();
     } // ends main
     
     
} // ends class