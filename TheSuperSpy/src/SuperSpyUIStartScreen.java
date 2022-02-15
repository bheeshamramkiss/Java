import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 27, 2019
 * Description: This the main start screen for the Super Spy Encryption Program
 */
public class SuperSpyUIStartScreen extends JFrame implements ActionListener {

	// creating variables for a title picture as well as the main buttons to navigate through the UI
	JLabel titlePic;
	JButton btnManual, btnFileLoader, btnExit;

	/**
	 * The constructor by which the title picture is initialized, and the button are created and added to the panel
	 */
	public SuperSpyUIStartScreen() {
		super ("The Super Spy Encryption/Decryption Program");
		titlePic = new JLabel (new ImageIcon("PabloPenguinSpy.PNG"));

		//setting the size of the window
		setLayout(null);
		setSize (1000, 600);
		setResizable(false);

		//creating the buttons for the help menu, the live and file selection modes, and an exit button
		//btnManual = new JButton("Manual Mode"); 
		btnExit = new JButton("Exit");
		btnFileLoader = new JButton("File Loading Mode");

		//setting the size of the buttons, and their on screen placement
		titlePic.setBounds(50, 100, 370, 310);
		btnFileLoader.setBounds (550, 250, 300, 25);
		//btnManual.setBounds (550, 230, 300, 25);
		btnExit.setBounds (550, 290, 300, 25);

		//adding each button to the screen
		add(titlePic);
		//add(btnManual);
		add(btnExit);
		add(btnFileLoader);

		//adding action listener's to each button
		btnFileLoader.addActionListener(this);
		//btnManual.addActionListener(this);
		btnExit.addActionListener(this);

		setVisible(true);

	} // ending the constructor


	public static void main(String[] args) {
		new SuperSpyUIStartScreen();

	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * This method controls what action occurs following the press of the appropriate button
	 */
	public void actionPerformed(ActionEvent evt) {

		//actions to occur if each respective button is clicked
		if (evt.getSource() == btnExit) {
			System.exit(0);
		}

		else if (evt.getSource() == btnFileLoader) {
			dispose();
			new SuperSpyUILoader();
		}

		//		if (evt.getSource() == btnManual) {
		//			dispose();
		//			new SuperSpyUIManualEntry();
		//		}

	}

}
