package recursion;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        uniquePaths(4, 4);
    }

    static int uniquePaths(int row, int col) {
        int dp[][] = new int[row+1][col+1];

        for(int[] dpRow : dp){
            Arrays.fill(dpRow, -1);
        }

        return helper(row, col, dp);
    }

    static private int helper(int row, int col, int[][] dp){
        if(row == 1 || col == 1){
            return 1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int left = helper(row - 1, col, dp);
        int right = helper(row, col - 1, dp);
        dp[row][col] = left + right;

        return left + right;
    }
}
