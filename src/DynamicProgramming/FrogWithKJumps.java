package DynamicProgramming;

import java.util.Arrays;

public class FrogWithKJumps {
    public static void main(String[] args) {
        int[] heights = {10, 30, 40, 50, 20};
        System.out.println(frogJump(5, 3, heights));
    }

    public static int frogJump(int n, int k, int[] heights) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
//        return recursive(n - 1, k, heights);
        return memoization(n - 1, k, heights, dp);
    }

    private static int recursive(int ind, int k, int[] heights) {
        if(ind == 0) return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if(ind - i >= 0) {
                int jump = Math.min(ans, recursive(ind - i, k, heights) + Math.abs(heights[ind] - heights[ind - i]));
                ans = Math.min(jump, ans);
            }
        }

        return ans;
    }

    private static int memoization(int ind, int k, int[] heights, int[] dp) {
        if(ind == 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if(ind - i >= 0) {
                int jump = Math.min(ans, memoization(ind - i, k, heights, dp) + Math.abs(heights[ind] - heights[ind - i]));
                ans = Math.min(jump, ans);
            }
        }

        dp[ind] = ans;
        return ans;
    }

    private static int tabulation(int ind, int k, int[] heights, int[] dp) {
        if(ind == 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if(ind - i >= 0) {
                int jump = Math.min(ans, memoization(ind - i, k, heights, dp) + Math.abs(heights[ind] - heights[ind - i]));
                ans = Math.min(jump, ans);
            }
        }

        dp[ind] = ans;
        return ans;
    }
}
