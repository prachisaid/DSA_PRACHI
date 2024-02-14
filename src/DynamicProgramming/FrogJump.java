package DynamicProgramming;
import java.util.*;
public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {7, 4, 4, 2, 6, 6,3, 4};
        System.out.println(frogJump(8, heights));
    }

    public static int frogJump(int n, int heights[]) {
//        return recursive(n - 1, heights);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return tabulation(n - 1, heights, dp);
    }

    private static int recursive(int ind, int[] heights) {
        if(ind == 0) return 0;

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        left = recursive(ind - 1, heights) + Math.abs(heights[ind] - heights[ind - 1]);

        if(ind > 1) {
            right = recursive(ind - 2, heights) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        return Math.min(left, right);
    }

    private static int recursive(int ind, int[] heights, int[] dp) {
        if(ind == 0) return 0;

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if(dp[ind] != -1) return dp[ind];

        left = recursive(ind - 1, heights, dp) + Math.abs(heights[ind] - heights[ind - 1]);

        if(ind > 1) {
            right = recursive(ind - 2, heights, dp) + Math.abs(heights[ind] - heights[ind - 2]);
        }

        dp[ind] = Math.min(left, right);

        return dp[ind];
    }

    private static int tabulation(int ind, int[] heights, int[] dp) {
        dp[0] = 0;

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        for(int i = 1; i <= ind; i++) {
            left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            if(i > 1) {
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(left, right);
        }

        return dp[ind];
    }

    private static int spaceOp(int ind, int[] heights) {
        int prev = 0;
        int prev2 = 0;

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        for(int i = 1; i <= ind; i++) {
            left = prev + Math.abs(heights[i] - heights[i - 1]);
            if(i > 1) {
                right = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }

            int cur = Math.min(left, right);
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}
