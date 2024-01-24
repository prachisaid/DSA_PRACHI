package DynamicProgramming;

import java.util.Arrays;

public class WildCardMatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "*";

        WildCardMatching obj = new WildCardMatching();
        System.out.println(obj.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
//        for(boolean[] temp : dp) Arrays.fill(temp, );

//         return recursive(m - 1, n - 1, p, s);
//        return memoization(m - 1, n - 1, p, s, dp);
        return tabulation(m, n, p, s, dp);
    }

    private boolean recursive(int i, int j, String s, String t) {
        if(i < 0 && j < 0) return true;
        if(i < 0) return false;
        if(j < 0) {
            for(int i1 = 0; i1 <= i; i1++) {
                if(s.charAt(i1) != '*') return false;
            }

            return true;
        }

        if(s.charAt(i) == t.charAt(j) || s.charAt(i) == '?') return recursive(i - 1, j - 1, s, t);
        if(s.charAt(i) == '*') return recursive(i - 1, j, s, t) || recursive(i, j - 1, s, t);

        return false;
    }

    private boolean memoization(int i, int j, String s, String t, int[][] dp) {
        if(i < 0 && j < 0) return true;
        if(i < 0) return false;
        if(j < 0) {
            for(int i1 = 0; i1 <= i; i1++) {
                if(s.charAt(i1) != '*') return false;
            }

            return true;
        }
        if (dp[i][j] != -1) {
            if(dp[i][j] == 0) return false;
            return true;
        }

        boolean ans = false;
        if (s.charAt(i) == t.charAt(j) || s.charAt(i) == '?') {
            ans = memoization(i - 1, j - 1, s, t, dp);
            if(!ans) dp[i][j] = 0;
            else dp[i][j] = 1;

            return ans;
        }

        if (s.charAt(i) == '*') {
            ans = (memoization(i - 1, j, s, t, dp) || memoization(i, j - 1, s, t, dp));
            if(!ans) dp[i][j] = 0;
            else dp[i][j] = 1;

            return ans;
        }

        dp[i][j] = 0;
        return false;
    }

    private boolean tabulation(int n, int m, String s, String t, boolean[][] dp) {
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) dp[0][j] = false;

        for(int i = 1; i <= n; i++) {
            dp[i][0] = s.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1) || s.charAt(i - 1) == '?') dp[i][j] =  dp[i - 1][j - 1];
                else if (s.charAt(i - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else dp[i][j] = false;
            }
        }

        return dp[n][m];
    }
}
