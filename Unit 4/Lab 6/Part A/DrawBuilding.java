import javax.swing.*;
import java.awt.*;
/**
 * Date: November 10th 2017
 * Author: Bheesham Ramkissoon
 * Description: Draws several cars onscreen with a building
 */
public class DrawBuilding extends JFrame {
    
    ImageIcon backGnd; // image for background
    String userName; // variable for the username
    
    public DrawBuilding() { 
        /* YOUR CONSTRUCTOR CODE HERE*/
        super ("My cars!"); // sets title
        setSize (600, 400); // sets size
        backGnd = new ImageIcon ("LightpostPixelBG.png");
        
        // asking for user's name
        userName = JOptionPane.showInputDialog (null, "What is your name?");
        
        setVisible(true);
    }
    
    public void paint (Graphics g){
        backGnd.paintIcon(this, g, 0, 0); // paint background
        int x = 50, y = 50;
        Color c = Color.BLACK; // car color
        Color w = Color.BLUE; // window color
        
        // drawing the building
        drawbuilding (g, x + 75, y + 100);
        drawbuilding (g, x + 300, y + 100);
        
        c = Color.MAGENTA;
        carPaint (g, x, y + 300, c, w, userName);
        
        c = Color.GREEN;
        carPaint (g, x + 400, y + 300, c, w, userName);
        
        carPaint (g, x + 200, y + 300, Color.CYAN, Color.BLUE, userName);
        
        
    }
    
    public void carPaint (Graphics g, int x, int y, Color body, Color window, String userName){
        g.setColor (body);
        g.fillRect (x, y, 100, 30);  // draws body
        
        g.setColor (window);
        g.fillRect (x + 25, y - 20, 50, 20); // draws the window
        
        g.setColor (Color.BLACK);
        g.fillOval (x + 10, y + 25, 20, 20); // draws the two wheels
        g.fillOval (x + 65, y + 25, 20, 20);
        
        g.drawString (userName, x + 15, y + 25); // drawing the username over cars
    }
    
    public void drawbuilding (Graphics g, int x, int y){
        g.setColor (Color.BLACK);
        g.fillRect (x, y, 100, 200);
        
        // drawing windows
        g.setColor (Color.YELLOW);
        g.fillRect (x + 10, y + 10, 20, 20);
        g.fillRect (x + 70, y + 10, 20, 20);
        g.fillRect (x + 10, y + 50, 20, 20);
        g.fillRect (x + 70, y + 50, 20, 20);
        g.fillRect (x + 10, y + 90, 20, 20); 
        g.fillRect (x + 70, y + 90, 20, 20);
        
        //drawing the door
        g.setColor (Color.BLUE);
        g.fillRect (x + 30, y + 120, 40, 70); 
    }
    
    public static void main(String[] args) { 
        new DrawBuilding(); 
    }
    
    
}
