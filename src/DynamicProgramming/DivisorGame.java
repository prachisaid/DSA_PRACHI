package DynamicProgramming;

import java.util.Arrays;

public class DivisorGame {
    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(3));
    }

    public boolean divisorGame(int n) {
        // return recursive(n);

        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);

        // return memoization(n, dp);

        return tabulation(n);
    }

    // gives TLE due to exponential time complexity
    private boolean recursive(int n) {
        if(n == 1) return false;

        for(int x = 1; x < n; x++) {
            // check for the condition if n is divisible by x
            if(n % x == 0) {
                // this means we can take this number and divide and then pass the turn to another player
                // here check if by taking this number can we win
                if(!recursive(n - x)) {
                    // we check that by seeing if the next player looses
                    return true;
                }
            }
        }

        // in the end return false;
        return false;
    }

    // gives TLE as well
    private boolean memoization(int n, int[] dp) {
        if(n == 1) return false;

        if(dp[n] != -1) {
            if(dp[n] == 0) return true;
            else return false;
        }

        for(int x = 1; x < n; x++) {
            if(n % x == 0) {
                if(!recursive(n - x)) {
                    dp[n] = 0;
                    return true;
                }
            }
        }

        dp[n] = 1;
        return false;
    }

    private boolean tabulation(int n) {
        boolean[] dp = new boolean[n + 1];
        Arrays.fill(dp, false);

        // as we know n == 1 will always be false because if n = 1 then we cannot divide
        // it further because of the condition 0 < x < n
        dp[1] = false;

        // checking the winner or looser for each value from 2 to n
        for(int i = 2; i <= n; i++) {
            for(int x = 1; x < i; x++) {
                // if its divisible then only check for future players
                if(i % x == 0) {
                    // for the current player what's the win situation
                    if(!dp[i - x]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
