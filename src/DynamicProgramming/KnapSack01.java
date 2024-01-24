package DynamicProgramming;

import java.util.Arrays;

public class KnapSack01 {
    public static void main(String[] args) {
        int[] wt = {3, 2, 5};
        int[] val = {30, 40, 60};

        System.out.println(knapsack(wt, val, wt.length, 6));
    }

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        // return recursive(n - 1, maxWeight, weight, value);

        int[][] dp = new int[n][maxWeight + 1];
        for(int[] dpRow : dp) Arrays.fill(dpRow, 0);
        // return memoization(n - 1, maxWeight, weight, value, dp);

//        return tabulation(n, maxWeight, weight, value, dp);
        return spaceOp(n, maxWeight, weight, value);
    }

    private static int recursive(int ind, int W, int[] wt, int[] val) {
        if(ind == 0) {
            if(wt[0] <= W) return val[0];
            else return 0;
        }

        int notTake = recursive(ind - 1, W, wt, val);
        int take = Integer.MIN_VALUE;

        if(wt[ind] <= W) take = val[ind] + recursive(ind - 1, W - wt[ind], wt, val);

        return Math.max(notTake, take);
    }

    private static int memoization(int ind, int W, int[] wt, int[] val, int[][] dp) {
        if(ind == 0) {
            if(wt[0] <= W) return val[0];
            else return 0;
        }

        if(dp[ind][W] != -1) return dp[ind][W];

        int notTake = memoization(ind - 1, W, wt, val, dp);
        int take = Integer.MIN_VALUE;

        if(wt[ind] <= W) take = val[ind] + memoization(ind - 1, W - wt[ind], wt, val, dp);

        return dp[ind][W] = Math.max(notTake, take);
    }

    private static int tabulation(int n, int maxWeight, int[] wt, int[] val, int[][] dp) {
        for(int i = wt[0]; i <= maxWeight; i++) dp[0][i] = val[0];

        for(int ind = 1; ind < n; ind++) {
            for(int W = 0; W <= maxWeight; W++) {
                int notTake = dp[ind - 1][W];
                int take = Integer.MIN_VALUE;

                if(wt[ind] <= W) take = val[ind] + dp[ind - 1][W - wt[ind]];

                dp[ind][W] = Math.max(notTake, take);
            }
        }

        return dp[n - 1][maxWeight];
    }

    private static int spaceOp(int n, int maxWeight, int[] wt, int[] val) {
        int[] prev = new int[maxWeight + 1];
        for(int i = wt[0]; i <= maxWeight; i++) prev[i] = val[0];

        for(int ind = 1; ind < n; ind++) {
//            int[] temp = new int[maxWeight + 1];
            for(int W = maxWeight; W >= 0; W--) {
                int notTake = prev[W];
                int take = Integer.MIN_VALUE;

                if(wt[ind] <= W) take = val[ind] + prev[W - wt[ind]];

                prev[W] = Math.max(notTake, take);
            }

//            prev = temp;
        }

        return prev[maxWeight];
    }
}
