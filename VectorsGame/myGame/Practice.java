package myGame;

public class Practice {
	
		public static void main(String[] args) {
			
			int[][] matrix = {{0,1,1,1,1,1,0},{0,0,1,1,1,1,1},{1,1,0,1,1,0,0},{1,1,1,1,1,0,0}};
			
			int row;
			int col;
			int target = 5; 
			int count = 0;
			int sequence = 0;
			int diagonal = 0;
			
			//Count row 
			for(row = 0; row < matrix.length; row++) {
				for(col=0; col <  matrix[row].length; col++) {
					if (matrix[row][col]== 1) {
						count++;
						if(count == target) {
							sequence++;
						}
					}else {
						count = 0;
					}	
				}	
			}
			//count diagonal
			for(row = 0; row < matrix.length; row++) {
				for(col=0; col <  matrix[row].length; col++) {
					if (matrix[row][col] == 1) {
						
					}
				}
			}
			
			
			System.out.print(sequence);
			
		}

}


