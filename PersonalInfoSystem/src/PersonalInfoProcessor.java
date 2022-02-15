/**
 * 
 */

/**
 * @author manoj
 * @date February 14, 2019
 */
public class PersonalInfoProcessor {

	public static String processInformation(String myString) {
		String fName = null;	// variables for first and last name
		String lName = null;	// age and gender
		int age = 0;
		char gender = 0;

		// split input string into data
		String words[] = myString.split(" ");  // this splits the string from the file		
		// at every space (from the " " in the bracket)

		for (int i = 0; i < words.length; i++) {
			switch (i) {
			case 0:{
				fName = words[0];
				break;
			}
			case 1:{
				lName = words[1];
				break;
			}
			case 2:{
				age = Integer.parseInt(words[2]);
				break;
			}
			case 3:{
				gender = words[3].charAt(0);
			}
			} // ends switch
		} // ends for

		//call method to convert gender to string
		String genderType = convertGender(gender);

		String formattedInfo = "Name:\t"
				+ lName.concat(", ").concat(fName).concat("\n")
				+ "Age:\t" + age + "\n"
				+ "Gender:\t".concat(genderType);

		return formattedInfo;

	} // processInformation ends

	/**
	 * Converts the char letters and matches them to their corresponding genders
	 * @param gender
	 * @return
	 */

	public static String convertGender (char gender) {
		String genderStr = null;

		// convert char into a string
		switch(gender) {
		case 'm':{
			genderStr = "Male";
			break;
		}
		case 'f':{
			genderStr = "Female";
			break;
		}
		default:{
			genderStr = "Other";
		}
		} // ends switch

		return genderStr;

	} // ends convertGender

	/**
	 * Self testing main method
	 * @param args
	 */
	public static void main(String[] args) {
		String input [] = new String [3];
		String output [] = new String [3];
		
		input [0] = "Darth Vader 50 m";
		input [1] = "Princess Lea 25 f";
		input [2] = "C3P0 Robot 250 r";
		
		for (int i = 0; i < input.length; i++) {
			output [i] = processInformation(input[i]);
			System.out.println(output[i]);
		} // ends for loop
		
	} // main

} // class
