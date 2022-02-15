import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author Bheesham Ramkissoon
 * @date February 22, 2019
 * Description: This class encrypts, decrypts, and also determines whether an input is a letter
 * Method List:
 * checkForLetter: takes in a char and returns the appropriate boolean result if it is indeed a letter
 * encode: takes a char, and if it is a letter, will encrypt it with the encryption key given
 * decode: takes an encrypted letter, and reverses the encryption
 */
public class Encrypter {

	//this method will sort through each character of each line of the given string array
	//and will pass each character for encryption.
	public static String encryptionPhrase (String fileInfo[], int encryptKey) {
		String output = "";
		char letterForEncryption;

		for (int i = 1; i < fileInfo.length; i++) {
			for (int k = 0; k < fileInfo[i].length(); k++) {
				letterForEncryption = fileInfo[i].charAt(k);
				output += encode(letterForEncryption, encryptKey);
			}

			output += "\n";

		}

		return output;

	} // ends the encryptionPhrase

	//this method will sort through each character of each line of the given string array
	//and will pass each character for decryption.
	public static String decryptionPhrase (String fileInfo[], int encryptKey) {
		String output = "";
		char letterForDecryption;

		for (int i = 1; i < fileInfo.length; i++) {
			for (int k = 0; k < fileInfo[i].length(); k++) {
				letterForDecryption = fileInfo[i].charAt(k);
				output += decode(letterForDecryption, encryptKey);
			}

			output += "\n";

		}

		return output;

	} // ends the encryptionPhrase

	//method to check whether the given character is a letter
	public static boolean checkForLetter (char character) {

		// Converting the char into ASCII so it can be compared
		int ascii = (int) character;

		if ((97 <= ascii) && (ascii <= 122) || (65 <= ascii) && (ascii <= 90)) {
			return true;
		} // true

		else {
			return false;
		} // else
	} // ends the check for letter method

	// method to encrypt a given letter into it's encrypted variant
	public static char encode (char letter, int encryptKey) {

		//when this class is called, it will check for if the letter it is given is a character or not.
		// that way, it will only encode letters and not spaces, punctuations, etc.
		if (checkForLetter(letter)) {
			// this modulus will take the encrypt key and decrease it's value to a maximum number of 26
			// such that it loops only once
			encryptKey = encryptKey % 26;

			//creating a range, so that whether the case is upper or lower, the code can loop around the 
			//appropriate case
			int beginRange = 0, endRange = 0;

			if (Character.isLowerCase(letter)){

				beginRange = 97;
				endRange = 122;

			} // ends inner if

			else {
				beginRange = 65;
				endRange = 90;
			} // ends else

			// preparing the char (letter) to be manipulated into a different letter and returning it
			int ascii = (int) letter;

			ascii = ascii + encryptKey + encryptKey + encryptKey;

			// these if statements check if the ascii value calculated is either greater than or lesser than
			// the lower or upper case ranges

			// greater than the limits of the alphabets
			if (ascii > endRange) {
				ascii = beginRange + (ascii - endRange);
			}

			// less than "a" and greater than "Z"
			else if((ascii < beginRange)){
				ascii = endRange + (ascii - beginRange); // since the number is already smaller than 97, subtracting 97
				// makes it negative, so adding the negative will result in
				// subtraction
			}

			letter = (char) ascii;

		} // ends the checking if statement

		return letter;

	} // ends the encode method

	public static char decode (char letter, int decryptKey) {
		decryptKey *= -1;

		letter = encode(letter, decryptKey);

		return letter;
	} // ends the decoding method

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//checking to see if the "isALetter" method works, by passing the "g" from Angad, and then a "9"
		String output = "";
		String word = "Angad";
		char check = word.charAt(2);
		boolean result = checkForLetter(check);
		JOptionPane.showMessageDialog(null, result);
		word = "34944";
		check = word.charAt(2);
		result = checkForLetter(check);
		JOptionPane.showMessageDialog(null, result);

		// checking the encode method to see if it works, by splitting each character of the word apart,
		// and then passing it to the encode method.
		word = "Ang ad!#82$";
		String [] array;
		array = word.split("");
		for (int j = 0; j < word.length(); j++) {
			array [j] = String.valueOf(encode(word.charAt(j), 454533));
			output += array[j];
		} // for loop ends here

		JOptionPane.showMessageDialog (null, output);
		output = "";

		word = "Dqj dg!#82$";
		array = word.split("");
		for (int j = 0; j < word.length(); j++) {
			array [j] = String.valueOf(decode(word.charAt(j), 454533));
			output += array[j];
		} // for loop ends here

		JOptionPane.showMessageDialog (null, output);

	} // main

} // class
