import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.event.ActionEvent;
import javax.swing.JScrollPane;  
/**
 * 
 */
import javax.swing.JTextArea;

/**
 * @author Ceyhon Wilson
 * @Date May 15, 2019
 * @Description
 * @Methods 
 */
public class AccountMenuGUI extends JFrame implements ActionListener{
	private JLabel lblAccNum, lblName, lblpNum, lbladdress;
	private JButton btnSave, btnLoad, btnDesposit, btnWidthdraw, btnEdit, btnChequing, btnSaving;
	private ImagePicture backGround;
	private int width, height;
	private JPanel drawingPanel;
	private JTextArea textOutput, pNumBox, addressBox, nameBox,accBox;
	private JScrollPane scroller; 
	//Chequing insertVariableHere;
	//Saving insertVariableHere;
	private Customer user;
	/**
	 * 
	 */
	public AccountMenuGUI() {
		super("Main Menu");
	
		width = 1000;
		height = 700;
		
		setLayout(null);
	
		drawingPanel = new JPanel();
		
		textOutput = new JTextArea ();
		textOutput.setBounds(650,200,300,100);
		textOutput.setEditable(false); // setting the display area to be uneditable
		scroller = new JScrollPane(textOutput);  //scroller for the text area
		
		accBox = new JTextArea();
		accBox.setBounds(10,135,200,10);
		
		nameBox = new JTextArea();
		nameBox.setBounds(10, 180,200,20);
		
		addressBox = new JTextArea();
		addressBox.setBounds(10,195,200,20);
		
		pNumBox = new JTextArea();
		pNumBox.setBounds(10,210,200,20);
		
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");
		btnDesposit = new JButton("Desposit");
		btnWidthdraw = new JButton("Widthdraw");
		btnEdit = new JButton("Edit Account");
		//btnChequing = new JButton("Chequing");
		//btnSaving = new JButton("Savings");
		
		drawingPanel.setBounds(0,0,width,height);
		backGround = new ImagePicture(new ImageIcon("Background.png"));
		backGround.setBounds(0, 0, 1000, 700);
		
		
		
		
		btnSave.setBounds(100,270,100,30);
		btnLoad.setBounds(0,300,100,30);
		btnDesposit.setBounds(650,300,100,30);
		btnWidthdraw.setBounds(680,300,100,30);
		btnEdit.setBounds(50,240,100,30);
		//btnChequing.setBounds(0,100,width,height);
		//btnSaving.setBounds(0,100,width,height);
	
		// add button as a listener in this frame
				btnSave.addActionListener(this);
				btnLoad.addActionListener(this);
				btnDesposit.addActionListener(this);
				btnWidthdraw.addActionListener(this);
				btnEdit.addActionListener(this);
				
				
				drawingPanel.add(btnSave);
				drawingPanel.add(btnEdit);
				drawingPanel.add(btnLoad);
				drawingPanel.add(pNumBox);
				drawingPanel.add(addressBox);
				drawingPanel.add(accBox);
				drawingPanel.add(nameBox);
				drawingPanel.add(scroller);
				drawingPanel.add(backGround);
				add(drawingPanel);
				
				
				// set size and location of frame
				setSize(width,height);  
				setLocation(100,100);
				setFocusable(true); //sets the setFocusable to true
				setResizable(false);
				setVisible(true);

				setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	/**
	 * @param args
	 */
	
	public void actionPerformed (ActionEvent e){
		if (e.getSource() == btnEdit) {
			btnEdit.setFocusable(false);
		}
		if (e.getSource() == btnSave) {
			
		}
		if (e.getSource() == btnLoad) {
			
		}
		if (e.getSource() == btnDesposit) {
			//new blank;
		}
		if (e.getSource() == btnWidthdraw) {
			//new blank;
		}
	
	}
	public static void main(String[] args) {
		AccountMenuGUI bankAccount = new AccountMenuGUI();
		
	}


	@Override
	public void actionPerformed(java.awt.event.ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
