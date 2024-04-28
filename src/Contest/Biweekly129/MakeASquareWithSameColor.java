package Contest.Biweekly129;

public class MakeASquareWithSameColor {
	public static void main(String[] args) {

	}

	public boolean canMakeSquare(char[][] grid) {
		int black = 0;
		int white = 0;

		int[] delRow = {0, 0, 1, 1};
		int[] delCol = {0, 1, 1, 0};

		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				black = 0;
				white = 0;

				for(int steps = 0; steps < 4; steps++) {
					int nrow = i + delRow[steps];
					int ncol = j + delCol[steps];

					if(grid[nrow][ncol] == 'B') {
						black += 1;
					}
					else {
						white += 1;
					}
				}

				if(black >= 3 || white >= 3) return true;
			}
		}

		return false;
	}
}
