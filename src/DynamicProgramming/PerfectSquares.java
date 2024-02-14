package DynamicProgramming;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }

    public int numSquares(int n) {
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);

        // return recursive(n);

        // return memoization(n, dp);

        return tabulation(n);
    }

    private int recursive(int n) {
        if(n == 0) return 0;
        if(n < 0) return Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + recursive(n - (i * i)));
        }

        return ans;
    }

    private int memoization(int n, int[] dp) {
        if(n == 0) return 0;
        if(n < 0) return Integer.MAX_VALUE;
        if(dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i * i <= n; i++) {
            ans = Math.min(ans, 1 + memoization(n - (i * i), dp));
        }

        return dp[n] = ans;
    }

    private int tabulation(int ind) {
        int[] dp = new int[ind + 1];

        for(int n = 1; n <= ind; n++) {
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i * i <= n; i++) {
                if(n - (i * i) < 0) continue;
                ans = Math.min(ans, 1 + dp[n - (i * i)]);
            }

            dp[n] = ans;
        }

        return dp[ind];
    }
}
