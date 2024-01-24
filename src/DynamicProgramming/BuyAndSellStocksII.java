package DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStocksII {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(new BuyAndSellStocksII().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
//        return recursive(0, 1, prices.length, prices);

        int[][] dp = new int[prices.length + 1][2];
        for(int[] temp : dp) Arrays.fill(temp, 0);

//        return memoization(0, 1, prices.length, prices, dp);

//        return tabulation(prices.length, prices, dp);

//        return spaceOp(prices.length, prices);

        return spaceOpVars(prices.length, prices);
    }

    private int recursive(int ind, int buy, int n, int[] prices) {
        if(ind == n) return 0;

        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[ind]  + recursive(ind + 1, 0, n, prices) , recursive(ind + 1, 1, n, prices));
        }
        else {
            profit = Math.max(prices[ind]  + recursive(ind + 1, 1, n, prices) , recursive(ind + 1, 0, n, prices));
        }

        return profit;
    }

    private int memoization(int ind, int buy, int n, int[] prices, int[][] dp) {
        if(ind == n) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[ind]  + memoization(ind + 1, 0, n, prices, dp) , memoization(ind + 1, 1, n, prices, dp));
        }
        else {
            profit = Math.max(prices[ind]  + memoization(ind + 1, 1, n, prices, dp) , memoization(ind + 1, 0, n, prices, dp));
        }

        return dp[ind][buy] = profit;
    }

    private int tabulation(int n, int[] prices, int[][] dp) {
        dp[n][0] = dp[n][1] = 0;

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if(buy == 1) {
                    profit = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                }
                else {
                    profit = Math.max(prices[ind] + dp[ind + 1][1], dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][1];
    }

    private int spaceOp(int n, int[] prices) {
        int[] prev = new int[2];
        int[] cur = new int[2];

        for(int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 1) {
                    profit = Math.max(-prices[ind] + prev[0], prev[1]);
                }
                else {
                    profit = Math.max(prices[ind] + prev[1], prev[0]);
                }

                cur[buy] = profit;
            }

            prev = cur;
        }

        return prev[1];
    }

    private int spaceOpVars(int n, int[] prices) {
        int nextBuy = 0, nextNotBuy = 0;
        int curBuy = 0, curNotBuy = 0;

        for(int ind = n - 1; ind >= 0; ind--) {
            curBuy = Math.max(-prices[ind] + nextNotBuy, nextBuy);
            curNotBuy = Math.max(prices[ind] + nextBuy, nextNotBuy);

            nextBuy = curBuy;
            nextNotBuy = curNotBuy;
        }

        return nextBuy;
    }
}
