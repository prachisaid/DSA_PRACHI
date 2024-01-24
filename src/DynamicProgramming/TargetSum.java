package DynamicProgramming;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int d) {
        int totalSum = 0;
        for(int n : nums) totalSum += n;

        if((totalSum - d < 0) || ((totalSum - d) % 2) == 1) return 0;

        int n = nums.length;
        int target = totalSum / 2;

        int[][] dp = new int[n][totalSum + 1];
        for(int[] temp : dp) Arrays.fill(temp, -1);

        return tabulation(target, nums, dp);
    }

    private static int tabulation(int target, int[] arr, int[][] dp) {
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1;

        for(int ind = 1; ind <= arr.length - 1; ind++) {
            for(int sum = 1; sum <= target; sum++) {
                int notPick = dp[ind - 1][sum];
                int pick = 0;

                if(arr[ind] <= sum) pick = dp[ind - 1][sum - arr[ind]];

                dp[ind][sum] = pick + notPick;
            }
        }

        return dp[arr.length - 1][target];
    }
}
