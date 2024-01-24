package DynamicProgramming;

import java.util.Arrays;

public class CountSubsetWithSumK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        System.out.println(findWays(nums, 3));
    }

    public static int findWays(int[] nums, int target) {
        int n = nums.length;
        // return recursive(n - 1, target, nums);

        int[][] dp = new int[n][target + 1];
        for(int[] dpRow : dp) Arrays.fill(dpRow, -1);

        return memoization(n - 1, target, nums, dp);
    }

    private static int recursive(int ind, int target, int[] nums) {
        if(target == 0) return 1;
        if(ind == 0) {
            if(target == nums[ind]) {
                return 1;
            }
            else {
                return 0;
            }
        }

        int notPick = recursive(ind - 1, target, nums);
        int pick = 0;

        if(nums[ind] <= target) {
            pick = recursive(ind - 1, target - nums[ind], nums);
        }

        return pick + notPick;
    }

    private static int memoization(int ind, int target, int[] nums, int[][] dp) {
        if(target == 0) return 1;
        if(ind == 0) {
            if(target == nums[ind]) return 1;
            else return 0;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notPick = memoization(ind - 1, target, nums, dp);
        int pick = 0;

        if(nums[ind] <= target) pick = memoization(ind - 1, target - nums[ind], nums, dp);

        return dp[ind][target] = notPick + pick;
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
