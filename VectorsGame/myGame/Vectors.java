package myGame;

public class Vectors {
	
	public static void main(String[] args) {

		Game game = new Game(20, "Clint");
		while ( game.getCurrentTurn() < game.getRounds()) {
			game.getInput();
			game.scoreRound();
			game.getNextTurn();
			game.showBoard();
		}
		


	}

}











