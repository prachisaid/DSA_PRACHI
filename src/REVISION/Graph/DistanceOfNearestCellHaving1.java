package REVISION.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {
	static class Pair {
		int row;
		int col;
		int dist;

		Pair(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	public static void main(String[] args) {
		int[][] mat = {
			{0, 0, 0},
			{0, 1, 0},
			{1, 1, 1}
		};

		int[][] ans = (updateMatrix(mat));

		for(int[] arr : ans) {
			System.out.println(Arrays.toString(arr));
		}
	}

	public static int[][] updateMatrix(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;

		int[][] visited = new int[n][m];
		int[][] dist = new int[n][m];
		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 0) {
					q.add(new Pair(i, j, 0));
					visited[i][j] = 1;
				}
			}
		}

		int[] delRow = {-1, 0, 1, 0};
		int[] delCol = {0, 1, 0, -1};

		while (!q.isEmpty()) {
			int row = q.peek().row;
			int col = q.peek().col;
			int distance = q.peek().dist;
			q.poll();

			dist[row][col] = distance;

			for (int i = 0; i < 4; i++) {
				int nrow = row + delRow[i];
				int ncol = col + delCol[i];

				if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && mat[nrow][ncol] == 1 && visited[nrow][ncol] == 0) {
					visited[nrow][ncol] = 1;
					q.add(new Pair(nrow, ncol, distance + 1));
				}
			}
		}

		return dist;
	}
}
