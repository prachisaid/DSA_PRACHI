package DynamicProgramming;

import java.util.Arrays;

public class SubsetSumEquals {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1};
        System.out.println(subsetSumToK(4, 4, arr));
    }

    public static boolean subsetSumToK(int n, int k, int[] arr){
//        return recursive(n - 1, k, arr);
        int[][] dp = new int[n][k + 1];
        for(int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

//        return memoization(n - 1, k, arr, dp);
        return spaceOp(n - 1, k, arr);
    }

    private static boolean recursive(int n, int target, int[] arr) {
        if(target == 0) return true;
        if(n == 0) return (arr[0] == target);

        boolean notTake = recursive(n - 1, target, arr);
        boolean take = false;

        if(arr[n] <= target) {
            take = recursive(n - 1, target - arr[n], arr);
        }

        return (notTake | take);
    }

    private static boolean memoization(int n, int target, int[] arr, int[][] dp) {
        if(target == 0) return true;
        if(n == 0) return (arr[0] == target);

        if(dp[n][target] != -1) {
            if(dp[n][target] == 0) return false;
            else return true;
        }

        boolean notTake = memoization(n - 1, target, arr, dp);
        boolean take = false;

        if(arr[n] <= target) {
            take = memoization(n - 1, target - arr[n], arr, dp);
        }

        if(notTake | take) {
            dp[n][target] = 1;
        }
        else{
            dp[n][target] = 0;
        }
        return (notTake | take);
    }

    private static boolean tabulation(int n, int k, int[] arr, boolean[][] dp) {
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        dp[0][arr[0]] = true;

        for(int ind = 1; ind <= k; ind++) {
            for(int target = 1; target <= k; target++) {
                boolean notTake = dp[ind - 1][target];
                boolean take = false;

                if(arr[ind] <= target) {
                    take = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = take | notTake;
            }
        }

        return dp[n - 1][k];
    }

    private static boolean spaceOp(int n, int k, int[] arr) {
        boolean[] prev = new boolean[k + 1];
        boolean[] cur = new boolean[k + 1];

        prev[0] = cur[0] = true;
        prev[arr[0]] = true;

        for(int ind = 1; ind <= n; ind++) {
            for(int target = 1; target <= k; target++) {
                boolean notTake = prev[target];
                boolean take = false;

                if(arr[ind] <= target) {
                    take = prev[target - arr[ind]];
                }

                cur[target] = take | notTake;
            }

            prev = cur;
        }

        return prev[k];
    }
}
