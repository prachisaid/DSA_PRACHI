package DynamicProgramming;

public class PartitionSetIntoTwoSubsetsMin {
    public static void main(String[] args) {
        int[] nums = {2,-1,0,4,-2,-9};
        PartitionSetIntoTwoSubsetsMin obj = new PartitionSetIntoTwoSubsetsMin();

        System.out.println(obj.minimumDifference(nums));
    }

    public int minimumDifference(int[] nums) {
        int totalSum = 0;
        for(int a : nums) totalSum += a;

        boolean[][] dp = new boolean[nums.length][totalSum + 1];
        int k = totalSum;
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        if(nums[0] <= k) dp[0][nums[0]] = true;

        for(int ind = 1; ind < nums.length; ind++) {
            for(int target = 1; target <= k; target++) {
                boolean notTake = dp[ind - 1][target];
                boolean take = false;

                if(nums[ind] <= target) {
                    take = dp[ind - 1][target - nums[ind]];
                }

                dp[ind][target] = take | notTake;
            }
        }

        int mini = (int) 1e7;
        int n = nums.length;
        for(int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[n - 1][s1]) {
                int val = s1 - (totalSum - s1);
                mini = Math.min(mini, Math.abs(val));
            }
        }

        return mini;
    }
}
