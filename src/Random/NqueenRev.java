package Random;

public class NqueenRev {
	public static void main(String[] args) {
		NqueenRev obj = new NqueenRev();
//		obj.backtracking(4);
		obj.branchNBound(4);
	}

	public void backtracking(int n) {
		boolean[][] board = new boolean[n][n];
		int ans = queensB(board, 0);
	}

	public void branchNBound(int n) {
		boolean[][] board = new boolean[n][n];
		boolean[] colCheck = new boolean[n];
		boolean[] leftDiagonal = new boolean[n * 2 - 1];
		boolean[] rightDiagonal = new boolean[n * 2 - 1];

		int ans = queenBNB(board, 0, colCheck, leftDiagonal, rightDiagonal);
	}

	private int queenBNB(boolean[][] board, int row, boolean[] colCheck, boolean[] leftDiagonal, boolean[] rightDiagonal) {
		if(row == board.length) {
			display(board);
			return 1;
		}

		int count = 0;

		for(int col = 0; col < board[row].length; col++) {
			if(!colCheck[col] && !leftDiagonal[row + col] && !rightDiagonal[row - col + board.length - 1]) {
				board[row][col] = true;
				colCheck[col] = true;
				leftDiagonal[row + col] = true;
				rightDiagonal[row - col + board.length - 1] = true;

				count += queenBNB(board, row + 1, colCheck, leftDiagonal, rightDiagonal);

				board[row][col] = false;
				colCheck[col] = false;
				leftDiagonal[row + col] = false;
				rightDiagonal[row - col + board.length - 1] = false;
			}
		}

		return count;
	}

	private int queensB(boolean[][] board, int row) {
		if(row == board.length) {
			display(board);
			return 1;
		}

		int count = 0;

		for(int col = 0; col < board[row].length; col++) {
			if(isSafe(board, row, col)) {
				board[row][col] = true;
				count += queensB(board, row + 1);
				board[row][col] = false;
			}
		}

		return count;
	}

	private boolean isSafe(boolean[][] board, int row, int col) {
		for(int i = 0; i < row; i++) {
			if(board[i][col]) {
				return false;
			}
		}

		int shiftLeft = Math.min(row, col);
		for(int i = 1; i <= shiftLeft; i++) {
			if(board[row - i][col - i]) {
				return false;
			}
		}

		int shiftRight = Math.min(row, board.length - col - 1);
		for(int i = 1; i <= shiftRight; i++) {
			if(board[row - i][col + i]) {
				return false;
			}
		}

		return true;
	}

	private void display(boolean[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j]) {
					System.out.print("Q ");
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}

		System.out.println();
	}
}
