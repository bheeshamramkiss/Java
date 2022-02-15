import java.awt.Component;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Jacob Vongsa
 * @date May 19, 2019
 * Description: The deposit and withdrawal screen
 *
 */
public class DepWitGUI extends JFrame implements ActionListener {

	/*
	 * private variables for components of the screen,
	 * buttons for necessary function
	 */
	private JPanel mainPanel;
	private JButton btnDeposit, btnWithdraw, btnChequing, btnSaving, btnOk, btnCancel;
	private JLabel lblAmt, lblInstructions, lblText;
	private JTextField amtBox;
	private int width, height;

	/**
	 * 
	 */

	public DepWitGUI() {
		super ("Deposit/Withdrawal!"); // creating the window with a title

		// setting the height and width of the window to these variables, since they will be used
		// frequently
		width = 500;
		height = 500;

		setLayout(null); // setting a default layout for the frame

		// creating the panel
		mainPanel = new JPanel();

		// creating all the buttons
		btnChequing=new JButton("Chequing");
		btnSaving=new JButton("Savings");
		btnWithdraw=new JButton("Withdraw");
		btnDeposit=new JButton("Deposit");
		btnOk=new JButton ("Confirm");
		btnCancel=new JButton ("Cancel");

		
		
		
		
		
		
		
		//creating dropdown
		String[] acctChoices = {"Chequings", "Savings"};
		JComboBox<String> cmbAcctChoices = new JComboBox<String> (acctChoices);
		cmbAcctChoices.setBounds(100, 150, 300, 20);
		JLabel lblText = new JLabel();
		
		
		
		
		
		
		
		
		
		// labels
		lblAmt = new JLabel("Amount");
		lblAmt.setBounds(90, 211, 200, 15);
		lblInstructions = new JLabel("<html>Please Choose Chequings or Savings to Proceed<br>With Your Deposits and" +
				" Withdrawals!</html>");
		lblInstructions.setBounds(100, 0, 300, 100);
		amtBox = new JTextField();
		amtBox.setBounds(150, 210, 200, 20);
		amtBox.setEditable(true); // allowing the user to edit the text boxes


		// setting the size of the panel to be equal to the size of the window
		mainPanel.setBounds(0, 0, width, height);
		mainPanel.setLayout(null);

		//adding buttons
		btnOk.setBounds(122,375,100,25);
		add(btnOk);

		btnCancel.setBounds(265,375,100,25);
		add(btnCancel);

		//adding my components to the panel
		mainPanel.add(btnChequing);
		mainPanel.add(btnSaving);
		mainPanel.add(btnWithdraw);
		mainPanel.add(btnDeposit);
		mainPanel.add(btnOk);
		mainPanel.add(btnCancel);
		mainPanel.add(lblAmt);
		mainPanel.add(lblInstructions);
		mainPanel.add(amtBox);
		mainPanel.add(cmbAcctChoices);
		add(lblText);
		add(mainPanel); // adding the panel to the JFrame

		setSize(width, height);	
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	//combo box
	public void ComboBoxExample() {
		setSize(400,300);
	}


	//event listener
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource()==btnDeposit){

		}
		else if (evt.getSource()==btnWithdraw){

		}
		else if (evt.getSource()==btnSaving){

		}
		else if (evt.getSource()==btnChequing){

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DepWitGUI();
	}

}
