import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date March 1, 2019
 * Description: This is the GUI for the file loading part of the SuperSpy encryption program
 *  *
 */
public class SuperSpyUILoader extends JFrame implements ActionListener {

	JTextArea contentArea = new JTextArea();
	JButton btnEncrypt, btnDecrypt, btnMenu, btnFileSelect;
	JTextField filePath;

	public SuperSpyUILoader() {
		// giving a title to the window
		super ("The Super Spy Encryption/Decryption Program");

		//setting the layout and size of the window
		setLayout(null);
		setSize (1000, 600);
		setResizable(false);

		// creating buttons, text fields, and adding them to the window
		btnEncrypt = new JButton("Encrypt");
		btnDecrypt = new JButton("Decypt");
		btnMenu = new JButton("Back to Main Menu");
		btnFileSelect = new JButton("Select");
		filePath = new JTextField("TheWolfInSheepsClothingFable.txt");

		// setting the size of the textAreas and other on screen components
		contentArea.setBounds(50, 40, 900, 400);
		contentArea.setEditable(false); // this takes away the ability for the user to edit the window, as it should not be editable.
		filePath.setBounds(250, 5, 500, 20);
		btnFileSelect.setBounds(750, 5, 100, 20);
		btnEncrypt.setBounds(200, 450, 100, 20);
		btnDecrypt.setBounds(700, 450, 100, 20);
		btnMenu.setBounds(400, 500, 200, 20);

		add(contentArea);
		add(btnEncrypt);
		add(btnDecrypt);
		add(btnMenu);
		add(btnFileSelect);
		add(filePath);

		//adding an actionListener to each button
		btnEncrypt.addActionListener(this);
		btnDecrypt.addActionListener(this);
		btnMenu.addActionListener(this);
		btnFileSelect.addActionListener(this);

		setVisible(true);
	} // ends constructor

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SuperSpyUILoader();

	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * This actionPerformed method allows the program to function following the appropriate button press
	 */
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnEncrypt) {
			String fileContent[] = null;
			String contentToDisplay = "";
			try {
				fileContent = TheLoaderClass.loadFile(filePath.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Unsuccessful Encryption.");				
			}

			contentToDisplay = Encrypter.encryptionPhrase(fileContent, Integer.parseInt(fileContent [0]));
			contentArea.setText(contentToDisplay);

			try {
				TheLoaderClass.writeFile(contentToDisplay, "Encrypted.txt", Integer.parseInt(fileContent[0]));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error writing to file");
			}

		}

		else if (evt.getSource() == btnFileSelect) {
			String contentToDisplay[] = null;
			String content = "";

			try {
				contentToDisplay = TheLoaderClass.loadFile(filePath.getText());

				for (int k = 1; k < contentToDisplay.length; k++) {
					content += contentToDisplay[k] + "\n";
				}

				contentArea.setText(content);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error: No/Incorrect file name detected!");
			}


		}

		else if (evt.getSource() == btnDecrypt) {
			String contentToDecrypt[] = null;
			String contentToDisplay = "";

			try {
				contentToDecrypt = TheLoaderClass.loadFile("Encrypted.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error: Unsuccessful Decryption");				
			}

			contentToDisplay = Encrypter.decryptionPhrase(contentToDecrypt, Integer.parseInt(contentToDecrypt[0]));
			contentArea.setText(contentToDisplay);
		}

		else if (evt.getSource() == btnMenu) {
			dispose();
			new SuperSpyUIStartScreen();
		}
	} // actionPerformed ends

} // class
