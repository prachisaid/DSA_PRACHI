package DynamicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    private int helper(int ind, int[] dp) {
        if(ind == 0) return 1;
        if(ind == 1) return 1;

        if(dp[ind] != -1) return dp[ind];
        int l = helper(ind - 1, dp);
        int r = helper(ind - 2, dp);

        dp[ind] = l + r;
        return dp[ind];
    }

    private int tabulation(int ind, int[] dp) {
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= ind; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[ind];
    }
}
