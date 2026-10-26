package practice;

public class Practice {

	public static void main(String[] args) {
		
		int[][] matrix = {{0,0,1,1,1,1,1},
						  {0,0,0,0,0,1,0},
						  {0,0,0,0,1,0,0},
						  {0,0,0,1,1,0,0},
						  {0,0,1,0,1,0,0},
						  {0,0,0,0,1,0,0},
						  {0,0,0,0,1,0,0},};
		
		int row;
		int col;
		int target = 5; 
		int countRow = 0;
		int sequence = 0;
		int countCol = 0;
		int countD = 0;
		
		int i;
		
		
		//Count row 
		for(row = 0; row < matrix.length; row++) {
			for(col=0; col <  matrix[row].length; col++) {
				if (matrix[row][col]== 1) {
					countRow++;
					if(countRow == target) {
						sequence++;
					}
				}else {
					countRow = 0;
				}	
			}	
		}
		
		
		//count diagonal
		
		
		

		//count col
		for (col = 0; col < matrix.length; col++) {
			for (row = 0; row < matrix[col].length; row++) {
				if(matrix[row][col]==1) {
					countCol++;
					if(countCol == target) {
						sequence++;
					}
				}else {
					countCol = 0;
				}
			}
		}
		
		
		System.out.print(sequence);
		
		

	}

}
