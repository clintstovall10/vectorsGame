package myGame;

public class HighScore {
	int score;
	String name;
	public HighScore () {
		this.score = 0;
		this.name = "Dave";
	}
	public HighScore(int score, String name) {
		this.score = score;
		this.name = name;
	}
	public int getScore() {
		return this.score;
	}
	public String getName() {
		return this.name;
	}
}
