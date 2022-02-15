import javax.swing.*;
import java.awt.*;
/**
 * Date: November 9th 2017
 * Author: Bheesham Ramkissoon
 * Description: Draws several cars onscreen
 */
public class DrawCarExample extends JFrame {
    
    ImageIcon backGnd; // image for background
    String userName;
    
    public DrawCarExample() { 
        super ("My cars!"); // sets title
        setSize (400, 400); // sets size
        backGnd = new ImageIcon ("whiteback.jpg");
        
        // asking for user's name
        userName = JOptionPane.showInputDialog (null, "What is your name?");
        
        setVisible(true);
    }
    
    public void paint (Graphics g){
        backGnd.paintIcon(this, g, 0, 0); // paint background
        int x = 50, y = 50;
        Color c = Color.RED; // car color
        Color w = Color.BLUE; // window color
        carPaint (g, x, y, c, w, userName);
        
        c = Color.YELLOW;
        carPaint (g, x + 200, y, c, w, userName);
        
        c = Color.MAGENTA;
        carPaint (g, x, y + 200, c, w, userName);
        
        carPaint (g, x + 200, y + 200, Color.CYAN, Color.BLUE, userName);
    }
    
    // name doesnt really matter, as long as the parameters (varibae types) are the same
    public void carPaint (Graphics g, int x, int y, Color body, Color window, String userName){
        g.setColor (body);
        g.fillRect (x, y, 100, 30);  // draws body
        
        g.setColor (window);
        g.fillRect (x + 25, y - 20, 50, 20); // draws the window
        
        g.setColor (Color.BLACK);
        g.fillOval (x + 10, y + 25, 20, 20); // draws the two wheels
        g.fillOval (x + 65, y + 25, 20, 20);
        
        g.drawString (userName, x + 15, y + 25);
    }
    
    public static void main(String[] args) { 
        new DrawCarExample();  // calls the constructor
        
    }
    
}
