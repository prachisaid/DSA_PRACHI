package DynamicProgramming;

import java.util.Arrays;

public class DistinctSubsequence {
    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        DistinctSubsequence obj = new DistinctSubsequence();
        System.out.println(obj.numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

//        return recursive(n, m, s, t);

        int[][] dp = new int[n + 1][m + 1];
        for(int[] temp : dp) Arrays.fill(temp, -1);

        return memoization(n, m, s, t, dp);
    }

    private static int recursive(int i, int j, String s, String t) {
        if(j == 0) return 1;
        if(i == 0) return 0;

        if(s.charAt(i - 1) == t.charAt(j - 1)) return recursive(i - 1, j - 1, s, t) + recursive(i - 1, j, s, t);
        return recursive(i - 1, j, s, t);
    }

    private static int memoization(int i, int j, String s, String t, int[][] dp) {
        if(j == 0) return 1;
        if(i == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i - 1) == t.charAt(j - 1))
            return dp[i][j] = memoization(i - 1, j - 1, s, t, dp) + memoization(i - 1, j, s, t, dp);

        return dp[i][j] = memoization(i - 1, j, s, t, dp);
    }
}
