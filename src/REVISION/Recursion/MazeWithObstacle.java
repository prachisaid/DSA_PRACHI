package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class MazeWithObstacle {
	public static void main(String[] args) {
		boolean[][] board = {
			{false, false, false},
			{false, true, false},
			{false, false, false}
		};

		System.out.println(func(2, 2, board, ""));
	}

	private static List<String> func(int row, int col, boolean[][] board, String path) {
		List<String> ans = new ArrayList<>();
		if(row == 0 && col == 0) {
			ans.add(path);
			return ans;
		}

		if(board[row][col]) return ans;

		if(row > 0)
			ans.addAll(func(row - 1, col, board, path + "D"));
		if(col > 0)
			ans.addAll(func(row, col - 1, board, path + "R"));

		return ans;
	}
}
