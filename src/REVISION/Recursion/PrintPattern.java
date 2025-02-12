package REVISION.Recursion;

public class PrintPattern {
	public static void main(String[] args) {
		func(4, 1);
	}

	private static void func(int row, int col) {
		if(row == 0) return;

		if(col <= row) {
			func(row, col + 1);
			System.out.print("* ");
		}
		else {
			func(row - 1, 1);
			System.out.println();
		}
	}
}
