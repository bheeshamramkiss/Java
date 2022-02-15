import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * 
 */

/**
 * @author cober
 *
 */
public class AccountMenu extends JFrame implements ActionListener {
	/*
	 * private variables for components of the screen,
	 * buttons for necessary function
	 */
	private JLabel lblAccNum, lblfName, lblpNum, lblAddress, lblLName;
	private JButton btnSave, btnLoad, btnDesposit, btnWidthdraw, btnEdit, btnChequing, btnSaving,btnBack;
	private ImagePicture backGround;
	private JPanel drawingPanel;
	private JTextArea textOutput, pNumBox, addressBox, fNameBox, lNameBox, accBox;
	private JScrollPane scroller; 
	private Customer[] user;
	private Chequing[] users;
	private Savings[] accounts;
	/**
	 * variables for the size of the frame, and titles
	 */
	private int width, height;
	public AccountMenu() {
		super("Main Menu");// creating the window with a title

		// setting the height and width of the window to these variables
		width = 1000;
		height = 700;

		setLayout(new GridLayout(5,1));// setting a default layout for the frame

		// creating the panel
		drawingPanel = new JPanel();
		// creating display for transactions
		textOutput = new JTextArea (5,30);
		textOutput.setBounds(650,200,300,100);
		textOutput.setEditable(false); // setting the display area to be uneditable
		scroller = new JScrollPane(textOutput);  //scroller for the text area

		lblAccNum = new JLabel("Account Number");
		lblAccNum.setBounds(10, 120, 200, 10);

		accBox = new JTextArea(1,10);
		accBox.setBounds(10,135,200,10);
		accBox.setEditable(false);

		lblfName = new JLabel("First Name");
		lblfName.setBounds(10, 165, 200, 10);

		fNameBox = new JTextArea(1,10);
		fNameBox.setBounds(10, 180,200,20);
		fNameBox.setEditable(false);

		lblLName = new JLabel("Last Name");
		lblLName.setBounds(10,195,200,10);

		lNameBox = new JTextArea(1,10);
		lNameBox.setBounds(10,210,200,10);
		lNameBox.setEditable(false);

		lblAddress = new JLabel("Address");
		lblAddress.setBounds(10,225,200,20);

		addressBox = new JTextArea(1,10);
		addressBox.setBounds(10,240,200,20);
		addressBox.setEditable(false);

		lblpNum = new JLabel("Phone Number");
		lblpNum.setBounds(10,255,200,20);

		pNumBox = new JTextArea(1,10);
		pNumBox.setBounds(10,270,200,20);
		pNumBox.setEditable(false);

		// creating all the buttons
		btnSave = new JButton("Save");
		btnLoad = new JButton("Load");
		btnDesposit = new JButton("Desposit");
		btnWidthdraw = new JButton("Widthdraw");
		btnEdit = new JButton("Edit Account");
		btnBack = new JButton("Go Back");

		drawingPanel.setBounds(0,0,width,height);
		backGround = new ImagePicture(new ImageIcon("Background.png"));
		backGround.setBounds(0, 0, 1000, 700);

		btnSave.setBounds(300,500,100,30);
		btnLoad.setBounds(100,300,100,30);
		btnDesposit.setBounds(650,300,100,30);
		btnWidthdraw.setBounds(680,300,100,30);
		btnEdit.setBounds(50,240,100,30);
		btnBack.setBounds(700,240,100,30);

		// add button as a listener in this frame
		btnSave.addActionListener(this);
		btnLoad.addActionListener(this);
		btnDesposit.addActionListener(this);
		btnWidthdraw.addActionListener(this);
		btnEdit.addActionListener(this);
		btnBack.addActionListener(this);

		// adding buttons, labels, displays, to the frame
		drawingPanel.add(btnSave);
		drawingPanel.add(btnEdit);
		drawingPanel.add(btnLoad);
		drawingPanel.add(btnDesposit);
		drawingPanel.add(btnWidthdraw);
		drawingPanel.add(btnBack);
		drawingPanel.add(pNumBox);
		drawingPanel.add(addressBox);
		drawingPanel.add(accBox);
		drawingPanel.add(fNameBox);
		drawingPanel.add(lNameBox);
		drawingPanel.add(scroller);
		drawingPanel.add(backGround);
		drawingPanel.add(lblAccNum);
		drawingPanel.add(lblpNum);
		drawingPanel.add(lblfName);
		drawingPanel.add(lblAddress);
		drawingPanel.add(lblLName);
		add(drawingPanel);


		// set size and location of frame
		setSize(width,height);  
		setLocation(100,100);
		setFocusable(true); //sets the setFocusable to true
		setResizable(false);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Loop to go through each customer and make a savings and chequing account for each
				for (int i=0;i<user.length;i++) {
					
				}
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		AccountMenu bankAccount = new AccountMenu();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEdit) {
			btnEdit.setEnabled(false);
			btnSave.setEnabled(true);
			btnLoad.setEnabled(true);

			fNameBox.setEditable(true);
			lNameBox.setEditable(true);
			addressBox.setEditable(true);
			pNumBox.setEditable(true);

		}
		else if (e.getSource() == btnSave) {
			btnEdit.setEnabled(true);
		}
		else if (e.getSource() == btnLoad) {
			btnEdit.setEnabled(true);
		}
		else if (e.getSource() == btnDesposit) {
			//new blank;
		}
		else if (e.getSource() == btnWidthdraw) {
			//new blank;
		}
		else if (e.getSource() == btnBack) {
			dispose();
			new StartScreen();
		}

	}

}
