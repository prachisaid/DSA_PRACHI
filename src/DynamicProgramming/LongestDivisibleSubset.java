package DynamicProgramming;

import java.util.*;

public class LongestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {1, 16, 7, 8, 4};
        System.out.println(new LongestDivisibleSubset().largestDivisibleSubset(arr));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] lastIndex = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp, 1);

        for(int ind = 0; ind < n; ind++) {
            lastIndex[ind] = ind;
            for(int prev = 0; prev < ind; prev++) {
                if(nums[ind] % nums[prev] == 0) {
                    if(dp[ind] < dp[prev] + 1) {
                        dp[ind] = dp[prev] + 1;
                        lastIndex[ind] = prev;
                    }
                }
            }
        }

        int maxi = 0;
        for(int i = 0; i < n; i++) {
            if(dp[i] > dp[maxi]) {
                maxi = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(maxi != lastIndex[maxi]) {
            ans.add(nums[maxi]);
            maxi = lastIndex[maxi];
        }
        ans.add(nums[maxi]);

        return ans;
    }
}
