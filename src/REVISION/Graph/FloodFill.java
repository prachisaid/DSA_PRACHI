package REVISION.Graph;

import java.util.*;

public class FloodFill {
	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		int[][] image = {
			{1, 1, 1},
			{2, 2, 0},
			{2, 2, 2}
		};

		int[][] ans = floodFill(image, 2, 0, 3);
		for(int[] temp : ans) {
			System.out.println(Arrays.toString(temp));
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(sr, sc));

		int initial = image[sr][sc];
		int n = image.length;
		int m = image[0].length;
		image[sr][sc] = color;

		while(!q.isEmpty()) {
			int row = q.peek().row;
			int col = q.peek().col;
			q.poll();

			int[] delRow = {-1, 0, 1, 0};
			int[] delCol = {0, 1, 0, -1};

			for(int i = 0; i < 4; i++) {
				int nrow = row + delRow[i];
				int ncol = col + delCol[i];

				if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initial) {
					image[nrow][ncol] = color;
					q.add(new Pair(nrow, ncol));
				}
			}
		}

		return image;
	}
}
