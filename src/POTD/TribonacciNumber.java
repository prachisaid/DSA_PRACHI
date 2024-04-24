package POTD;

import java.util.Arrays;

public class TribonacciNumber {
	public static void main(String[] args) {
		TribonacciNumber obj = new TribonacciNumber();
		System.out.println(obj.tribonacci(4));
	}

	public int tribonacci(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);

		return recursive(n, dp);
	}

	private int recursive(int n, int[] dp) {
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;

		if(dp[n] != -1) return dp[n];

		dp[n] = recursive(n - 1, dp) + recursive(n - 2, dp) + recursive(n - 3, dp);

		return dp[n];
	}
}
