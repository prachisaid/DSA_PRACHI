package DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplicationMCM {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(matrixMultiplication(arr, arr.length));
    }

    public static int matrixMultiplication(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int[] temp : dp) Arrays.fill(temp, -1);
//        return recursive(1, N - 1, arr);

//        return memoization(1, N-1, arr, dp);

        return tabulation(arr, N);
    }

    private static int recursive(int i, int j, int[] arr) {
        if(i == j) return 0;

        int mini = (int) 1e9;

        for(int k = i; k <= j - 1; k++){
            int steps = arr[i - 1] * arr[k] * arr[j] + recursive(i, k, arr) + recursive(k + 1, j, arr);
            mini = Math.min(mini, steps);
        }

        return mini;
    }

    private static int memoization(int i, int j, int[] arr, int[][] dp) {
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int mini = (int) 1e9;

        for(int k = i; k <= j - 1; k++){
            int steps = arr[i - 1] * arr[k] * arr[j] + memoization(i, k, arr, dp) + memoization(k + 1, j, arr, dp);
            mini = Math.min(mini, steps);
        }

        return dp[i][j] = mini;
    }

    private static int tabulation(int[] arr, int N) {
        int[][] dp = new int[N][N];

        for(int i = 0; i < N; i++) dp[i][i] = 0;

        for(int i = N - 1; i > 0; i--) {
            for(int j = i + 1; j < N; j++) {
                int mini = (int) 1e9;
                for(int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(mini, steps);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][N-1];
    }
}
