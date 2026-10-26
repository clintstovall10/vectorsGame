package myGame;

import java.util.Scanner;

	public class Game {
		Player player;
		Board board;
		Computer computer;
		int score;
		int rounds;


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

	public void startGame() {


	}

	public void endGame() {


	}

	public void getInput() {
		Scanner scan = new Scanner(System.in);
		String userInput = scan.nextLine();
		String [] split = userInput.split(",") ;
		int row = Integer.parseInt(split[0]);
		int col = Integer.parseInt(split[1]);

		while((row < 0 || col < 0 ) || (row > 7 || col > 7 )) {

			System.out.println("this is not a valid move");
			userInput = scan.nextLine();

		}
		if (this.board.getMatrix(row, col) == "| o |") {
			
			this.board.setMatrix(row, col);
			System.out.println("this is a valid move");

		}else {

			System.out.println("this is not a valid move");

		}

	}

	public void showBoard() {

		this.board.show();

	}
	
}
	
	
	
	

