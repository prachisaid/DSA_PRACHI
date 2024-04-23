package REVISION.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	static class Pair{
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		char[][] ch = {
			{'0', '1', '1', '0'},
			{'0', '1', '1', '0'},
			{'0', '0', '0', '0'},
			{'1', '1', '1', '1'},
		};

		System.out.println(numIslands(ch));
	}

	public static int numIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		int[][] visited = new int[n][m];
		int cnt = 0;

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1' && visited[i][j] == 0) {
					bfs(grid, visited, i, j);
					cnt += 1;
				}
			}
		}


		return cnt;
	}

	private static void bfs(char[][] grid, int[][] visited, int row, int col) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(row, col));
		visited[row][col] = 1;

		while(!q.isEmpty()) {
			int curRow = q.peek().row;
			int curCol = q.peek().col;
			q.poll();

			int[] delRow = {-1, 0, 1, 0};
			int[] delCol = {0, 1, 0, -1};

			for(int i = 0; i < 4; i++) {
				int nrow = curRow + delRow[i];
				int ncol = curCol + delCol[i];

				if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[curRow].length && visited[nrow][ncol] == 0 &&
					grid[nrow][ncol] == '1') {
					q.add(new Pair(nrow, ncol));
					visited[nrow][ncol] = 1;
				}
			}
		}
	}
}
