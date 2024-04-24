package REVISION.Graph;

import java.util.*;

public class NumberOfEnclaves {
	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {

	}

	public int numEnclaves(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int[][] visited = new int[n][m];
		Queue<Pair> q = new LinkedList<>();

		// check for boundary rows
		for(int i = 0; i < m; i++) {
			if(grid[0][i] == 1 && visited[0][i] == 0) {
				q.add(new Pair(0, i));
				visited[0][i] = 1;
			}

			if(grid[n - 1][i] == 1 && visited[n - 1][i] == 0) {
				q.add(new Pair(n - 1, i));
				visited[n - 1][i] = 1;
			}
		}

		// check for boundary columns
		for(int i = 0; i < n; i++) {
			if(grid[i][0] == 1 && visited[i][0] == 0) {
				q.add(new Pair(i, 0));
				visited[i][0] = 1;
			}

			if(grid[i][m - 1] == 1 && visited[i][m - 1] == 0) {
				q.add(new Pair(i, m - 1));
				visited[i][m - 1] = 1;
			}
		}

		int[] delRow = {-1, 0, 1, 0};
		int[] delCol = {0, 1, 0, -1};

		// bfs traversal
		while(!q.isEmpty()) {
			int row = q.peek().row;
			int col = q.peek().col;
			q.poll();

			for(int i = 0; i < 4; i++) {
				int nrow = row + delRow[i];
				int ncol = col + delCol[i];

				if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
					q.add(new Pair(nrow, ncol));
					visited[nrow][ncol] = 1;
				}
			}
		}

		// count ans
		int ans = 0;


		for(int i = 1; i < n - 1; i++) {
			for(int j = 1; j < m - 1; j++) {
				if(grid[i][j] == 1 && visited[i][j] == 0) {
					ans += 1;
				}
			}
		}

		return ans;
	}
}
