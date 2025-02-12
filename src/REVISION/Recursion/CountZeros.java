package REVISION.Recursion;

public class CountZeros {
	public static void main(String[] args) {
		System.out.println(count(309800, 0));
	}

	private static int count(int n, int cnt) {
		if(n%10 == n) {
			if(n == 0) return cnt + 1;
			return cnt;
		}

		int rem = n % 10;
		if(rem == 0) cnt++;
		return count(n/10, cnt);
	}
}
