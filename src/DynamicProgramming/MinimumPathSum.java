package DynamicProgramming;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        MinimumPathSum obj = new MinimumPathSum();
        System.out.println(obj.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

//        return recursive(n - 1, m - 1, grid);
//        return tabulation(n - 1, m - 1, grid, dp);
        return spaceOp(n - 1, m - 1, grid);
    }

    private int recursive(int row, int col, int[][] grid) {
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return 300;

        int up = recursive(row - 1, col, grid) + grid[row][col];
        int left = recursive(row , col - 1, grid) + grid[row][col];

        return Math.min(up, left);
    }

    private int memoization(int row, int col, int[][] grid, int[][] dp) {
        if(row == 0 && col == 0) return grid[row][col];
        if(row < 0 || col < 0) return 300;
        if(dp[row][col] != -1) return dp[row][col];

        int up = recursive(row - 1, col, grid) + grid[row][col];
        int left = recursive(row , col - 1, grid) + grid[row][col];

        return dp[row][col] = Math.min(up, left);
    }

    private int tabulation(int row, int col, int[][] grid, int[][] dp) {
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0) up = dp[i - 1][j] + grid[i][j];
                    if (j > 0) left = dp[i][j - 1] + grid[i][j];

                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[row][col];
    }

    private int spaceOp(int row, int col, int[][] grid) {
        int[] prev = new int[row + 1];
        for(int i = 0; i <= row; i++) {
            int[] temp = new int[row + 1];
            for(int j = 0; j <= col; j++) {
                if(i == 0 && j == 0) temp[j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;
                    if (i > 0) up = prev[j] + grid[i][j];
                    if (j > 0) left = temp[j - 1] + grid[i][j];

                    temp[j] = Math.min(up, left);
                }
            }

            prev = temp;
        }

        return prev[col];
    }
}
