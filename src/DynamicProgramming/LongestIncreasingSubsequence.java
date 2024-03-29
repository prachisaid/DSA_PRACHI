package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(arr));
    }

    public int lengthOfLIS(int[] nums) {
        // return recursive(0, -1, nums);

        int[][] dp = new int[nums.length][nums.length + 1];
        for(int[] temp : dp) Arrays.fill(temp, -1);

        // return memoization(0, -1, nums, dp);

        return tabulation(nums.length, nums);
    }

    private int recursive(int ind, int prev, int[] nums) {
        if(ind == nums.length) return 0;

        int notTake = recursive(ind + 1, prev, nums);

        int take = (int) -1e9;
        if(prev == -1 || nums[ind] > nums[prev])  take = 1 + recursive(ind + 1, ind, nums);

        return Math.max(notTake, take);
    }

    private int memoization(int ind, int prev, int[] nums, int[][] dp) {
        if(ind == nums.length) return 0;
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        int notTake = memoization(ind + 1, prev, nums, dp);

        int take = (int) -1e9;
        if(prev == -1 || nums[ind] > nums[prev])  take = 1 + memoization(ind + 1, ind, nums, dp);

        return dp[ind][prev + 1] = Math.max(notTake, take);
    }

    private int tabulation(int n, int[] nums) {
        int[][] dp = new int[n + 1][n + 1];

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int prev = ind - 1; prev >= -1; prev--){
                int notTake = dp[ind + 1][prev + 1];

                int take = (int) -1e9;
                if(prev == -1 || nums[ind] > nums[prev])  take = 1 + dp[ind + 1][ind + 1];

                dp[ind][prev + 1] = Math.max(notTake, take);
            }
        }

        for(int[] temp : dp) System.out.println(Arrays.toString(temp));

        return dp[0][-1+1];
    }

    private int usingArray(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int ind = 0; ind < nums.length; ind++) {
            for(int prev = 0; prev < ind; prev++) {
                if(nums[ind] > nums[prev]) {
                    dp[ind] = Math.max(dp[ind], dp[prev] + 1);
                }
            }
        }

        int maxi = 0;

        for(int ans : dp) {
            if(maxi < ans) maxi = ans;
        }

        return maxi;
    }
}
