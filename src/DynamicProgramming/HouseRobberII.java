package DynamicProgramming;

import java.util.Arrays;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {200,3,140,20,10};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans1 = removeLast(nums, nums.length - 2, dp);
        int ans2 = removeFirst(nums, nums.length - 1, dp);

        return Math.max(ans1, ans2);
    }

    private static int removeLast(int[] nums, int ind) {
        if(ind == 0) return nums[ind];

        if(ind < 0) return 0;

        int pick = nums[ind] + removeLast(nums, ind - 2);
        int nonpick = removeLast(nums, ind - 1);

        return Math.max(pick, nonpick);
    }

    private static int removeFirst(int[] nums, int ind) {
        if(ind == 1) return nums[ind];

        if(ind < 1) return 0;

        int pick = nums[ind] + removeFirst(nums, ind - 2);
        int nonpick = removeFirst(nums, ind - 1);

        return Math.max(pick, nonpick);
    }

    private static int removeLast(int[] nums, int ind, int[] dp) {
        if(ind == 0) return nums[ind];

        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + removeLast(nums, ind - 2, dp);
        int nonpick = removeLast(nums, ind - 1, dp);

        return dp[ind] = Math.max(pick, nonpick);
    }

    private static int removeFirst(int[] nums, int ind, int[] dp) {
        if(ind == 1) return nums[ind];

        if(ind < 1) return 0;

        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + removeFirst(nums, ind - 2, dp);
        int nonpick = removeFirst(nums, ind - 1, dp);

        return dp[ind] = Math.max(pick, nonpick);
    }
}
