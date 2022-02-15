import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @(#)SimpleGUI.java
 *
 *
 * @author
 * @version 1.00 2017/08/7
 */
public class EagleEye extends JFrame implements ActionListener{

	private JPanel inputPanel, outputPanel, controlPanel;
	private JTextField textInput;
	private JTextArea textOutput;
	private JLabel lblInstruction, lblOutputInstruction; // declare various GUI components
	TextPicture stringTextPicture;
	private JButton btnDisplayAll, btnClear, btnAddToArray;
	private Picture pic, picBottom;
	private JScrollPane scroller;
	private Color c;
	private String stored[] = new String [10]; // declaring a string array to hold the first 10 things given inputs
	private int counter = 0;
	
	/**
	 * Creates a new instance of SimpleGUI.
	 */
	public EagleEye(){
		super("My Simple GUI"); // title for the frame

		setLayout(new GridLayout(5,1)); // layout for my frame
		inputPanel = new JPanel(); // subpanels for different areas
		outputPanel = new JPanel();
		controlPanel = new JPanel();

		// create text components
		textInput = new JTextField("Mr. Campos is the coolest!", 20);
		lblInstruction = new JLabel (" Enter your first name, last name below");
		lblOutputInstruction = new JLabel (" Your name displays below");
		stringTextPicture = new TextPicture();
		stringTextPicture.setxPos(60);
		stringTextPicture.setyPos(20);
		stringTextPicture.setTitle("You are being watched ;o)");
		stringTextPicture.setFont(new Font("Monospaced", Font.BOLD, 20));
		textOutput = new JTextArea (5,30);

		scroller = new JScrollPane(textOutput); //scroller for the text area

		btnDisplayAll = new JButton("Display input(s)"); // create button
		btnClear = new JButton("Clear Everything");
		btnAddToArray = new JButton("Add to Array");

		// create and set picture objects
		pic = new Picture(145, 10, 100, 50);
		pic.setColor(Color.BLUE);
		picBottom = new Picture (100, 10, 150, 50);
		// add components to panels
		inputPanel.add(lblInstruction);
		inputPanel.add(textInput);
		outputPanel.add(lblOutputInstruction);
		outputPanel.add(scroller);
		controlPanel.add(btnDisplayAll);
		controlPanel.add(btnClear);
		controlPanel.add(btnAddToArray);

		// add components to the frame
		add(pic);
		add(inputPanel);
		add(outputPanel);
		add(controlPanel);
		add(stringTextPicture);

		// add button as a listener in this frame
		btnDisplayAll.addActionListener(this);
		btnClear.addActionListener(this);
		btnAddToArray.addActionListener(this);

		// set size of frame
		setSize(400,600);
		setVisible(true);
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/*
	 * method to create a random color. Called upon everytime the dislplayall button is used, to change the
	 * color of the picture and text
	 */
	
	public Color colorRandomizer() {
		int r, g, b;
		
		r = (int)(Math.random() * 255 + 1);
		g = (int)(Math.random() * 255 + 1);
		b = (int)(Math.random() * 255 + 1);
		
		c = new Color (r, g, b);
		return c;
	}

	// method for actions events
	public void actionPerformed (ActionEvent e){

		if (e.getSource() == btnDisplayAll){ // if btn is clicked
			String output = "";
			for (int i = 0; i <stored.length; i++) {
				output += stored[i] + "\n";
				textOutput.setText(output);
			}
			
			//changing the colors of the image and the title text
			pic.setColor(colorRandomizer());
			stringTextPicture.setColor(colorRandomizer());

		}
		
		else if (e.getSource() == btnClear) {
			//clearing each index of the stored array
			for (int i = 0; i <stored.length; i++) {
				stored[i] = "";
			}
			
			counter = 0;
			
			textOutput.setText("");
			stringTextPicture.setTitle("You are being watched ;o)");
			repaint();
		}
		
		else if (e.getSource() == btnAddToArray) {
			//changing the colors of the image and the title text
			pic.setColor(colorRandomizer());
			stringTextPicture.setColor(colorRandomizer());
			
			if (counter < 10) {
				stored[counter] = textInput.getText();
				counter++;
			}
			
			else {
				textOutput.setText("");
				stringTextPicture.setTitle("No more space available!!!");
				stringTextPicture.setColor(Color.RED);
				repaint();
			}
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		EagleEye sGUI = new EagleEye();
	}
}
