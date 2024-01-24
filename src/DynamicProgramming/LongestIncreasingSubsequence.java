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

        return memoization(0, -1, nums, dp);
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
}
