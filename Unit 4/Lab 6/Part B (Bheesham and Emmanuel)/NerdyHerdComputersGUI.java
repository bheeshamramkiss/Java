import java.awt.event.*;
import javax.swing.*;
import java.text.*;
/**
 * Date: November 14, 2017
 * Author: Bheesham Ramkissoon
 * Description: This program calculates and displays a computer configuration and price, based on a model.
 * Method List:
 * checkModel
 * priceModel
 * calcPercent
 */
public class NerdyHerdComputersGUI extends JFrame implements ActionListener {
    JLabel lblName, lblPrice, lblDiscount, lblTax, lblTotal, lblPic, lblPic2;
    JButton btnCalculate, btnClear, btnExit;
    JTextField txtName, txtPrice, txtDiscount, txtTax, txtTotal;
    
    // number format for 2 decimal places
    NumberFormat money = new DecimalFormat ("$0.00");
    
    public NerdyHerdComputersGUI () {
        super ("Nerdy Herd Computers"); // sets the frame name
        
        //create label
        lblName = new JLabel ("Model");
        lblPrice = new JLabel ("Price");
        lblDiscount = new JLabel ("Discount");
        lblTax = new JLabel ("Tax");
        lblTotal= new JLabel ("Total");
        lblPic = new JLabel(new ImageIcon ("Computer Clipart.png"));
        lblPic2 = new JLabel(new ImageIcon ("6TB HDD.png"));
        
        // create textfield
        txtName = new JTextField ();
        txtPrice = new JTextField ();
        txtDiscount = new JTextField ();
        txtTax = new JTextField ();
        txtTotal = new JTextField ();
        
        // create button
        btnCalculate = new JButton ("Calculate");
        btnClear = new JButton ("Clear");
        btnExit = new JButton ("Exit");
        
        // set the size and layout
        // null layout allows us to place items using setBounds below
        setLayout (null);
        setSize(500, 500);
        
        // place label - set size of the label and location
        lblPic.setBounds (65, 5, 308, 154);
        lblPic2.setBounds (200, 175, 200, 201);
        lblName.setBounds (10, 150, 50, 10);
        lblPrice.setBounds (10, 190, 50, 10);
        lblDiscount.setBounds (10, 230, 50, 10);
        lblTax.setBounds (10, 270, 50, 10);
        lblTotal.setBounds (10, 310, 50, 10);
        txtName.setBounds (80, 150, 300, 20);
        txtPrice.setBounds (80, 190, 100, 20);
        txtPrice.setEditable (false);
        txtDiscount.setBounds (80, 230, 100, 20);
        txtTax.setBounds (80, 270, 100, 20);
        txtTotal.setBounds (80, 310, 100, 20);
        txtTotal.setEditable (false);
        btnCalculate.setBounds (70, 375, 100, 50);
        btnClear.setBounds (195, 375, 100, 50);
        btnExit.setBounds (320, 375, 100, 50);
        
        // add labels, textfields, buttons
        add (lblPic);
        add (lblPic2);
        add (lblName);
        add (lblPrice);
        add (lblDiscount);
        add (lblTax);
        add (lblTotal);
        add (txtName);
        add (txtPrice);
        add (txtDiscount);
        add (txtTax);
        add (txtTotal);
        add (btnCalculate);
        add (btnClear);
        add (btnExit);
        
        // make buttons listen to clicks on the window
        btnClear.addActionListener (this);
        btnCalculate.addActionListener (this);
        btnExit.addActionListener (this);
        
        // set window visible
        setVisible (true);
    }
    
    public void actionPerformed (ActionEvent evt){
        if (evt.getSource () == btnClear){
            txtName.setText ("");  
            
            txtPrice.setText ("");  
            
            txtDiscount.setText ("");  
            
            txtTax.setText ("");  
            
            txtTotal.setText ("");
            
        } // and if
        
        else if (evt.getSource () == btnCalculate){
            
            String phraseOut = NerdyHerdComputers.checkModel (txtName.getText());
            
            // matching the name to a price
            double price = NerdyHerdComputers.priceModel (txtName.getText());
            
            // taking the price and user inputted discount, to find the discounted amount
            double discountRate = Double.parseDouble (txtDiscount.getText());
            double discount = NerdyHerdComputers.calcPercent (price, discountRate);
            
            // calculating tax
            double taxRate = Double.parseDouble (txtTax.getText()); // getting the numerical value
            double tax = NerdyHerdComputers.calcPercent (price - discount, taxRate);
            
            
            // making subtotal and final price
            double subtotal = price - discount;
            double total = subtotal + tax;
            
            // displaying the description of the pc, the price, discounted amount, tax
            txtName.setText (phraseOut); 
            txtPrice.setText ("" + money.format (price));
            txtDiscount.setText ("" + money.format (discount));
            txtTax.setText ("" + money.format (tax));
            txtTotal.setText ("" + money.format (total));
            
        }
        
        else {
            dispose();
        }
    } // ends actionperformed method
    
    public static void main(String[] args) { 
        new NerdyHerdComputersGUI ();
        
    } // ends main
    
} // ends class