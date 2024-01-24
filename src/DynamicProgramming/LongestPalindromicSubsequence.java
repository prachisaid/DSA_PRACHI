package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "bbabcbcab";
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        System.out.println(obj.longestPalindromeSubseq(str));
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        String rev = str.reverse().toString();

        //return recursive(s.length(), s.length(), s, rev);
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for(int[] temp : dp) Arrays.fill(temp, -1);

        return memoization(s.length(), s.length(), s, rev, dp);
    }

    private int recursive(int i, int j, String str1, String str2) {
        if(i == 0 || j == 0) return 0;
        if(str1.charAt(i - 1) == str2.charAt(j - 1)) return 1 + recursive(i - 1, j - 1, str1, str2);
        return Math.max(recursive(i - 1, j , str1, str2), recursive(i, j - 1, str1, str2));
    }

    private int memoization(int i, int j, String str1, String str2, int[][] dp) {
        if(i == 0 || j == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i - 1) == str2.charAt(j - 1)) return dp[i][j] = 1 + memoization(i - 1, j - 1, str1, str2, dp);
        return dp[i][j] = Math.max(memoization(i - 1, j, str1, str2, dp), memoization(i, j - 1, str1, str2, dp));
    }
}
