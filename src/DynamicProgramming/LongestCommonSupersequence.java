package DynamicProgramming;

public class LongestCommonSupersequence {
    public static void main(String[] args) {

    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        StringBuilder str = new StringBuilder(lcs(str1.length(), str2.length(),str1,str2,dp));
        return str.reverse().toString();
    }

    private String lcs (int n, int m, String str1, String str2, int[][] dp) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i][j - 1]);
            }
        }

        int i = n, j = m;
        String ans = "";

        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                ans += str1.charAt(i - 1);
                i--;
                j--;
            }

            else if(dp[i - 1][j] > dp[i][j - 1]){
                ans += str1.charAt(i - 1);
                i--;
            }

            else {
                ans += str2.charAt(j - 1);
                j--;
            }
        }

        while(i > 0) {
            ans += str1.charAt(i - 1);
            i--;
        }

        while(j > 0){
            ans += str2.charAt(j - 1);
            j--;
        }

        return ans;
    }

}
