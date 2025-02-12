package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class MazeWithAllPaths {
	public static void main(String[] args) {
		boolean[][] board = {
			{false, false, false},
			{false, false, false},
			{false, false, false}
		};

		System.out.println(func(0, 0, board, ""));
	}

	private static List<String> func(int row, int col, boolean[][] matrix, String path) {
		List<String> ans = new ArrayList<>();
		if(row == matrix.length - 1 && col == matrix[0].length - 1) {
			ans.add(path);
			return ans;
		}

		if(matrix[row][col]) return ans;
		matrix[row][col] = true;

		// Down
		if(row < matrix.length - 1) ans.addAll(func(row + 1, col, matrix, path + "D"));

		// Right
		if(col < matrix[0].length - 1) ans.addAll(func(row, col + 1, matrix, path + "R"));

		// Up
		if(row > 0) ans.addAll(func(row - 1, col, matrix, path + "U"));

		// Left
		if(col > 0) ans.addAll(func(row, col - 1, matrix, path + "L"));

		matrix[row][col] = false;

		return ans;
	}
}
