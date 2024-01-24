package DynamicProgramming;

import java.util.Arrays;

public class MinimumInsertionsToMakeStringPal {
    public static void main(String[] args) {
        String a = "zzaazz";
        MinimumInsertionsToMakeStringPal obj = new MinimumInsertionsToMakeStringPal();
        System.out.println(obj.minInsertions(a));
    }

    public int minInsertions(String s) {
        StringBuilder str = new StringBuilder(s);
        String rev = str.reverse().toString();

        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for(int[] temp : dp) Arrays.fill(temp, -1);

        int lps = memoization(s.length(), s.length(), s, rev, dp);

        return (s.length() - lps);
    }

    private int memoization(int i, int j, String str1, String str2, int[][] dp) {
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i - 1) == str2.charAt(j - 1)) return dp[i][j] = 1 + memoization(i - 1, j - 1, str1, str2, dp);
        return dp[i][j] = Math.max(memoization(i - 1, j, str1, str2, dp), memoization(i, j - 1, str1, str2, dp));
    }
}

