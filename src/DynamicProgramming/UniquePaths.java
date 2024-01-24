package DynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

    public static int uniquePaths(int m, int n) {
//        return recursive(m - 1, n - 1);
        int[][] dp = new int[m][n];
        for(int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
//        return memoization(m - 1, n - 1, dp);
//        return tabulation(m - 1, n - 1, dp);
        return spaceOp(m - 1, n - 1);
    }

    private static int recursive(int row, int col) {
        if(row == 0 && col == 0) {
            return 1;
        }

        if(row < 0 || col < 0) return 0;

        int left = recursive(row - 1, col);
        int right = recursive(row, col - 1);

        return left + right;
    }

    private static int memoization(int row, int col, int[][] dp) {
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;

        if(dp[row][col] != -1) return dp[row][col];

        int left = memoization(row - 1, col, dp);
        int right = memoization(row, col - 1, dp);

        return dp[row][col] = left + right;
    }

    private static int tabulation(int row, int col, int[][] dp) {
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                if(i == 0 && j == 0) dp[0][0] = 1;
                else{
                    int left = 0;
                    int down = 0;

                    if(i > 0) down = dp[i - 1][j];
                    if(j > 0) left = dp[i][j - 1];

                    dp[i][j] = down + left;
                }
            }
        }

        return dp[row][col];
    }

    private static int spaceOp(int row, int col) {
        int[] dp = new int[row + 1];

        for (int i = 0; i <= row; i++) {
            int[] temp = new int[row + 1];
            for (int j = 0; j <= col; j++) {
                if (i == 0 && j == 0) temp[j] = 1;
                else {
                    int up = 0;
                    int down = 0;

                    up = dp[j];
                    if(j > 0) down = temp[j - 1];

                    temp[j] = up + down;
                }
            }

            dp = temp;
        }

        return dp[row];
    }
}
