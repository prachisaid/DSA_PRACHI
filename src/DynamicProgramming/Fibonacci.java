package DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(memoization(n, dp));
        System.out.println(tabulation(n));
        System.out.println(spaceOp(n));
    }

    public static int memoization(int n, int[] dp) {
        if(n <= 1) {
            return n;
        }

        if(dp[n] != -1) return dp[n];

        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);

        return dp[n];
    }

    public static int tabulation(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static int spaceOp(int n) {
        int prev = 1;
        int prev2 = 0;

        for(int i = 2; i <= n; i++) {
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}
