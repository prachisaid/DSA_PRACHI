package DynamicProgramming;

import java.util.*;
public class LongestIncreasingSubsequencePrinting {
    public static void main(String[] args) {
        int[] nums = {5, 4, 11, 1, 16, 8};
        System.out.println(new LongestIncreasingSubsequencePrinting().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] lastIndex = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int ind = 0; ind < nums.length; ind++) {
            lastIndex[ind] = ind;
            for(int prev = 0; prev < ind; prev++) {
                if(nums[ind] > nums[prev]) {
                    if(dp[ind] < dp[prev] + 1) {
                        lastIndex[ind] = prev;
                        dp[ind] = dp[prev] + 1;
                    }
                }
            }
        }

        int maxi = 0;
        int maxIndex = -1;

        for(int i = 0; i < dp.length; i++) {
            if(maxi < dp[i]) {
                maxi = dp[i];
                maxIndex = i;
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();
        while(lastIndex[maxIndex] != maxIndex) {
            lst.add(nums[maxIndex]);
            maxIndex = lastIndex[maxIndex];
        }

        lst.add(nums[maxIndex]);
        System.out.println(lst);

        return maxi;
    }
}
