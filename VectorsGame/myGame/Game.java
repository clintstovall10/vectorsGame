package myGame;

import java.util.Scanner;

	public class Game {
		Player player;
		Board board;
		Computer computer;
		int score;
		int rounds;
		int currentTurn = 0;


	public Game() {
		this.rounds = 20;
		this.player = new Player();
		this.computer = new Computer();
		this.board = new Board();

	}

	public Game (int rounds , String name) {
		this.rounds = rounds;
		this.player = new Player(name);
		this.board = new Board();
	}

	public void getInput() {
		boolean running = false;
		Scanner scan = new Scanner(System.in);
		
		while(!running) {
			System.out.printf("Player(%s) Turn: %d (Row Col): ", this.player.getName(), 
																 this.currentTurn);
			String userInput = scan.nextLine();
			String [] split = userInput.split(" ") ;
			int row = Integer.parseInt(split[0]);
			int col = Integer.parseInt(split[1]);
			
			if (row >= 0&& row <= 7 && col>=0 && col<=7 && 
					this.board.getMatrix(row, col).equals("| o")) {
				this.board.setMatrix(row, col);
				running = true;
			}
			
		}
	}

	public void showBoard() {

		this.board.show(this.currentTurn, this.rounds, this.player.getScore());

	}
	public void scoreRound() {
		player.resetScore();
		player.addRound(board.scoreHorizontal("| X"));
		player.addRound(board.scoreVertical("| X"));
	}
	public int getRounds() {
		return this.rounds;
	}
	public void getNextTurn() {
		this.currentTurn++;
	}
	public int getCurrentTurn() {
		return this.currentTurn;
	}
	
}
	
	
	
	

