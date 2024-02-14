package DynamicProgramming;

import java.util.Arrays;

public class PalindromicSubstring {
    public static void main(String[] args) {
        String str = "aa";
        System.out.println(new PalindromicSubstring().countSubstrings(str));
    }

    public int countSubstrings(String s) {
        return longestPalindrome(s);
    }

    public int longestPalindrome(String s) {
        int[][] dp = new int[1001][1001];
        for(int[] temp : dp) Arrays.fill(temp, -1);

        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(memoization(s, i, j, dp)) {
                    count += 1;
                }
            }
        }

        return count;
    }

    private boolean memoization(String s, int l, int r, int[][] dp) {
        if(l >= r) return true;

        if(dp[l][r] != -1) return dp[l][r] == 1;

        if(s.charAt(l) == s.charAt(r)) {
            boolean ans = memoization(s, l + 1, r - 1, dp);
            if(ans) dp[l][r] = 1;
            else dp[l][r] = 0;

            return ans;
        }

        dp[l][r] = 0;
        return false;
    }
}
