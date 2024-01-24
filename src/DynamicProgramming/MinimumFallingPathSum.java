package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        MinimumFallingPathSum obj = new MinimumFallingPathSum();
        System.out.println(obj.minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for(int [] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        for(int i = 0; i < matrix[0].length; i++) {
//            ans = Math.min(ans, recursive(n - 1, i, matrix));
//            ans = Math.min(ans, memoization(n - 1, i, matrix, dp));
        }
//        ans = Math.min(ans, tabulation(n, m, matrix, dp));
        ans = Math.min(ans, spaceOp(n, m, matrix));
        return ans;
    }
    private int recursive(int row, int col, int[][] matrix) {
        if(col < 0 || col > matrix[0].length - 1) return Integer.MAX_VALUE;
        if(row == 0) {
            return matrix[row][col];
        }

        int d = recursive(row - 1, col, matrix) + matrix[row][col];
        int ld = recursive(row - 1, col - 1, matrix) + matrix[row][col];
        int rd = recursive(row - 1, col + 1, matrix) + matrix[row][col];

        return (Math.min(rd, (Math.min(d, ld))));
    }

    private int memoization(int row, int col, int[][] matrix, int[][] dp) {
        if(row == 0) {
            return matrix[row][col];
        }

        if(dp[row][col] != -1) return dp[row][col];

        int ld = Integer.MAX_VALUE;
        int rd = Integer.MAX_VALUE;

        int d = memoization(row - 1, col, matrix, dp) + matrix[row][col];
        if(col > 0) {
            ld = memoization(row - 1, col - 1, matrix, dp) + matrix[row][col];
        }
        if(col < matrix[0].length - 1) {
            rd = memoization(row - 1, col + 1, matrix, dp) + matrix[row][col];
        }

        return dp[row][col] = (Math.min(rd, (Math.min(d, ld))));
    }

    private int tabulation(int n, int m, int[][] matrix, int[][] dp) {
        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int d = dp[i - 1][j] + matrix[i][j];
                int ld = Integer.MAX_VALUE;

                if(j > 0) {
                    ld = dp[i - 1][j - 1] + matrix[i][j];
                }

                int rd = Integer.MAX_VALUE;

                if(j < m - 1) {
                    rd = dp[i - 1][j + 1] + matrix[i][j];
                }

                dp[i][j] = Math.min(rd, Math.min(ld, d));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }

        return ans;
    }

    private int spaceOp(int n, int m, int[][] matrix) {
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
        }

        for(int i = 1; i < n; i++) {
            int[] temp = new int[n];
            for(int j = 0; j < m; j++) {
                int d = dp[j] + matrix[i][j];

                int ld  = Integer.MAX_VALUE;
                if(j > 0) {
                    ld = dp[j - 1] + matrix[i][j];
                }

                int rd = Integer.MAX_VALUE;
                if(j < m - 1) {
                    rd = dp[j + 1] + matrix[i][j];
                }

                temp[j] = Math.min(rd, Math.min(ld, d));
            }

            dp = temp;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }

        return ans;
    }
}
