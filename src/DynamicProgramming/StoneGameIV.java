package DynamicProgramming;

import java.util.Arrays;

public class StoneGameIV {
    public static void main(String[] args) {
        System.out.println(new StoneGameIV().tabulation(74497));
    }

    private boolean tabulation(int ind) {
        boolean[] dp = new boolean[ind + 1];
        dp[1] = true;
        for(int n = 2; n <= ind; n++) {
            for(int i = 1; i * i <= n; i++) {
                int square = i * i;
                if(square <= n) {
                    if(n - square < dp.length && n - square >= 0 && !dp[n - square]) {
                        dp[n] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[ind];
    }
}
