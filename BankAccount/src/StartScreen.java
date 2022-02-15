import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.*;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * 
 * @date May 13, 2019
 * Description: The start screen for the bank account application
 *
 */
public class StartScreen extends JFrame implements ActionListener {

	/*
	 * private variables for components of the screen,
	 * buttons for necessary function
	 */
	private JPanel mainPanel;
	private JButton btnLogin, btnExit, btnRegister;
	private JLabel lblAcctNum, lblPass, lblWelcomeMsg, lblFName, lblLName, lblAddress, lblPNum, title, lblPassReg, lbluserName;
	private JTextField acctBox, passBox, fNameBox, lNameBox, addressBox, pNumBox, passRegBox, userNameBox;
	private ImagePicture mainIcon, bgnd;

	/*
	 * variables for the size of the frame, and titles
	 */
	private int width, height;

	/**
	 * constructor for the GUI
	 */
	public StartScreen() {
		super ("Welcome!"); // creating the window with a title

		// setting the height and width of the window to these variables, since they will be used
		// frequently
		width = 1000;
		height = 400;

		setLayout(null); // setting a default layout for the frame

		// creating the panel
		mainPanel = new JPanel();

		// creating all the buttons
		btnLogin = new JButton("Login");
		btnLogin.setBounds(100, 210, 100, 30);

		btnExit = new JButton("Exit");
		btnExit.setBounds(700, 310, 150, 20);

		btnRegister = new JButton("Register Now");
		btnRegister.setBounds(700, 280, 150, 20);

		// creating all the icons, text boxes, and title		
		title = new JLabel("RJC Bank");
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		title.setForeground(Color.BLUE);
		title.setBounds(110, 30, 200, 50);

		lblAcctNum = new JLabel("Account Number");
		lblAcctNum.setBounds(10, 120, 200, 10);

		acctBox = new JTextField();
		acctBox.setBounds(10, 135, 200, 20);

		lblPass = new JLabel("Password");
		lblPass.setBounds(10, 165, 200, 10);

		passBox = new JTextField();
		passBox.setBounds(10, 180, 200, 20);

		lblWelcomeMsg = new JLabel("<html>Welcome to RJC Bank! Please, login below.<br>If you do not " +
				"have an account with us,<br>please feel free to register " +
				"by hitting the button 'Register Now'. Have a nice day.</html>");
		lblWelcomeMsg.setBounds(650, 0, 300, 100);

		lblFName = new JLabel ("First Name:");
		lblFName.setBounds(600, 110, 150, 20);

		fNameBox = new JTextField();
		fNameBox.setBounds(600, 135, 150, 20);

		lblLName = new JLabel("Last Name:");
		lblLName.setBounds(800, 110, 150, 20);

		lNameBox = new JTextField();
		lNameBox.setBounds(800, 135, 150, 20);

		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(600, 160, 150, 20);

		addressBox = new JTextField();
		addressBox.setBounds(600, 185, 150, 20);

		lblPNum = new JLabel("Phone Number:");
		lblPNum.setBounds(800, 160, 150, 20);

		pNumBox = new JTextField();
		pNumBox.setBounds(800, 185, 150, 20);

		lblPassReg = new JLabel("Account Password:");
		lblPassReg.setBounds(600, 210, 150, 20);

		passRegBox = new JTextField();
		passRegBox.setBounds(600, 235, 150, 20);

		lbluserName = new JLabel("Username:");
		lbluserName.setBounds(800, 210, 150, 20);

		userNameBox = new JTextField();
		userNameBox.setBounds(800, 235, 150, 20);

		try {
			mainIcon = new ImagePicture(new ImageIcon(getClass().getResource("BankMainIcon.png")));
		} 
		catch(Exception e2) {
			JOptionPane.showMessageDialog(null, "Sorry; It appears there is an error with regards to finding this image");
		}
		mainIcon.setBounds(0, 0, 100, 100);

		try {
			bgnd = new ImagePicture(new ImageIcon(getClass().getResource("Background.png")));
		} 
		catch(Exception e2) {
			JOptionPane.showMessageDialog(null, "Sorry; It appears there is an error with regards to finding this image");
		}
		bgnd.setBounds(0, 0, 1000, 400);

		// setting the size of the panel to be equal to the size of the window
		mainPanel.setBounds(0, 0, width, height);
		mainPanel.setLayout(null);

		// adding actionListeners to all buttons on the screen
		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
		btnRegister.addActionListener(this);

		//adding my components to the panel
		mainPanel.add(btnLogin);
		mainPanel.add(btnExit);
		mainPanel.add(btnRegister);

		mainPanel.add(lblAcctNum);
		mainPanel.add(lblPass);
		mainPanel.add(lblWelcomeMsg);
		mainPanel.add(lblFName);
		mainPanel.add(lblLName);
		mainPanel.add(lblAddress);
		mainPanel.add(lblPNum);
		mainPanel.add(lblPassReg);
		mainPanel.add(lbluserName);

		mainPanel.add(acctBox);
		mainPanel.add(passBox);
		mainPanel.add(fNameBox);
		mainPanel.add(lNameBox);
		mainPanel.add(addressBox);
		mainPanel.add(pNumBox);
		mainPanel.add(passRegBox);
		mainPanel.add(userNameBox);

		mainPanel.add(mainIcon);

		mainPanel.add(title);

		mainPanel.add(bgnd);

		add(mainPanel); // adding the panel to the JFrame

		setSize(width, height);	
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/**
	 * self-testing main method
	 */
	public static void main(String[] args) {
		new StartScreen();
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			JOptionPane.showMessageDialog(null, "Good-Bye.");
			System.exit(0);
		}
		else if (e.getSource() == btnLogin) {
			/* getting the account number and password, checking to see if it matches with any
			 * pre-made accounts
			 */
			String [] accounts = null;

			// loading any already created accounts
			// call the loader method
			boolean state = false; // variable used to stop the invalid login message from showing
			try {
				accounts = Loader.loadFile("Accounts.txt");

				// checking to see if anything matches
				String combinedLogin = acctBox.getText() + "/" + passBox.getText();

				for (int i = 0; i < accounts.length; i++) {
					if (accounts[i].equals(combinedLogin)) {
						JOptionPane.showMessageDialog(null, "Login Successful. Welcome to RJC Bank.");
						state = true;
						dispose();
						new AccountMenuGUI();
						//LAUNCH MAIN UI
					}
				} // ends for

				if (state = false) {
					JOptionPane.showMessageDialog(null, "Invalid Account Number/Password. Please try again");
				}

			} catch (IOException e1) {
				// error if file is not read, does not exist, error with file formatting
				// formatting
				JOptionPane.showMessageDialog(null, "Sorry; It appears there is an error with" +
						" the file we are trying to load from. This means:" +
						"\n -There are no registered accounts" +
						"\n-There is an error with the formatting of the file we are trying to read from" +
						"\n We are sorry for the inconvenience.");
			} // catch

		} // else if

		else if (e.getSource() == btnRegister) {
			/*
			 * creating a customer, a chequing and savings account, and giving the user a username (chequing 
			 * account number) and a password to login with. once the account is made, it is written to a txt
			 * file so that the customer can be recognized as a registered account in the system.
			 */

			Customer c1 = new Customer(fNameBox.getText(), lNameBox.getText(), addressBox.getText(), pNumBox.getText());
			JOptionPane.showMessageDialog(null, "Account creation successful! Welcome " + c1.getfName() + " " +
					c1.getlName() + ". Please make a note of your account number that will be used to login, as well as your password:"
					+ "\nUsername: " + userNameBox.getText() + "\nPassword: " + passRegBox.getText() +
					"\nThank you for choosing RJC Banking.");

			fNameBox.setText("");
			lNameBox.setText("");
			addressBox.setText("");
			pNumBox.setText("");

			/*
			 * writing the customer's username and password into a txt file so they can be recognized by the system
			 * when they log in.
			 */

			try {
				CustomerWriter.write(c1);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "We had an error while trying to register you. Please try again.");				
			}

			try {
				AccountWriter.write(userNameBox.getText(), passRegBox.getText());
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "We had an error while trying to register you. Please try again.");				
			}
			
			userNameBox.setText("");
			passRegBox.setText("");
		}

	}

}
