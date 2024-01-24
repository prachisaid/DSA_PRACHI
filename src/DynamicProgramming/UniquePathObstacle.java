package DynamicProgramming;

import java.util.*;

public class UniquePathObstacle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            mat.add(new ArrayList<>());
            mat.get(i).add(0);
            mat.get(i).add(0);
            mat.get(i).add(0);
        }
        mat.get(1).set(1, -1);
        System.out.println(mat);
        System.out.println(mazeObstacles(3, 3, mat));
    }

    public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
//        return recursive(n - 1, m - 1, mat);
        int[][] dp = new int[n][m];
        for(int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }
        return memoization(n - 1, m - 1, mat, dp);
    }

    private static int recursive(int row, int col, ArrayList<ArrayList<Integer>> mat) {
        if(row >= 0 && col >= 0 && mat.get(row).get(col) == -1) return 0;
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;

        int up = recursive(row - 1, col, mat);
        int down = recursive(row, col - 1, mat);

        return up + down;
    }

    private static int memoization(int row, int col, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if(row == 0 && col == 0) return 1;
        if(row < 0 || col < 0) return 0;
        if(mat.get(row).get(col) == -1){ return 0;}

        if(dp[row][col] != -1) return dp[row][col];

        int up = memoization(row - 1, col, mat, dp);
        int down = memoization(row, col - 1, mat, dp);

        return dp[row][col] = up + down;
    }
    
    private static int tabulation(int row, int col, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                if(mat.get(i).get(j) == -1) dp[i][j] =0;
                else if(row == 0 && col == 0) dp[i][j] = 1;
                else {
                    int up = 0;
                    int down = 0;

                    if(i > 0) up = dp[i - 1][j];
                    if(j > 0) down = dp[i][j - 1];

                    dp[i][j] = up + down;
                }
            }
        }

        return dp[row][col];
    }
}
