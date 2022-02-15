/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date March 5, 2019
 * Description: Class used to create one die of specified faces
 * Method List:
 * Die() - default constructor
 * void rollDie() - method to generate a random number based on value
 * int getValue() - getter method to read the value of the die roll
 * void main(String args[]) - self-testing main *
 */
public class Die {
	
	private int faces; // the attributes of Die
	private int value;
	

	/**
	 * Creates an instance of a die
	 */
	public Die() {
		this.faces = 6;
		rollDie();
	}
	
	/*
	 * Overloaded constructor 
	 */
	
	public Die(int faces) {
		this.faces = faces;
		rollDie();
	}
	
	/*
	 * Behaviours
	 * 	
	 */
	
	// rolls the die based on the number of faces and gives it a value
	public void rollDie () {
		this.value = (int)(Math.random() * this.faces + 1);
	} // rollDie
	
	// getter for value
	public int getValue() {
		return this.value;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// self testing
		
		//create a die object
		Die d1 = new Die();
		
		int d1Value = d1.getValue();
		System.out.println(d1Value);
		
		// create a second die
		Die d2 = new Die();
		int d2Value = d2.getValue();
		System.out.println(d2Value);
		
		// create a third die object, with 12 faces
		Die d3 = new Die (12);
		int die3Value = d3.getValue();
		System.out.println(die3Value);

	}

}
