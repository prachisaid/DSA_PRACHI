package DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockIII {
    public static void main(String[] args) {
        int[] prices = {2, 4, 1};
        System.out.println(new BuyAndSellStockIII().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
//        return recursion(0, 1, 2, prices.length, prices);

        int[][][] dp = new int[prices.length + 1][2][3];
        for(int[][] temp1 : dp) {
            for(int[] temp2 : temp1) Arrays.fill(temp2, 0);
        }
//
//        return memoization(0, 1, 2, prices.length, prices, dp);

//        return tabulation(prices.length, prices, dp);

        return spaceOp(prices.length, prices);
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
        if(dp[ind][buy][cap - 1] != -1) return dp[ind][buy][cap - 1];

        int profit = 0;

        if(buy == 1){
            profit = Math.max(-prices[ind] + memoization(ind + 1, 0, cap, n, prices, dp),
                    memoization(ind + 1, 1, cap, n, prices, dp));
        }
        else {
            profit = Math.max(prices[ind] + memoization(ind + 1, 1, cap - 1, n, prices, dp),
                    memoization(ind + 1, 0, cap, n, prices, dp));
        }

        return dp[ind][buy][cap - 1] = profit;
    }

    private int tabulation(int n, int[] prices, int[][][] dp) {
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {

                    if(buy == 1){
                        dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind + 1][0][cap],
                                dp[ind + 1][1][cap]);
                    }
                    else {
                        dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind + 1][1][cap - 1],
                                dp[ind + 1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }

    private int spaceOp(int n, int[] prices){
        int[][] after = new int[2][3];
        int[][] cur = new int[2][3];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if(buy == 1){
                        cur[buy][cap] = Math.max(-prices[ind] + after[0][cap],
                                after[1][cap]);
                    }
                    else {
                        cur[buy][cap] = Math.max(prices[ind] + after[1][cap - 1],
                                after[0][cap]);
                    }
                }
            }

            after = cur;
        }

        return after[1][2];
    }
}
