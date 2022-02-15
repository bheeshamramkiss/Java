import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author topiwala
 * date: may 1st, 2019
 * description: program which allows save and read vehicle records to and from a file. users can also sort the information 
 * 				by certain categories, including make, and model year.
 * method list:
 *
 */
public class SortGUI extends JFrame implements ActionListener {


	/*
	 * variables for all the elements of the GUI, including the buttons, and text areas, as well as textpicture for a title
	 */
	JButton btnAdd, btnDisplay, btnSearch, btnSort, btnLoad, btnSave, btnClear, btnExit;
	JTextArea display;
	JTextField search;
	TextPicture title;
	Font titleFont;
	JLabel displayLbl;
	private VehicleList vL = new VehicleList();

	/**
	 * constructor
	 */
	public SortGUI() {
		// TODO Auto-generated constructor stub


		super("Vehicle Information System");

		// initializing elements
		btnAdd = new JButton("Add");
		btnDisplay = new JButton("Display");
		btnSearch = new JButton("Search Name");
		btnSort = new JButton("Sort Records");
		btnLoad = new JButton("Load File");
		btnSave = new JButton("Save to file");
		btnClear = new JButton("Clear");
		btnExit = new JButton("Exit");
		displayLbl = new JLabel("Search by make");


		display = new JTextArea();
		display.setEditable(false); // setting the display area to be uneditable

		search = new JTextField();

		// font, which is used by the textpicture below
		titleFont = new Font("Comic MS", Font.PLAIN, 20);

		title = new TextPicture("Vehicle Information Guide", titleFont, 20, 20);

		// bounds for elements
		title.setBounds(200, 30, 500, 30);
		btnAdd.setBounds(420, 120, 100, 30);
		btnDisplay.setBounds(550, 120, 100, 30);
		btnSearch.setBounds(410, 360, 150, 30);
		btnSort.setBounds(450, 170, 150, 30);
		btnLoad.setBounds(420, 220, 100, 30);
		btnSave.setBounds(550, 220, 100, 30);
		btnClear.setBounds(420, 270, 100, 30);
		btnExit.setBounds(550, 270, 100, 30);
		display.setBounds(30, 120, 350, 200);
		search.setBounds(30, 350, 350, 50);
		displayLbl.setBounds(30, 315, 100, 50);

		// adding elements to frame
		add(btnAdd);
		add(btnDisplay);
		add(btnSearch);
		add(btnSort);
		add(btnLoad);
		add(btnSave);
		add(btnClear);
		add(btnExit);
		add(title);
		add(display);
		add(search);
		add(displayLbl);

		// adding action listeners to each button
		btnAdd.addActionListener(this);
		btnDisplay.addActionListener(this);
		btnSearch.addActionListener(this);
		btnSort.addActionListener(this);
		btnLoad.addActionListener(this);
		btnSave.addActionListener(this);
		btnClear.addActionListener(this);
		btnExit.addActionListener(this);


		// setting size of window
		setLayout (null);
		setSize (700, 500);

		// setting visible and denying the user control over the size of the window
		setFocusable(true);
		setVisible (true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // automatically does system.exit(0) if the program is exited using 'x' at top right

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btnAdd) {
			JOptionPane.showMessageDialog(null, "To be added :)");


		}

		else if (e.getSource() == btnDisplay) {
			vL.insertionSort();
			display.setText(vL.toString());

		}

		else if (e.getSource() == btnSearch) {
			vL.insertionSort();
			display.setText(vL.toString());
			int location = vL.binarySearch(search.getText());
			if ((vL.binarySearch(search.getText()) == -1)) {
				JOptionPane.showMessageDialog(null, "Make not found.");
			}
			else {
				JOptionPane.showMessageDialog(null, "Make " + search.getText() +  " found successfully at index: " + location);
			}
		}

		else if (e.getSource() == btnSort) {
			vL.quickSort();
			display.setText(vL.toString());

		}

		else if (e.getSource() == btnLoad) {
			try {
				vL = vL.loadFile();
				display.setText("File read successful.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				display.setText("File read unsuccessful. Please try again.");
			}

		}

		else if (e.getSource() == btnSave) {
			try {
				vL.writeFile(vL);
				display.setText("File write successful.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				display.setText("File write unsuccessful. Please try again.");
			}

		}

		else if (e.getSource() == btnClear) {

			display.setText("");
			search.setText("");

		}

		else if (e.getSource() == btnExit) {

			System.exit(0);
			dispose();
		}




	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortGUI s = new SortGUI();

	}

}
