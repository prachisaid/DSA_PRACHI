package REVISION.Recursion;

public class SumOfDigits {
	public static void main(String[] args) {
		System.out.println(sum(5431));
	}

	private static int sum(int n) {
		if(n % 10 == n) return n;

		int num = n % 10;
		n = n / 10;
		return num + sum(n);
	}
}
