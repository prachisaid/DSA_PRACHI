package REVISION.Recursion;

public class NTo1 {
	public static void main(String[] args) {
		func(5);
	}

	private static void func(int n) {
		if(n == 0) return;

		System.out.println(n);

		func(n - 1);
	}
}
