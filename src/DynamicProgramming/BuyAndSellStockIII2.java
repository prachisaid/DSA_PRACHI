package DynamicProgramming;

import java.util.Arrays;

public class BuyAndSellStockIII2 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new BuyAndSellStockIII2().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
//        return recursive(0, 0, prices);

        int[][] dp = new int[prices.length + 1][5];
        for(int[] temp : dp) Arrays.fill(temp, 0);

//        int ans = memoization(0, 1, prices, dp);
//        return ans;

        return tabulation(prices.length, prices, dp);
    }

    private int recursive(int ind, int trans, int[] prices) {
        if(ind == prices.length || trans == 4 ) return 0;

        if(trans % 2 == 0) {
            return Math.max(-prices[ind] + recursive(ind + 1, trans + 1, prices), recursive(ind + 1, trans, prices));
        }

        return Math.max(prices[ind] + recursive(ind + 1, trans + 1, prices), recursive(ind + 1, trans, prices));
    }

    private int memoization(int ind, int trans, int[] prices, int[][] dp) {
        if(trans == 4) return 0;
        if(ind == prices.length) return 0;
        if(dp[ind][trans] != -1) return dp[ind][trans];

        if(trans % 2 == 0) {
            return dp[ind][trans] = Math.max(-prices[ind] + memoization(ind + 1, trans + 1, prices, dp),
                    memoization(ind + 1, trans, prices, dp));
        }

        return dp[ind][trans] = Math.max(prices[ind] + memoization(ind + 1, trans + 1, prices, dp),
                memoization(ind + 1, trans, prices, dp));
    }

    private int tabulation(int n, int[] prices, int[][] dp) {
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int trans = 3; trans >= 0; trans--) {
                if(trans % 2 == 0) {
                    dp[ind][trans] = Math.max(-prices[ind] + dp[ind + 1][trans + 1], dp[ind + 1][trans]);
                }
                else {
                    dp[ind][trans] = Math.max(prices[ind] + dp[ind + 1][trans + 1], dp[ind + 1][trans]);
                }
            }
        }

        for(int[] temp : dp) System.out.println(Arrays.toString(temp));
        return dp[0][0];
    }
}
