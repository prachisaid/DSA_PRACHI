package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        PartitionArrayForMaxSum obj = new PartitionArrayForMaxSum();
        int[] arr = {1, 15, 7, 9, 2, 5, 10};

//        System.out.println(obj.maxSumAfterPartitioning(arr, 3));
        System.out.println(Math.ceil(2.4));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        // return recursive(0, arr, k);

        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return memoization(0, arr, k, dp);
    }

    private int recursive(int i, int[] arr, int k) {
        if(i == arr.length) return 0;

        int len = 0, maxi = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;

        for(int j  = i; j < Math.min(i + k, arr.length); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len * maxi) + recursive(j + 1, arr, k);
            maxAns = Math.max(sum, maxAns);
        }

        return maxAns;
    }

    private int memoization(int i, int[] arr, int k, int[] dp) {
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];

        int len = 0, maxi = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;

        for(int j  = i; j < Math.min(i + k, arr.length); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len * maxi) + memoization(j + 1, arr, k, dp);
            maxAns = Math.max(sum, maxAns);
        }

        return dp[i] = maxAns;
    }
}
