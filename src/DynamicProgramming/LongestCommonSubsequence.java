package DynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "acd";
        String text2 = "ced";

        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
//        return recursive(text1.length()-1, text2.length()-1, text1, text2);

        int ind1 = text1.length();
        int ind2 = text2.length();
        int[][] dp = new int[ind1 + 1][ind2 + 1];

        for(int[] temp : dp) Arrays.fill(temp, 0);
//        return memoization(ind1, ind2, text1, text2, dp);

//        return tabulation(ind1, ind2, text1, text2, dp);
        return spaceOp(ind1, ind2, text1, text2);
    }

    private static int recursive(int ind1, int ind2, String text1, String text2) {
        if(ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if(text1.charAt(ind1) == text2.charAt(ind2)) {
            return 1 + recursive(ind1 - 1, ind2 - 1, text1, text2);
        }

        return Math.max(recursive(ind1 - 1, ind2, text1, text2), recursive(ind1, ind2 - 1, text1, text2));
    }

    private static int memoization(int ind1, int ind2, String str1, String str2, int[][] dp) {
        if(ind1 == 0 || ind2 == 0) {
            return 0;
        }

        if(dp[ind1][ind2] != -1) return dp[ind1 - 1][ind2 - 1];

        if(str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)) {
            return dp[ind1][ind2] = 1 + memoization(ind1 - 1, ind2 - 1, str1, str2, dp);
        }

        return dp[ind1][ind2] = Math.max(memoization(ind1 - 1, ind2, str1, str2, dp) ,
                memoization(ind1, ind2 - 1, str1, str2, dp));
    }

    private static int tabulation(int n, int m, String str1, String str2, int[][] dp) {
        for(int i = 0; i <= n; i++) dp[0][i] = 0;
        for(int i = 0; i <= m; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[n][m];
    }

    private static int spaceOp(int n, int m, String str1, String str2) {
        int[] prev = new int[m + 1];

        for(int i = 0; i <= m; i++) prev[i] = 0;

        for(int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) cur[j] = 1 + prev[j - 1];
                else cur[j] = Math.max(cur[j - 1], prev[j]);
            }

            prev = cur;
        }

        return prev[m];
    }
}
