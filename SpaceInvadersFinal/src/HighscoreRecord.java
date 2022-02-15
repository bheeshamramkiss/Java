/**
 * @author Mansi Thind
 * @date May 25
 * @description: Class for a highscore record
 *
 */
public class HighscoreRecord {

	//instance variables
	private String userName, time;
	private int score;
	
	public HighscoreRecord() {
		this.userName = "";
		this.score = 0;
		this.time = "";
	}
	
	//setters and getters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void processRecord(String record) {
		String word[] = record.split(", ");
		this.setUserName(word[0]);
		this.setScore(Integer.parseInt(word[1]));
		this.setTime(word[2]);
	}
	
	//toString method for self Testing
	public String toString() {
		return "UserName: " + getUserName() + "\nScore: " + getScore() + "\nTime: " + getTime();
	} 
	
	//toString method for GUI
	public String toDisplayString() {
		return getUserName() + "\t" + getScore() + "\t" + getTime();
	}
	
	public static void main(String[] args) {
		String record = "Mansi, 200, 1:15";
		
		HighscoreRecord h1 = new HighscoreRecord();
		
		h1.processRecord(record);
		
		System.out.println(h1.toString());
		
		System.out.println(h1.toDisplayString());

	}

}
