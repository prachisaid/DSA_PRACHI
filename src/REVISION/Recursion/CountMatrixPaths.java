package REVISION.Recursion;

public class CountMatrixPaths {
	public static void main(String[] args) {
		System.out.println(paths(2, 2));
	}

	public static int paths(int row, int col) {
		if(row == 0 && col == 0) {
			return 1;
		}

		int count = 0;
		if(row > 0) {
			count += paths(row - 1, col);
		}

		if(col > 0) {
			count += paths(row, col - 1);
		}

		return count;
	}
}
