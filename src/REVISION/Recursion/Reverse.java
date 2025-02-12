package REVISION.Recursion;

public class Reverse {
	public static void main(String[] args) {
		System.out.println(reverse(1245, 0));
	}

	private static int reverse(int n, int sum) {
		if(n%10 == n) {
			return (sum * 10) + n;
		}

		int rem = n % 10;
		sum = (sum * 10) + rem;
		return reverse(n/10, sum);
	}
}
