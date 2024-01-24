package DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 2};
        System.out.println(new BuyAndSellStockWithCooldown().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        // return recursive(0, 1, prices);

        int[][] dp = new int[prices.length][2];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        // return memoization(0, 1, prices, dp);

        // return tabulation(prices.length, prices);

        return spaceOp(prices.length, prices);
    }

    private int recursive(int ind, int buy, int[] prices) {
        if(ind >= prices.length) return 0;

        if(buy == 1) {
            return Math.max(-prices[ind] + recursive(ind + 1, 0, prices), recursive(ind + 1, 1, prices));
        }

        return Math.max(prices[ind] + recursive(ind + 2, 1, prices), recursive(ind + 1, 0, prices));
    }

    private int memoization(int ind, int buy, int[] prices, int[][] dp) {
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];

        if(buy == 1) {
            return dp[ind][buy] = Math.max(-prices[ind] + memoization(ind + 1, 0, prices, dp),
                    memoization(ind + 1, 1, prices, dp));
        }

        else {
            return dp[ind][buy] = Math.max(prices[ind] + memoization(ind + 2, 1, prices, dp),
                    memoization(ind + 1, 0, prices, dp));
        }
    }

    private int tabulation(int n, int[] prices) {
        int[][] dp = new int[n + 2][2];

        for(int ind = n - 1; ind >= 0; ind--) {
            dp[ind][1] = Math.max(-prices[ind] + dp[ind + 1][0], dp[ind + 1][1]);

            dp[ind][0] = Math.max(prices[ind] + dp[ind + 2][1], dp[ind + 1][0]);
        }

        return dp[0][1];
    }

    private int spaceOp(int n, int[] prices) {
        int[] after2 = new int[2];
        int[] after1 = new int[2];
        int[] cur = new int[2];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int buy = 0; buy <= 1; buy++) {
                if(buy == 1) {
                    cur[buy] = Math.max(-prices[ind] + after1[0], after1[1]);
                }
                else {
                    cur[buy] = Math.max(prices[ind] + after2[1], after1[0]);
                }
            }

            System.arraycopy(after1, 0, after2, 0, 2);
            System.arraycopy(cur, 0, after1, 0, 2);
        }

        return cur[1];
    }
}
