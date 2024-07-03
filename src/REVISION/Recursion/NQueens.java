package REVISION.Recursion;

public class NQueens {
	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		queens(board, 0);
	}

	public static void queens(boolean[][] board, int row) {
		if(row == board.length) {
			display(board);
			System.out.println();
			return;
		}

		for(int col = 0; col < board.length; col++) {
			if(isSafe(board, row, col)) {
				board[row][col] = true;
				queens(board, row + 1);
				board[row][col] = false;
			}
		}
	}

	private static boolean isSafe(boolean[][] board, int row, int col) {
		for(int i = 0; i < board.length; i++) {
			if(board[i][col]) return false;
		}

		int leftShift = Math.min(row, col);
		for(int i = 1; i <= leftShift; i++) {
			if(board[row - i][col - i]) return false;
		}

		int rightShift = Math.min(row, board.length - col - 1);
		for(int i = 1; i <= rightShift; i++) {
			if(board[row - i][col + i]) return false;
		}

		return true;
	}

	private static void display(boolean[][] board) {
		for(boolean[] row : board) {
			for(boolean val : row) {
				if(val) {
					System.out.print("Q ");
				}
				else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
}
