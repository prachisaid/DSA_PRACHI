package REVISION.Recursion;

public class PrintPattern {
	public static void main(String[] args) {
		revPattern(4, 0);
	}

	public static void pattern(int row, int col) {
		if(row == 0) return;

		if(row > col) {
			System.out.print("* ");
			pattern(row, col + 1);
		}
		else {
			System.out.println();
			pattern(row - 1, 0);
		}
	}

	public static void revPattern(int row, int col) {
		if(row == 0) return;

		if(row > col) {
			revPattern(row, col + 1);
			System.out.print("* ");
		}
		else {
			revPattern(row - 1, 0);
			System.out.println();
		}
	}
}
