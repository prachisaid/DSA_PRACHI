package DynamicProgramming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequences {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        System.out.println(new NumberOfLongestIncreasingSubsequences().findNumberOfLIS(arr));
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int maxi = 1;

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        for(int ind = 1; ind < n; ind++) {
            for(int prev = 0; prev < ind; prev++) {
                if(nums[ind] > nums[prev] && dp[ind] < dp[prev] + 1) {
                    dp[ind] = dp[prev] + 1;
                    cnt[ind] = cnt[prev];
                }

                else if (nums[ind] > nums[prev] && dp[ind] == dp[prev] + 1)
                    cnt[ind] += cnt[prev];
            }

            maxi = Math.max(maxi, dp[ind]);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(dp[i] == maxi) count += cnt[i];
        }
        return count;
    }
}
