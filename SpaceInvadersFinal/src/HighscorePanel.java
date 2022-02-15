import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author thind
 *
 */
public class HighscorePanel extends JPanel implements ActionListener {

	private JButton btnSortScore, btnSortName, btnSearchScore, btnSearchName, btnBack;
	private JTextArea txtDisplay;
	private JLabel lblTitle, lblSubtitles;
	private HighscoreList hList = new HighscoreList();
	private String [] array = new String [5];
	private HighscoreRecord record = new HighscoreRecord();

	public HighscorePanel() {

		// Panel stuff
		setSize(1000, 700);
		setBackground(Color.BLACK);
		setLayout(null);
		setVisible(true);

		btnSortScore = new JButton("Sort Score");
		btnSortName = new JButton("Sort Name");
		btnSearchScore = new JButton ("Search for a Score");
		btnSearchName = new JButton("Search for a Name");
		btnBack = new JButton("Back");
		txtDisplay = new JTextArea();
		txtDisplay.setForeground(Color.GREEN);
		txtDisplay.setBackground(Color.BLACK);
		lblTitle = new JLabel("Highscores");
		lblTitle.setForeground(Color.GREEN);
		lblSubtitles = new JLabel("Username       Score             Time");
		lblSubtitles.setForeground(Color.GREEN);

		setSize(1000, 700);
		setLayout(null);

		btnSortScore.setBounds(60, 500, 100, 35);
		btnSortName.setBounds(220, 500, 100, 35);
		btnSearchScore.setBounds(390, 500, 150, 35);
		btnSearchName.setBounds(590, 500, 150, 35);
		btnBack.setBounds(800, 500, 100, 35);
		txtDisplay.setBounds(150, 275, 700, 400);
		lblTitle.setBounds(280, 75, 700, 50);
		lblSubtitles.setBounds(150, 25, 700, 400);

		// creating a custom font to use
        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("8-bit pusab.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
            
            txtDisplay.setFont(customFont);
            lblTitle.setFont(customFont.deriveFont(45f));
            lblSubtitles.setFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
		
		add(btnSortScore);
		add(btnSortName);
		add(btnSearchScore);
		add(btnSearchName);
		add(btnBack);
		add(txtDisplay);
		add(lblTitle);
		add(lblSubtitles);
		
		int tabSize = txtDisplay.getTabSize(); // 8

	    // Change the tab size
	    tabSize = 8;
	    txtDisplay.setTabSize(tabSize);

		btnSearchName.setEnabled(false);
		
		btnSortScore.addActionListener(this);
		btnSortName.addActionListener(this);
		btnSearchScore.addActionListener(this);
		btnSearchName.addActionListener(this);
		btnBack.addActionListener(this);

		try {
			array = hList.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String list = "";
		for(int i =0; i<hList.getList().length;i++) {
			HighscoreRecord hR = new HighscoreRecord();
			hR.processRecord(array[i]);
			hList.insert(hR);
			list = list + hR.toDisplayString() + "\n";
		}

		txtDisplay.setText(list);
	}

	public void actionPerformed(ActionEvent evt){

		if(evt.getSource() == btnSortScore) { 
			btnSearchScore.setEnabled(true);	
			btnSearchName.setEnabled(false);
			hList.sortInt(0, hList.getList().length-1);
			txtDisplay.setText(hList.toString());
		}

		if(evt.getSource() == btnSortName) {
			btnSearchName.setEnabled(true);
			btnSearchScore.setEnabled(false);
			hList.sortString(0, hList.getList().length-1);
			txtDisplay.setText(hList.toString());
		}

		if(evt.getSource() == btnSearchScore) {
			int userInput = Integer.parseInt(JOptionPane.showInputDialog(null, "Input score you want to search for"));

			if(hList.binarySearch("", userInput) <0) {
				JOptionPane.showMessageDialog(null, "Record not found");
			}

			else {
				record.processRecord(array[hList.binarySearch("", userInput)]);

				JOptionPane.showMessageDialog(null, record.getUserName() + " has the following record: \n" + record.toString());
			}
		}

		if(evt.getSource() == btnSearchName) {
			String userInput = JOptionPane.showInputDialog(null, "Input score you want to search for");

			if(hList.binarySearch(userInput, 0) <0) {
				JOptionPane.showMessageDialog(null, "Record not found");
			}

			else {
				record.processRecord(array[hList.binarySearch(userInput, 0)]);

				JOptionPane.showMessageDialog(null, record.getUserName() + " has the following record: \n" + record.toString());
			}
		}

		if(evt.getSource() == btnBack) {

		}

	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1000, 700);
		f.setResizable(false);

		HighscorePanel gui = new HighscorePanel();

		f.add(gui);

		f.setVisible(true);

	}

}
