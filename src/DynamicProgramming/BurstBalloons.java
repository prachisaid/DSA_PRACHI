package DynamicProgramming;

import java.util.*;
public class BurstBalloons {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 8};
        System.out.println(new BurstBalloons().maxCoins(arr));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        System.arraycopy(nums, 0, balloons, 1, nums.length);
        balloons[0] = balloons[balloons.length - 1] = 1;
        // System.out.println(Arrays.toString(balloons));

        int[][] dp = new int[n + 1][n + 1];
        for(int[] temp : dp) Arrays.fill(temp, -1);
        // return recursive(1, n, balloons);

        // return memoization(1, n, balloons, dp);

        return tabulation(balloons, n);
    }

    private int recursive(int i, int j, int[] nums) {
        if(i > j) return 0;

        int maxi = Integer.MIN_VALUE;

        for(int k = i; k <= j; k++) {
            int cost = (nums[i - 1] * nums[k] * nums[j + 1]) + recursive(i, k - 1, nums) +
                    recursive(k + 1, j, nums);

            maxi = Math.max(maxi, cost);
        }

        return maxi;
    }

    private int memoization(int i, int j, int[] nums, int[][] dp) {
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;

        for(int k = i; k <= j; k++) {
            int cost = (nums[i - 1] * nums[k] * nums[j + 1]) + memoization(i, k - 1, nums, dp) + memoization(k + 1, j, nums, dp);

            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;
    }

    private int tabulation(int[] nums, int n) {
        int[][] dp = new int[n + 2][n + 2];

        for(int i = n; i >= 1; i--) {
            for(int j = i; j <= n; j++) {
                if(i > j) continue;

                int maxi = Integer.MIN_VALUE;

                for(int k = i; k <= j; k++) {
                    int cost = (nums[i - 1] * nums[k] * nums[j + 1]) + dp[i][k - 1] + dp[k + 1][j];
                    maxi = Math.max(maxi, cost);
                }

                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }
}
