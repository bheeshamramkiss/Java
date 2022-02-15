import javax.swing.ImageIcon;

/**
 * 
 */

/**
 * @author manoj
 *
 */
public class SmartMinion extends ImagePicture {
	
	/*
	 * private variables to keep track of steps
	 */
	private int stepsToMove;

	/**
	 * 
	 */
	public SmartMinion(ImageIcon img) {
		super(img);		
	}

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getStepsToMove() {
		return stepsToMove;
	}

	public void setStepsToMove(int stepsToMove) {
		this.stepsToMove = stepsToMove;
	}

}
