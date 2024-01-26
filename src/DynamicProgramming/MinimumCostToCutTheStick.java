package DynamicProgramming;

import java.util.Arrays;

public class MinimumCostToCutTheStick {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5};
        System.out.println(new MinimumCostToCutTheStick().minCost(7, arr));
    }

    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, arr, 1, cuts.length);
        arr[arr.length - 1] = n;
        Arrays.sort(arr);

        int[][] dp = new int[cuts.length + 1][cuts.length + 1];
        for(int[] temp : dp) Arrays.fill(temp, -1);

        // return recursive(1, cuts.length, arr);
        // return memoization(1, cuts.length, arr, dp);
        return tabulation(arr, cuts.length);
    }

    private int recursive(int i, int j, int[] cuts) {
        if(i > j) return 0;

        int mini = (int) 1e9;

        for(int k = i; k <= j; k++) {
            int cost = (cuts[j + 1] - cuts[i - 1]) + recursive(i, k - 1, cuts) + recursive(k + 1, j, cuts);
            mini = Math.min(mini, cost);
        }

        return mini;
    }

    private int memoization(int i, int j, int[] cuts, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int mini = (int) 1e9;

        for(int k = i; k <= j; k++) {
            int cost = (cuts[j + 1] - cuts[i - 1]) + memoization(i, k - 1, cuts, dp) + memoization(k + 1, j, cuts, dp);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }

    private int tabulation(int[] cuts, int n) {
        int[][] dp = new int[n + 2][n + 2];

        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= n; j++) {
                if(i > j) continue;
                int mini = (int) 1e9;

                for(int k = i; k <= j; k++) {
                    int cost = (cuts[j + 1] - cuts[i - 1]) + dp[i][k - 1] + dp[k + 1][j];
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][n];
    }
}
