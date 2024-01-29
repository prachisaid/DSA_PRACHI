package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NinjasTraining {
    public static void main(String[] args) {
        int[][] points = {
                {2, 1, 3},
                {3, 4, 6},
                {10, 1, 6},
                {8, 3, 7}
        };

        System.out.println(ninjaTraining(4, points));
    }

    public static int ninjaTraining(int n, int[][] points) {
//        return recursive(n - 1, 3, points);
        int[][] dp = new int[n][4];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return (memoization(n - 1, 3, points, dp));
//        return tabulation(n, points, dp);
    }

    private static int recursive(int day, int last, int[][] points) {
//        if(day == 0) {
//            int maxi = 0;
//
//            for(int i = 0; i < 3; i++) {
//                if(i != last) maxi = Math.max(maxi, points[day][i]);
//            }
//
//            return maxi;
//        }

        if(day < 0) return 0;

        int maxi = 0;

        for (int i = 0; i < 3; i++) {
            int point = 0;
            if (i != last) {
                point = points[day][i] + recursive(day - 1, i, points);
            }

            maxi = Math.max(maxi, point);
        }

        return maxi;
    }

    private static int memoization(int day, int last, int[][] points, int[][] dp) {
        if(day == 0) {
            int maxi = 0;

            for(int i = 0; i < 3; i++) {
                if(i != last) maxi = Math.max(maxi, points[day][i]);
            }

            return maxi;
        }

        if(dp[day][last] != -1) return dp[day][last];
        int maxi = 0;

        for (int i = 0; i < 3; i++) {
            int point = 0;
            if (i != last) {
                point = points[day][i] + memoization(day - 1, i, points, dp);
            }

            maxi = Math.max(maxi, point);
        }

        dp[day][last] = maxi;
        return maxi;
    }

    private static int tabulation(int n, int[][] points, int[][] dp) {
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], points[0][1]);

        for(int day = 1; day < n; day++) {
            for(int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                int maxi = 0;

                for(int task = 0; task < 3; task++) {
                    if(last != task) {
                        int point = points[day][task] + dp[day - 1][task];
                        maxi = Math.max(maxi, point);
                    }
                }

                dp[day][last] = maxi;
            }
        }

        return dp[n - 1][3];
    }
}
