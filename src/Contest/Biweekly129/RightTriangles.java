package Contest.Biweekly129;

public class RightTriangles {
	public static void main(String[] args) {

	}

	public long numberOfRightTriangles(int[][] grid) {
		long ans = 0;

		int[] rowCount = new int[grid.length];
		int[] colCount = new int[grid[0].length];

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				rowCount[i] += grid[i][j];
				colCount[j] += grid[i][j];
			}
		}

		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 1) {
					ans += (long) (rowCount[i] - 1) * (colCount[j] - 1);
				}
			}
		}

		return ans;
	}
}
