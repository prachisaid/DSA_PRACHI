package DynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(longestBitonicSequence(arr, arr.length));
    }

    public static int longestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);

        for(int ind = 0; ind < n; ind++) {
            for(int prev = 0; prev < ind; prev++) {
                if(arr[ind] > arr[prev] && dp1[ind] < dp1[prev] + 1) {
                    dp1[ind] = dp1[prev] + 1;
                }
            }
        }

        for(int ind = n - 1; ind >= 0; ind--) {
            for(int prev = n - 1; prev > ind; prev--) {
                if(arr[ind] > arr[prev] && dp2[ind] < dp2[prev] + 1) {
                    dp2[ind] = dp2[prev] + 1;
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i] - 1);
        }

        return ans;
    }
}
