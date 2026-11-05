package myGame;

import java.io.IOException;
import java.util.Scanner;

public class Vectors {
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("=================================");
		System.out.println("=======WELCOME TO VECTORS!=======");
		System.out.println("=================================");
		System.out.println();
		System.out.println("How to play:");
		System.out.println("Enter your moves using two numbers and a space between each number:");
		System.out.println();
		System.out.println("ROW COL");
		System.out.println();
		System.out.println("EXAMPLE:");
		System.out.println("0 0");
		System.out.println();
		System.out.println("=================================");
		System.out.println();
		System.out.println("Please input name:");
		
		String name = scan.nextLine();
		
		System.out.println("Please number of rounds:");
		int rounds = scan.nextInt();
		
		Game game = new Game(rounds, name);
		while ( game.getCurrentTurn() < game.getRounds()) {
			game.getInput();
			game.scoreRound();
		//	game.sortHighScore();
			game.getNextTurn();
			game.showBoard();
		}
		


	}

}











