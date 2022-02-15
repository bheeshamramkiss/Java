import javax.swing.*;
import java.awt.*;
/**
 * Date: Oct. 2017
 * Author: Bheesham Ramkissoon
 * Description: Draw the torso, 2 legs, head, and speech bubble of a character on screen
 */
public class DrawingExample extends JFrame{
    
    ImageIcon backGnd;
    
    public DrawingExample() { 
        /* YOUR CONSTRUCTOR CODE HERE*/
        super("HI_SUPRA_LOVER_101");
        backGnd = new ImageIcon("whiteback.jpg");
        setSize(500, 400);
        setVisible(true);
    }
    
    public void paint (Graphics g){
    backGnd.paintIcon(this, g, 0, 0); // draw the white background
    g.setColor(Color.BLUE); // set the color to blue
    g.fillRect(50, 100, 80, 100); // draw the body
    
    g.setColor(Color.RED); // sets color to red
    g.drawRect(50, 200, 20, 60); // draw the left leg
    g.drawRect(110, 200, 20, 60); // draw the right leg
    
    g.setColor(new Color(25, 25, 112));  // draws head in midnight blue
    g.fillOval(70, 60, 40, 40);
    
    g.drawOval(120, 50, 100, 25); // draws chat bubble
    g.drawString("Hello BOII!", 130, 70); // draws text
    }
    
    public static void main(String[] args) { 
       new DrawingExample();
    }

    
}
