package myGame;

public class Computer {

		String name;
		int computerScore;
		int lastScore;

	public Computer() {
		this.name = "Dave";
	}
	public void resetScore() {
		this.computerScore = 0;
	}
	public void addRound(int points) {
		this.computerScore += points;
	}
	public int getScore() {
		return this.computerScore;
	}
	public void setLastScore(int x) {
		this.lastScore = x;
	}
	public int getLastScore() {
		return this.lastScore;
	}
	public String getName() {
		return this.name;
	}


}

