package myGame;

	public class Board {
		int rows = 8;
		int cols = 8;
		private String [][] matrix;

		public Board () {
			
		matrix = new String [this.rows][this.cols];
		
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = "| o";
				}
			}
		}

		

		public void setMatrix (int row, int col ) {
			matrix [row][col] = "| X";
		}
		public void setCScore (int row, int col ) {
			matrix [row][col] = "| C";
		}

		public String getMatrix (int row, int col) {
			return this.matrix[row][col];
		}

		public void show(int currentTurn, int totalRounds, int score, int computerScore, int playerLastScore, 
																						int computerLastScore, HighScore best) {
			int num = 0;
			
			System.out.println(" **************************************");
			System.out.println(" - V E C T O R S");
			System.out.println(" **************************************");
			System.out.printf(" - High Score: %s - %d\n", best.getName(), best.getScore());
			System.out.println(" **************************************");
			System.out.printf(" - Player Score:   %d Last Round: %d\n - Computer Score: %d Last Round: %d\n", 
										score, playerLastScore, computerScore, computerLastScore);
			System.out.println(" **************************************");
			System.out.printf(" -Turn %d of %d \n", currentTurn, totalRounds);
			System.out.println("   0   1   2   3   4   5   6   7");
			System.out.println(" ---------------------------------");
			
			for (int rows = 0 ; rows < this.matrix.length; rows++) {
				for (int cols = 0; cols < this.matrix[rows].length; cols++){

					System.out.printf(" %s", this.matrix[rows][cols]);
				}
				System.out.print(" |");
				System.out.println(" " + num++);
				System.out.println(" ---------------------------------");
			}

		}
		public int scoreHorizontal(String token) {
			int total = 0;
			int end;
			
			for (int row = 0; row < matrix.length; row++) {
				end =0;
				for (int col = 0; col < matrix[row].length; col++) {
					if (matrix[row][col].equals(token)) {
						end ++;
						if (end == 5) {
							total+=points(end);
							end = 0;
						}
					}else {
						total+= points(end);
						end =0;
					}
				}
				total+=points(end);
			}
			return total;
		}
		public int scoreVertical(String token) {
			int total = 0;
			int end;
			
			for (int col = 0; col < matrix[0].length; col++) {
				end =0;
				for (int row = 0; row < matrix.length; row++) {
					if (matrix[row][col].equals(token)) {
						end ++;
						if (end == 5) {
							total+=points(end);
							end = 0;
						}
					}else {
						total+= points(end);
						end =0;
					}
				}
				total+=points(end);
			}
			return total;
		}
		public int scoreDiagonal(String token) {
			int total =0;
			int size = matrix.length;
			for (int col = 0; col <size; col++) {
				String[]line = new String[size-col];
				for (int row = 0; row < line.length; row++) {
					line[row] = matrix[row][row+col];
				}
				total+=scoreLine(line, token);
			}
			for(int row = 1; row < size; row++) {
				String[]line = new String[size-row];
				for(int col = 0; col < line.length; col++) {
					line[col] = matrix[col][col+row];
				}
				total+=scoreLine(line, token);
			}
			for (int col = 0; col <size; col++) {
				String[]line = new String[col+1];
				for (int row = 0; row < line.length; row++) {
					line[row] = matrix[row][col-row];
				}
				total+=scoreLine(line, token);
			}
			for(int row = 1; row < size; row++) {
				String[]line = new String[size-row];
				for(int col = 0; col < line.length; col++) {
					line[col] = matrix[row+col][size-1-col];
				}
				total+=scoreLine(line, token);
			}
			return total;
		}
		public int points(int count) {
			if (count ==3 ) return 4;
			if (count ==4 ) return 6;
			if (count ==5 ) return 10;
			return 0;
		}
		public int scoreLine(String[]line, String token) {
			int total = 0;
			int end = 0;
			for (int i =0; i < line.length; i++) {
				if(line[i].equals(token)) {
					end++;
					if(end==5) {
						total+=points(end);
						end=0;
					}
				}else {
					total+=points(end);
					end =0;
				}
			}
			total+=points(end);
			return total;
			
		}
	
	
}
