package DynamicProgramming;

import java.util.Arrays;

public class KInversePairs {
    public static void main(String[] args) {
        System.out.println(kInversePairs(3, 1));
    }

    public static int kInversePairs(int n, int k) {
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++) arr[i] = i + 1;
//
//        System.out.println(Arrays.toString(arr));
//        return f(0, arr, k);

        int[][] dp = new int[1001][1001];
        dp[0][0] = 1;

        for(int N = 1; N <= n; N++) {
            for(int K = 0; K <= k; K++) {
                for(int i = 0; i <= Math.min(K, N - 1); i++) {
                    if(K - i >= 0) {
                        dp[N][K] = (dp[N][K] + dp[N - 1][K - i]) % 1000000007;
                    }
                }
            }
        }

        return dp[n][k];
    }

    private static int f(int i, int[] arr, int k) {
        if(i >= arr.length - 1) return 0;
        if(k == 0) return 0;

        int ans = 0;
        for(int ind = i; ind <= arr.length - 1; ind++) {
            swap(arr, i, i + 1);
            int take = 1 + f(i + 2, arr, k--);

            swap(arr, i, i + 1);
            int notTake = f(i + 1, arr, k);

            ans = take + notTake;
        }

        return ans;
    }

    private static void swap(int[] arr, int i, int j) {
        if(j >= arr.length) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
