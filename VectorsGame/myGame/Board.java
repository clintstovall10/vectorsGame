package myGame;

	public class Board {
		int rows = 8;
		int cols = 8;
		private String [][] matrix;

		public Board () {
			
		matrix = new String [this.rows][this.cols];
		
			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = "| o |";
				}
			}
		}

		public void update() {


		}

		public void setMatrix (int row, int col ) {
			matrix [row][col] = "| X |";
		}

		public String getMatrix (int row, int col) {
			return this.matrix[row][col];
		}

		public void show() {

			for (int rows = 0 ; rows < this.matrix.length; rows++) {
				for (int cols = 0; cols < this.matrix[rows].length; cols++){

					System.out.print(this.matrix[rows][cols] + " ");
				}
				System.out.println();
			}

		}
	
	
}
