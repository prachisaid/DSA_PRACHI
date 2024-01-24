package DynamicProgramming;

import java.util.Arrays;

public class CountPartitionWithDifference {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        System.out.println(countPartitions(4, 3, arr));
    }

    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for(int a : arr) totalSum += a;

        if((totalSum - d < 0) || ((totalSum - d) % 2) == 1) return 0;

        int target = (totalSum - d) / 2;
        int[][] dp = new int[n][target + 1];
        for(int[] temp : dp) Arrays.fill(temp, 0);
//        return memoization(n - 1, target, arr, dp);
        return tabulation(target, arr, dp);
    }

    private static int memoization(int ind, int sum, int[] arr, int[][] dp) {
        if(ind == 0) {
            if(sum == 0 && arr[0] == 0) return 2;
            if(sum == 0 || sum == arr[0]) return 1;
            return 0;
        }

        if(dp[ind][sum] != -1) return dp[ind][sum];

        int notPick = memoization(ind - 1, sum, arr, dp);
        int pick = 0;

        if(arr[ind] <= sum) pick = memoization(ind - 1, sum - arr[ind], arr, dp);

        return dp[ind][sum] = notPick + pick;
    }

    private static int tabulation(int target, int[] arr, int[][] dp) {
        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1;

        for(int ind = 1; ind <= arr.length - 1; ind++) {
            for(int sum = 1; sum <= target; sum++) {
                int notPick = dp[ind - 1][sum];
                int pick = 0;

                if(arr[ind] <= sum) pick = dp[ind - 1][sum - arr[ind]];

                dp[ind][sum] = pick + notPick;
            }
        }

        return dp[arr.length - 1][target];
    }
}
