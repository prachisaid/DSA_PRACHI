package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMPS {
    public static void main(String[] args) {
        List<List<Integer>> lst = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            lst.add(new ArrayList<>());
        }

        lst.get(0).add(2);

        lst.get(1).add(3);
        lst.get(1).add(4);

        lst.get(2).add(6);
        lst.get(2).add(5);
        lst.get(2).add(7);

        lst.get(3).add(4);
        lst.get(3).add(1);
        lst.get(3).add(8);
        lst.get(3).add(3);

        TriangleMPS obj = new TriangleMPS();
        System.out.println(obj.minimumTotal(lst));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
//        return recursive(0, 0, triangle);
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

//        return memoization(0, 0, triangle, dp);
//        return tabulation(triangle.size(), triangle, dp);
        return spaceOp(triangle.size(), triangle);
    }

    private int recursive(int row, int col, List<List<Integer>> triangle) {
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }

        int down = recursive(row + 1, col, triangle) + triangle.get(row).get(col);
        int diagonal = recursive(row + 1, col + 1, triangle) + triangle.get(row).get(col);

        return Math.min(down, diagonal);
    }

    private int memoization(int row, int col, List<List<Integer>> triangle, int[][] dp) {
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }

        if(dp[row][col] != -1) return dp[row][col];

        int down = memoization(row + 1, col, triangle, dp) + triangle.get(row).get(col);
        int diagonal = memoization(row + 1, col + 1, triangle, dp) + triangle.get(row).get(col);

        return dp[row][col] = Math.min(down, diagonal);
    }

    private int tabulation(int n, List<List<Integer>> triangle, int[][] dp) {
        for(int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int d = triangle.get(i).get(j) + dp[i + 1][j];
                int dig = triangle.get(i).get(j) + dp[i + 1][j + 1];

                dp[i][j] = Math.min(d, dig);
            }
        }

        return dp[0][0];
    }

    private int spaceOp(int n, List<List<Integer>> triangle) {
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for(int i = n - 2; i >= 0; i--) {
            int[] temp = new int[n];
            for(int j = i; j >= 0; j--) {
                int d = triangle.get(i).get(j) + dp[j];
                int dig = triangle.get(i).get(j) + dp[j + 1];

                temp[j] = Math.min(d, dig);
            }

            dp = temp;
        }

        return dp[0];
    }
}
