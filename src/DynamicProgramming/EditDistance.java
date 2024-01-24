package DynamicProgramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String s = "horse";
        String t = "ros";

        EditDistance obj = new EditDistance();
        System.out.println(obj.minDistance(s, t));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // return recursive(n - 1, m - 1, word1, word2);
        int[][] dp = new int[n + 1][m + 1];
        for(int[] temp : dp) Arrays.fill(temp, 0);

        // return memoization(n, m, word1, word2, dp);
        // return tabulation(n, m, word1, word2, dp);
        return spaceOp(n, m, word1, word2);
    }

    private int recursive(int i, int j, String s, String t) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(s.charAt(i) == t.charAt(j)) return recursive(i - 1, j - 1, s, t);
        return Math.min(1 + recursive(i, j - 1, s, t), Math.min(1 + recursive(i - 1, j, s, t), 1 + recursive(i - 1, j - 1, s, t)));
    }

    private int memoization(int i, int j, String s, String t, int[][] dp) {
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i - 1) == t.charAt(j - 1)) return dp[i][j] = memoization(i-1, j-1, s, t, dp);
        return dp[i][j] = Math.min(1 + memoization(i, j-1, s, t, dp), Math.min(1 + memoization(i-1, j, s, t, dp), 1 + memoization(i-1, j-1, s, t, dp)));
    }

    private int tabulation(int n, int m, String s, String t, int[][] dp) {
        for(int i = 0; i <= n; i++) dp[i][0] = i;
        for(int j = 0; j <= m; j++) dp[0][j] = j;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.min(1 + dp[i - 1][j], Math.min(1 + dp[i][j - 1], 1 + dp[i - 1][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    private int spaceOp(int n, int m, String s, String t) {
        int[] prev = new int[m + 1];

        for(int j = 0; j <= m; j++) prev[j] = j;

        for(int i = 1; i <= n; i++) {
        int[] cur = new int[m + 1];
            cur[0] = i;
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                }
                else{
                    cur[j] = 1 + Math.min(prev[j], Math.min(cur[j - 1], prev[j - 1]));
                }
            }

            prev = cur;
        }

        return prev[m];
    }
}
