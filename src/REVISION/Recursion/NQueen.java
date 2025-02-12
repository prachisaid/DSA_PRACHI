package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public static void main(String[] args) {
		List<List<String>> ans = new ArrayList<>();
		int[][] board = new int[4][4];
		func(0, board, ans);
		System.out.println(ans);
	}

	private static void func(int row, int[][] board, List<List<String>> lst){
		if(row == board.length) {
			display(board, lst);
			return;
		}

		for(int col = 0; col < board.length; col++) {
			if(isSafe(board, row, col)) {
				board[row][col] = 1;
				func(row + 1, board, lst);
				board[row][col] = 0;
			}
		}
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 1) return false;
		}

		int shiftLeft = Math.min(row, col);
		for(int i = 1; i <= shiftLeft; i++) {
			if(board[row - i][col - i] == 1) return false;
		}

		int shiftRight = Math.min(row, board.length - col - 1);
		for(int i = 1; i <= shiftRight; i++) {
			if(board[row - i][col + i] == 1) return false;
		}

		return true;
	}

	private static void display(int[][] board, List<List<String>> ans) {
		ans.add(new ArrayList<>());
		for(int[] b : board) {
			String s = "";
			for(int a : b) {
				if(a == 0	) s += ".";
				else s += "Q";
			}
			ans.get(ans.size() - 1).add(s);
		}
	}
}
