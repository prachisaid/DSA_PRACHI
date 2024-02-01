package DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockIV {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1};
        System.out.println(new BuyAndSellStockIV().maxProfit(2, arr));
    }

    public int maxProfit(int k, int[] prices) {
//        return recursion(0, 1, k, prices.length, prices);

//        int[][][] dp = new int[prices.length][2][k];
//        for(int[][] temp1 : dp) {
//            for(int[] temp2 : temp1) Arrays.fill(temp2, -1);
//        }

//        return memoization(0, 1, k, prices.length, prices, dp);


        int[][][] dp = new int[prices.length + 1][2][k + 1];
        for(int[][] temp1 : dp) {
            for(int[] temp2 : temp1) Arrays.fill(temp2, 0);
        }

//        return tabulation(k, prices.length, prices, dp);

        return recursive(0, 0, k, prices.length, prices);
    }
    private int recursion(int ind, int buy, int cap, int n, int[] prices) {
        if(cap == 0) return 0;
        if(ind == n) return 0;

        int profit = 0;

        if(buy == 1){
            profit = Math.max(-prices[ind] + recursion(ind + 1, 0, cap, n, prices), recursion(ind + 1, 1, cap, n, prices));
        }
        else {
            profit = Math.max(prices[ind] + recursion(ind + 1, 1, cap - 1, n, prices), recursion(ind + 1, 0, cap, n, prices));
        }

        return profit;
    }

    private int memoization(int ind, int buy, int cap, int n, int[] prices, int[][][] dp) {
        if(cap == 0) return 0;
        if(ind == n) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit = 0;

        if(buy == 1){
            profit = Math.max(-prices[ind] + memoization(ind + 1, 0, cap, n, prices, dp),
                    memoization(ind + 1, 1, cap, n, prices, dp));
        }
        else {
            profit = Math.max(prices[ind] + memoization(ind + 1, 1, cap - 1, n, prices, dp),
                    memoization(ind + 1, 0, cap, n, prices, dp));
        }

        return dp[ind][buy][cap] = profit;
    }

    private int tabulation(int k, int n, int[] prices, int[][][] dp) {
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= k; cap++) {
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-prices[ind] + dp[ind + 1][0][cap],
                                dp[ind + 1][1][cap]);
                    }
                    else {
                        profit = Math.max(prices[ind] + dp[ind + 1][1][cap - 1],
                                dp[ind + 1][0][cap]);
                    }

                    dp[ind][buy][cap] = profit;
                }
            }
        }

        for(int[][] temp1 : dp) {
            for(int[] temp2 : temp1) System.out.println(Arrays.toString(temp2));
        }
        return dp[0][1][k];
    }

    private int recursive(int ind, int trans, int k, int n, int[] prices) {
        if(ind == n || trans == k) return 0;

        int profit = 0;

        if(trans % 2 == 0) {
            profit = Math.max(-prices[ind] + recursive(ind + 1, trans + 1, k, n, prices),
                    recursive(ind + 1, trans, k, n, prices));
        }
        else {
            profit = Math.max(prices[ind] + recursive(ind + 1, trans + 1, k, n, prices),
                    recursive(ind + 1, trans, k, n, prices));
        }

        return profit;
    }
}
