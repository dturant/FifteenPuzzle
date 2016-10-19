import java.util.Arrays;

public class Puzzle {
	public int rows, cols;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(board);
		result = prime * result + cols;
		result = prime * result + Arrays.hashCode(empty);
		result = prime * result + rows;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			System.out.println("if 1");
			return true;
		}
		if (obj == null){
			System.out.println("if 2");
			return false;
		}
		if (getClass() != obj.getClass()){
			System.out.println("if 3");
			return false;
		}
		Puzzle other = (Puzzle) obj;
		if (!Arrays.deepEquals(board, other.board)){
			//System.out.println("if 4");
			return false;
		}
		if (cols != other.cols){
			System.out.println("if 5");
			return false;
		}
		/*if (!Arrays.equals(empty, other.empty)){
			System.out.println("if 6");
			return false;
		}*/
		if (rows != other.rows){
			System.out.println("if 7");
			return false;
		}
		return true;
	}


	public int[][] board;
	public int[] empty;
	
	public Puzzle(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.board = new int[rows][cols];
		this.empty = new int[]{rows-1,cols-1};
		
	}
	
	public Puzzle clone(int rows, int cols) {
		Puzzle newNode = new Puzzle(rows,cols);
		for (int i = 0 ; i < rows ; ++i) {
			for (int j = 0 ; j < cols ; ++j) {
				newNode.board[i][j] = board[i][j];
			}
		}
		newNode.empty[0] = empty[0];
		newNode.empty[1] = empty[1];

		return newNode;
	}

	
	public boolean step(int direction){
		boolean result=false;
		switch(direction){
		  case 1:
		    //up
			  if(empty[0]>0){
				  int temp = board[empty[0]][empty[1]];
				  board[empty[0]][empty[1]] = board[empty[0]-1][empty[1]];
				  board[empty[0]-1][empty[1]] = temp;
					
				  empty[0]=empty[0]-1;
				  
				  result = true;
			  }
			  
		    break;
		  case 2:
		    //right
			  if(empty[1]<cols-1){
				  int temp = board[empty[0]][empty[1]];
				  board[empty[0]][empty[1]] = board[empty[0]][empty[1]+1];
				  board[empty[0]][empty[1]+1] = temp;
					
				 empty[1]=empty[1]+1;
				  
				  result = true;
			  }
			  
		    break;
		  case 3:
			//down
			  if(empty[0]<rows-1){
				  int temp = board[empty[0]][empty[1]];
				  board[empty[0]][empty[1]] = board[empty[0]+1][empty[1]];
				  board[empty[0]+1][empty[1]] = temp;
					
				  empty[0]=empty[0]+1;
				  
				  result = true;
			  }
			break;
		  case 4:
			//left
			  if(empty[1]>0){
				  int temp = board[empty[0]][empty[1]];
				  board[empty[0]][empty[1]] = board[empty[0]][empty[1]-1];
				  board[empty[0]][empty[1]-1] = temp;
					
				  empty[1]=empty[1]-1;
				  
				  result = true;
			  }
			    break;
		  default:
			  result = false;
		}
		//System.out.println(result);
		return result;
	}
}
