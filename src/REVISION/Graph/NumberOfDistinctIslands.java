package REVISION.Graph;

import java.util.*;

public class NumberOfDistinctIslands {
	public static void main(String[] args) {

	}

	int countDistinctIslands(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int[][] visited = new int[n][m];

		HashSet<ArrayList<String>> ans = new HashSet<>();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 1 && visited[i][j] == 0) {
					ArrayList<String> lst = new ArrayList<>();
					dfs(i, j, grid, visited, lst, i, j);
					ans.add(lst);
				}
			}
		}

		return ans.size();
	}

	void dfs(int row, int col, int[][] grid, int[][] visited, ArrayList<String> lst, int baseRow, int baseCol) {
		visited[row][col] = 1;
		String ans = Integer.toString(row - baseRow) + " " + Integer.toString(col - baseCol);
		lst.add(ans);

		int[] delRow = {-1, 0, 1, 0};
		int[] delCol = {0, 1, 0, -1};
		int n = grid.length;
		int m = grid[0].length;

		for(int i = 0; i < 4; i++) {
			int nrow = row + delRow[i];
			int ncol = col + delCol[i];

			if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
				dfs(nrow, ncol, grid, visited, lst, baseRow, baseCol);
			}
		}
	}
}
