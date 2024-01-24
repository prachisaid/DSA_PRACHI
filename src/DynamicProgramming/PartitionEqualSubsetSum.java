package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};

        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();

        System.out.println(obj.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int a : nums) {
            sum += a;
        }
        if(sum % 2 == 1) return false;

        int n = nums.length;
        int k = sum / 2;
//        return recursive(n, k, nums);

        int[][] dp = new int[n][k + 1];
        for(int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        return memoization(n - 1, k, nums, dp);
    }

    private static boolean recursive(int ind, int target, int[] nums) {
        if(target == 0) return true;
        if(ind == 0) return (nums[0] == target);

        boolean notTake = recursive(ind - 1, target, nums);
        boolean take = false;

        if(nums[ind] <= target) {
            take = recursive(ind - 1, target - nums[ind], nums);
        }

        return take | notTake;
    }

    private static boolean memoization(int ind, int target, int[] nums, int[][] dp) {
        if(target == 0) return true;
        if(ind == 0) return (nums[0] == target);

        if(dp[ind][target] != -1) {
            if(dp[ind][target] == 0) return false;
            else return true;
        }

        boolean notTake = memoization(ind - 1, target, nums, dp);
        boolean take = false;

        if(nums[ind] <= target) {
            take = memoization(ind - 1, target - nums[ind], nums, dp);
        }

        if(notTake | take) {
            dp[ind][target] = 1;
        }
        else{
            dp[ind][target] = 0;
        }
        return (notTake | take);
    }
}
