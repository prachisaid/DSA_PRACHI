package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximumSumOfNonAdjacent {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(2);
        lst.add(1);
        lst.add(4);
        lst.add(9);

        System.out.println(maximumNonAdjacentSum(lst));
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        return recursive(nums, nums.size() - 1);
    }
    private static int recursive(ArrayList<Integer> nums, int ind) {
        if(ind == 0) return nums.get(ind);
        if(ind < 0) return 0;

        int pick = nums.get(ind) + recursive(nums, ind - 2);
        int nonpick =  recursive(nums, ind - 1);

        return Math.max(pick, nonpick);
    }

    private static int memoization(ArrayList<Integer> nums, int ind, int[] dp) {
        if(ind == 0) return nums.get(ind);
        if(ind < 0) return 0;

        if(dp[ind] != -1) return dp[ind];
        int pick = nums.get(ind) + memoization(nums, ind - 2, dp);
        int nonpick = memoization(nums, ind - 1, dp);

        return dp[ind] = Math.max(pick, nonpick);
    }

    private static int tabulation(ArrayList<Integer> nums, int ind, int[] dp) {
        dp[ind] = nums.get(0);

        for(int i = 1; i < nums.size(); i++) {
            int pick = nums.get(i);
            if(i > 1) {
                pick += dp[i - 2];
            }
            int nonpick = dp[i - 1];

            dp[i] = Math.max(pick, nonpick);
        }

        return dp[nums.size() - 1];
    }

    private static int spaceOp(ArrayList<Integer> nums, int ind, int[] dp) {
        int n = nums.size();
        int prev = nums.get(0);
        int prev2 = 0;

        for(int i = 1; i < n; i++) {
            int take = nums.get(i);
            if(i > 1) {
                take += prev2;
            }

            int nontake = prev;

            int cur = Math.max(take, nontake);
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}
