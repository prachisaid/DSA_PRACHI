package DynamicProgramming;

import java.util.Arrays;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "acd";
        String str2 = "ced";

        System.out.println(lcs(str1, str2));
    }

    public static String lcs(String text1, String text2) {
        int ind1 = text1.length();
        int ind2 = text2.length();
        int[][] dp = new int[ind1 + 1][ind2 + 1];

        for(int[] temp : dp) Arrays.fill(temp, 0);

        return tabulation(ind1, ind2, text1, text2, dp);
    }

    private static String tabulation(int n, int m, String str1, String str2, int[][] dp) {
        for(int i = 0; i <= m; i++) dp[0][i] = 0;
        for(int i = 0; i <= n; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        for(int[] dp1 : dp) {
            System.out.println(Arrays.toString(dp1));
        }

        int len = dp[n][m];
        String str = "";

        int i = n, j = m;

        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                str += str1.charAt(i - 1);
                i--;
                j--;
            }

            else if(dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            }
            else{
                j--;
            }
        }

        return str;
    }
}
