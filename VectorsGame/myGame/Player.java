package myGame;

public class Player {
	
	String name;
	int score;
		
	public Player() {
		this.name = "MegaMind";
		this.score = 0;

	}

	public Player(String name) {
		this.name = name;

		}
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}
	public void resetScore() {
		this.score = 0;
	}
	public void addRound(int points) {
		this.score += points;
	}

}
	
	

