import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import javax.imageio.*;

public class GamePanel extends JPanel implements KeyListener, ActionListener {

	// Private Instances
	private ImagePicture background;
	private Font font;
	private JLabel time, tCount;
	private JLabel lives, livesCount;
	private JLabel score, scoreCount;
	private TextPicture btnMenu;

	// JPanels
	private JPanel info;

	// Intro Variables
	private boolean introDone;
	private Timer introTimer;
	private int tI;

	// Player and Enemy Objects
	private Player player;
	private Enemy enemies[][];

	// Game Starter Variables
	private Timer enemyMove;
	private Timer enemyShoot;
	private int counter;
	private int move;
	private boolean canShoot;

	// Game mechanic Variables
	private int playerLives;
	private int playerScore;

	//time elapsed timer
	private Timer timeElapsed;
	private int timeCounter;
	private int min;
	private int seconds;

	public GamePanel() {

		// Setting Panel Size
		setBounds(0, 0, 1000, 700);
		setFocusable(true);
		addKeyListener(this);
		setLayout(null);

		// Setting the background Image
		try {
			background = new ImagePicture(new ImageIcon(ImageIO.read(getClass().getResource("Game Background.png"))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error with loading game background.");
		}
		background.setBounds(0, 0, 1000, 700);

		// Creating Custom Font
		CustomFontMaker.setFontSize(20f);
		font = (CustomFontMaker.getCustomFont());

		// Information Panel
		info = new JPanel();
		info.setBounds(850, 0, 150, 700);
		info.setBackground(Color.BLACK);
		info.setLayout(null);

		// Button to return to main menu
		CustomFontMaker.setFontSize(8f);
		font = (CustomFontMaker.getCustomFont());
		btnMenu = new TextPicture();
		btnMenu.setFont(font);
		btnMenu.setTitle("<-- Main Menu");
		btnMenu.setxPos(870);
		btnMenu.setyPos(650);
		btnMenu.setBounds(0, 0, 1000, 700);
		btnMenu.setColor(Color.RED);
		add(btnMenu);

		// reverting font size for other components
		CustomFontMaker.setFontSize(20f);
		font = (CustomFontMaker.getCustomFont());

		// Time  and tCount JLabel
		time = new JLabel("TIME");
		time.setFont(font);
		time.setForeground(Color.WHITE);
		time.setBounds(0, 0, 1000, 700);
		time.setSize(150, 50);
		time.setLocation(20, 0);

		tCount = new JLabel("");
		tCount.setFont(font);
		tCount.setForeground(Color.WHITE);
		tCount.setBounds(0, 0, 1000, 700);
		tCount.setSize(150, 50);
		tCount.setLocation(20, 50);

		// Lives and livesCount JLabel
		lives = new JLabel("LIVES");
		lives.setFont(font);
		lives.setForeground(Color.WHITE);
		lives.setBounds(0, 0, 1000, 700);
		lives.setSize(150, 50);
		lives.setLocation(10, 200);

		livesCount = new JLabel("3");
		livesCount.setFont(font);
		livesCount.setForeground(Color.WHITE);
		livesCount.setBounds(0, 0, 1000, 700);
		livesCount.setSize(150, 50);
		livesCount.setLocation(50, 250);

		// Score and scoreCount JLabel
		score = new JLabel("SCORE");
		score.setFont(font);
		score.setForeground(Color.WHITE);
		score.setBounds(0, 0, 1000, 700);
		score.setSize(150, 50);
		score.setLocation(10, 500);

		scoreCount = new JLabel("0");
		scoreCount.setFont(font);
		scoreCount.setForeground(Color.WHITE);
		scoreCount.setBounds(0, 0, 1000, 700);
		scoreCount.setSize(150, 50);
		scoreCount.setLocation(10, 550);

		// game time timer
		timeElapsed = new Timer (1000, this);
		timeElapsed.start();
		timeCounter = 110;
		min = 0;
		seconds = 0;

		// Boolean variable for dramatic intro
		introDone = false;
		// Timer for intro animation
		introTimer = new Timer (30, this);
		introTimer.start();
		tI = 0;

		// Creating Player
		try {
			player = new Player(new ImageIcon(ImageIO.read(getClass().getResource("Player Image.gif"))), 390, 740);
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error with loading player icon.");
		}
		player.setBounds(0, 0, 850, 700);

		int x = -150;
		int y = 0;

		// Creating Enemy rows
		enemies = new Enemy [2][10];
		for (int i = 0; i < enemies.length; i++) { // ROWS
			for (int j = 0; j < enemies[i].length; j++) {
				enemies[i][j] = new Enemy();
				enemies[i][j].setScale(5);
				enemies[i][j].setBounds(0, 0, 850, 700);
				enemies[i][j].setxPos(x);
				enemies[i][j].setyPos(y);
				enemies[i][j].setColor(Color.WHITE);
				add(enemies[i][j]);
				x -= 80;
			}
			x = -150;
			y += 100;
		}

		enemyMove = new Timer (20, this);
		enemyShoot = new Timer (1000, this);
		counter = 0;
		move = 1;
		canShoot = true;

		playerLives = 3;
		playerScore = 0;

		// Adding each component
		add(player);
		info.add(score);
		info.add(scoreCount);
		info.add(lives);
		info.add(livesCount);
		info.add(time);
		info.add(tCount);
		add(info);
		add(background);

		// Setting everything to visible
		setVisible(true);

		/*
		 * Mouse Listener that will change the screens as each appropriate button (which is in reality a TextPicture) is clicked
		 */
		addMouseListener(new MouseAdapter() {

			public void mouseClicked (MouseEvent e) {
				int x = e.getX();
				int y = e.getY();

				// menu
				if ((x >= 870) && (x <= 960) && (y >= 640) && (y <= 650)) {
					Frame.setState(Frame.getStartPan());
					Frame.update();
				}

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Sets up the game board
		if (e.getSource() == introTimer) {

			if (player.getyPos() != 540) {
				player.setyPos(player.getyPos() - 5);
			}
			else {

				if (enemies[tI][0].getxPos() != 750) {
					enemies[tI][0].setxPos(enemies[tI][0].getxPos() + 10);
					enemies[tI][1].setxPos(enemies[tI][1].getxPos() + 10);
					enemies[tI][2].setxPos(enemies[tI][2].getxPos() + 10);
					enemies[tI][3].setxPos(enemies[tI][3].getxPos() + 10);
					enemies[tI][4].setxPos(enemies[tI][4].getxPos() + 10);
					enemies[tI][5].setxPos(enemies[tI][5].getxPos() + 10);
					enemies[tI][6].setxPos(enemies[tI][6].getxPos() + 10);
					enemies[tI][7].setxPos(enemies[tI][7].getxPos() + 10);
					enemies[tI][8].setxPos(enemies[tI][8].getxPos() + 10);
					enemies[tI][9].setxPos(enemies[tI][9].getxPos() + 10);
				}

				else {
					if (tI == 1) {
						introDone = true;
						enemyMove.start();
						enemyShoot.start();
						introTimer.stop();
					}
					else {
						tI++;
					}
				}
			}
		}

		//when the timer increments
		if (e.getSource() == timeElapsed) {
			timeCounter++;

			min = (int) counter/60;
			seconds = counter % 60;

			tCount.setText(min + " : " + seconds);
		}

		// Moves the enemies left to right
		if (e.getSource() == enemyMove) {

			// Enemy movement
			for (int i = 0; i < enemies.length; i++) {
				for (int j = 0; j < enemies[i].length; j++) {
					enemies[i][j].setxPos(enemies[i][j].getxPos() + move);
				}
				move *= -1;
			}

			counter++;

			if(counter == 40) {
				move *= -1;
				counter = 0;
			}	

			// Collision check
			for (int i = 0; i < enemies.length; i++) {
				for (int j = 0; j < enemies[i].length; j++) {

					// If the enemies laser hits the player
					if (enemies[i][j].bounds().intersects(player.bounds(true))) {

						// Taking one away from the players life
						playerLives--;

						// if player has 0 lives left, cue the game over sequence
						if (playerLives == 0) {

							// setting live count to 0
							livesCount.setText("" + playerLives);

							// Removing the Laser
							enemies[i][j].setLaserX(-200);

							enemyMove.stop();
							enemyShoot.stop();
							introTimer.stop();
							removeAll();
							Frame.setState(Frame.getGameOverPan(scoreCount.getText(), tCount.getText()));
							Frame.update();
						}
						else {

							livesCount.setText("" + playerLives);

							// Removing the Laser
							enemies[i][j].setLaserX(-200);
						}
					}

					// If the Players' Laser hit the enemy
					if (player.bounds().intersects(enemies[i][j].bounds(true))) {

						// Removes and relocates enemy
						remove(enemies[i][j]);
						enemies[i][j].setxPos(-200);
						enemies[i][j].setyPos(-200);

						// Resetting shooting
						player.setLaserX(-200);
						player.setShoot(false);
						canShoot = true;

						playerScore += 10;
						scoreCount.setText("" + playerScore);

						// if the player reaches a score of 200 (all enemies destroyed) they win
						if (playerScore == 200){
							enemyMove.stop();
							enemyShoot.stop();
							introTimer.stop();
							Frame.setState(Frame.getWinPan(scoreCount.getText(), tCount.getText()));
							Frame.update();

						}
					}

					// Resetting the players shoot ability
					if (player.getLaserY() < -10) {
						player.setShoot(false);
						canShoot = true;
					}

				}
			}

		}

		// Enemy shoot timer
		if(e.getSource() == enemyShoot) {

			// Randomizes which enemy shoots
			int n1 = (int) (Math.random() * 1+1);
			int n2 = (int) (Math.random() * 9+1);

			// Shoots
			enemies[n1][n2].shoot();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (introDone) {
			// Pressing the left arrow key
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				player.setDX(-5);
			}

			// Pressing the right arrow key
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				player.setDX(5);
			}

			// Shooting method
			if (e.getKeyCode() == KeyEvent.VK_SPACE && canShoot) {
				player.shoot();
				canShoot = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		// Pressing the left arrow key
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setDX(0);
		}

		// Pressing the right arrow key
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setDX(0);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	// requesting focus in the window
	public void setup() {
		requestFocusInWindow();
	}



	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1000, 700);
		f.add(new GamePanel());
		f.setVisible(true);


	}

}
