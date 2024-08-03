package Contest.Biweekly136;

public class MinimumFlipsToMakeBinaryGridPalindrome {
	public static void main(String[] args) {
		int[][] grid = {
			{1, 0, 0, 0},
			{0, 1, 0, 1}
		};

		System.out.println(minFlips(grid));
	}

	public static int minFlips(int[][] grid) {
		int rows = 0;
		for(int[] temp : grid) {
			int i = 0;
			int j = temp.length - 1;

			while(i < j) {
				if(temp[i] != temp[j]) {
					rows++;
				}

				i++;
				j--;
			}
		}

		int cols = 0;
		for(int ind = 0; ind < grid[0].length; ind++) {
			int i = 0;
			int j = grid.length - 1;

			while(i < j) {
				if(grid[i][ind] != grid[j][ind]) {
					cols++;
				}
				i++;
				j--;
			}
		}

		return Math.min(rows, cols);
	}
}
