import java.util.HashSet;
import java.util.Stack;

public class PuzzleSolver {

	static HashSet<Puzzle> visited;
	static int recursiveCalls=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		visited = new HashSet<Puzzle>();
		int rows = 3, cols = 3;
		Puzzle puzzle = new Puzzle(rows, cols);
		int num = rows * cols - 1;

		/*
		 * for(int i=0;i<rows;i++){ for(int j=0;j<cols;j++){ if(i==rows-1 &&
		 * j==cols-1){ puzzle.board[i][j]=0; } else{ puzzle.board[i][j]=num; }
		 * num--; } }
		 */

		/*
		 * puzzle.board[0][0] = 3; puzzle.board[0][1] = 1; puzzle.board[1][0] =
		 * 2; puzzle.board[1][1] = 0;
		 */

		puzzle.board[0][0] = 4;
		puzzle.board[0][1] = 1;
		puzzle.board[0][2] = 2;
		puzzle.board[1][0] = 7;
		puzzle.board[1][1] = 5;
		puzzle.board[1][2] = 3;
		puzzle.board[2][0] = 8;
		puzzle.board[2][1] = 6;
		puzzle.board[2][2] = 0;

		Puzzle solution = new Puzzle(rows, cols);
		num = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == rows - 1 && j == cols - 1) {
					solution.board[i][j] = 0;
				} else {
					solution.board[i][j] = num;
				}
				num++;
			}
		}

		// iterativeDFS(puzzle, solution, rows, cols);
		recursiveDFS(puzzle, solution, rows, cols);
	}

	static private void iterativeDFS(Puzzle puzzle, Puzzle solution, int rows, int cols) {

		Stack<Puzzle> stack = new Stack<Puzzle>();
		stack.push(puzzle);

		// visited.add(puzzle);
		int counter = 0;
		while (stack.size() > 0) {
			counter++;
			Puzzle currentNode = stack.pop();

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.print(currentNode.board[i][j]);
				}
				System.out.println();
			}
			System.out.println();

			if (currentNode.equals(solution)) {
				System.out.println("hurra");
				break;
			}

			for (int i = 1; i <= 4; ++i) {
				Puzzle moved = currentNode.clone(rows, cols);

				if (!moved.step(i)) // Illegal
				{
					// System.out.println(i + " illegal");
					// System.out.println();
					continue;
				}
				if (!visited.contains(moved)) {
					visited.add(moved);
					stack.push(moved);
				}

			}

		}
		System.out.println("ruchy: " + counter);

	}

	static private void recursiveDFS(Puzzle puzzle, Puzzle solution, int rows, int cols) {

		recursiveCalls++;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(puzzle.board[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		// System.out.println(visited.size());

		if (puzzle.equals(solution)) {
			System.out.println("hurra");
			System.out.println(recursiveCalls + " recursive calls");
			System.exit(1);
		}

		for (int i = 1; i <= 4; ++i) {
			Puzzle moved = puzzle.clone(rows, cols);

			if (!moved.step(i)) // Illegal
			{
				// System.out.println(i + " illegal");
				// System.out.println();
				continue;
			}
			if (!visited.contains(moved)) {
				visited.add(moved);
				recursiveDFS(moved, solution, rows, cols);
			}

		}
		

	}

}
