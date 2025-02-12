package REVISION.Recursion;

public class CountPathInMaze {
	public static void main(String[] args) {
		System.out.println(func(3, 3));
	}

	private static int func(int row, int col) {
		if(row == 1 && col == 1) {
			return 1;
		}

		int count = 0;
		if(row > 1) count += func(row - 1, col);
		if(col > 1) count += func(row, col - 1);
		return count;
	}
}
