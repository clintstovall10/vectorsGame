package myGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

	public class Game {
		Player player;
		Board board;
		Computer computer;
		int score;
		int rounds;
		int currentTurn = 0;
		HighScore[]highscore;
		HighScore best;


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
		this.computer = new Computer();
	}

	public void getInput() {
		Random rand = new Random();
		boolean running = false;
		Scanner scan = new Scanner(System.in);
		boolean computerRunning = false;
		
		while(!running) {
			System.out.printf("Player(%s) Turn: %d (Row Col): ", this.player.getName(), 
																 this.currentTurn);
			String userInput = scan.nextLine();
			String [] split = userInput.split(" ") ;
			int row = Integer.parseInt(split[0]);
			int col = Integer.parseInt(split[1]);
			
			if (row >= 0 && row <= 7 && col>=0 && col<=7 && 
					this.board.getMatrix(row, col).equals("| o")) {
				this.board.setMatrix(row, col);
				running = true;
			}
			
		}
		while(!computerRunning) {
			int row = rand.nextInt(8);
			int col = rand.nextInt(8);
			if (this.board.getMatrix(row, col).equals("| o")) {
				this.board.setCScore(row, col);
				computerRunning = true;
			}
		
		}
	}

	public void showBoard() {

		this.board.show(this.currentTurn, this.rounds, this.player.getScore(), this.computer.getScore()
						, this.player.getLastScore(), this.computer.getLastScore(), this.best);

	}
	public void scoreRound() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("HighScore.txt", true));
		player.setLastScore(player.getScore());
		computer.setLastScore(computer.getScore());
		player.resetScore();
		computer.resetScore();
		player.addRound(board.scoreHorizontal("| X"));
		player.addRound(board.scoreVertical("| X"));
		player.addRound(board.scoreDiagonal ("| X"));
		computer.addRound(board.scoreHorizontal("| C"));
		computer.addRound(board.scoreVertical("| C"));
		computer.addRound(board.scoreDiagonal ("| C"));
		bw.write("" + player.getScore() + "," + player.getName());
		bw.newLine();
		bw.write("" + computer.getScore() + "," + computer.getName());
		bw.newLine();
		bw.close();
		sortHighScore();
	}
	public void sortHighScore() throws IOException {
		BufferedReader br = new BufferedReader( new FileReader("HighScore.txt"));
		int count = 0;
		
		while(br.readLine()!= null) {
			count++;
		}
		br.close();
		if(count == 0) {
			this.best = new HighScore(0, "None");
			return;
		}
		this.highscore = new HighScore[count];
		br = new BufferedReader( new FileReader("HighScore.txt"));
		for (int i = 0; i < count; i++) {
			String line = br.readLine();
			String[]arr = line.split(",");
			int score = Integer.parseInt(arr[0]);
			String name = arr[1];
			highscore[i] = new HighScore(score , name);
		}
		
		int max = 0;
		
		for (int j =1; j < count; j++) {
			if (highscore[j].getScore()> highscore[max].getScore()) {
				max = j;
			}
		}
		this.best = highscore[max];
		br.close();
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
	
	
	
	

