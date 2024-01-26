package DynamicProgramming;

import java.util.Arrays;

public class PalindromePartitionII {
    public static void main(String[] args) {
        String str = "bababcbadcede";
        System.out.println(new PalindromePartitionII().minCut(str) - 1);
    }

    public int minCut(String s) {
        // return recursive(0, s) - 1;

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        // return memoization(0, s, dp);

        return tabulation(s);
    }

    private int recursive(int i, String str) {
        if(i == str.length()) return 0;

        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < str.length(); j++) {
            if(isPalindrome(i, j, str)) {
                int cost = 1 + recursive(j + 1, str);
                minCost = Math.min(cost, minCost);
            }
        }

        return minCost;
    }

    private int memoization(int i, String str, int[] dp) {
        if(i == str.length()) return 0;
        if(dp[i] != -1) return dp[i];

        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < str.length(); j++) {
            if(isPalindrome(i, j, str)) {
                int cost = 1 + memoization(j + 1, str, dp);
                minCost = Math.min(cost, minCost);
            }
        }

        return dp[i] = minCost;
    }

    private int tabulation(String s) {
        int[] dp = new int[s.length() + 1];
        for(int i = s.length() - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for(int j = i; j < s.length(); j++) {
                if(isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(cost, minCost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0];
    }

    private boolean isPalindrome(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
