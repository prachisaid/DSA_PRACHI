package DynamicProgramming;

import java.util.Arrays;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        MinimumCoins obj = new MinimumCoins();

        System.out.println(obj.coinChange(coins, 8));
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
//        return recursive(n - 1, amount, coins);

        int[][] dp = new int[n][amount + 1];
        for(int[] temp : dp) Arrays.fill(temp, -1);

//        int ans = memoization(n - 1, amount, coins, dp);
//        int ans = tabulation(n - 1, amount, coins, dp);
        int ans = spaceOp(n - 1, amount, coins);
        if(ans == (int)1e9) return -1;
        return ans;
    }

    private static int recursive(int ind, int T, int[] coins) {
        if (ind == 0) {
            if (T % coins[0] == 0) return (T / coins[0]);
            else return (int) 1e9;
        }

        int notTake = recursive(ind - 1, T, coins);
        int take = (int) 1e9;

        if(coins[ind] <= T) take = 1 + recursive(ind, T - coins[ind], coins);

        return Math.min(notTake, take);
    }

    private static int memoization(int ind, int T, int[] coins, int[][] dp) {
        if(ind == 0){
            if(T % coins[0] == 0) return (T / coins[0]);
            else return (int) 1e9;
        }

        if(dp[ind][T] != -1) return dp[ind][T];

        int notTake = memoization(ind - 1, T, coins, dp);
        int take = (int) 1e9;

        if(coins[ind] <= T) take = 1 + memoization(ind, T - coins[ind], coins, dp);

        return dp[ind][T] = Math.min(take, notTake);
    }

    private static int tabulation(int n, int amount, int[] coins, int[][] dp) {
        for(int i = 0; i <= amount; i++) {
            if(i % coins[0] == 0) dp[0][i] = (i / coins[0]);
            else dp[0][i] = (int) 1e9;
        }

        for(int ind = 1; ind <= n; ind++) {
            for(int T = 0; T <= amount; T++) {
                int notTake = dp[ind - 1][T];
                int take = (int) 1e9;

                if(coins[ind] <= T) {
                    take = 1 + dp[ind][T - coins[ind]];
                }

                dp[ind][T] = Math.min(take, notTake);
            }
        }

        return dp[n][amount];
    }

    private static int spaceOp(int n, int amount, int[] coins) {
        int[] prev = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) prev[i] = (i / coins[0]);
            else prev[i] = (int) 1e9;
        }

        for (int ind = 1; ind <= n; ind++) {
            int[] temp = new int[amount + 1];
            for (int T = 0; T <= amount; T++) {
                int notTake = prev[T];
                int take = (int) 1e9;

                if (coins[ind] <= T) {
                    take = 1 + temp[T - coins[ind]];
                }

                temp[T] = Math.min(take, notTake);
            }
            prev = temp;
        }

        return prev[amount];
    }
}
