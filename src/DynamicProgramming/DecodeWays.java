package DynamicProgramming;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "10";
        System.out.println(new DecodeWays().numDecodings(s));
    }

    public int numDecodings(String s) {
//        return recursive(s.length() - 1, s);

        return tabulation(s, s.length());
    }

    private int recursiveDemo(int n, String s) {
        if(n == -1) return 1;
        if(n == 0 && s.charAt(n) - '0' != 0) return 1;
        else if(n == 0 && s.charAt(n) - '0' == 0) return 0;
        if(n < -1) return 0;

        int left = 0;
        if(s.charAt(n) - '0' != 0) {
            left = recursiveDemo(n - 1, s);
        }
        int right = 0;
        if(Integer.parseInt(s.substring(n - 2, n)) <= 26 && s.charAt(n - 1) - '0' != 0) {
            right = recursiveDemo(n - 2, s);
        }

        return left + right;
    }

    private int recursive(int n, String s) {
        if(n == s.length()) return 1;
        if(s.charAt(n) == '0') return 0;

        int takeOne = recursive(n + 1, s);

        if(n + 1 < s.length() && Integer.parseInt(s.substring(n , n + 2)) <= 26) {
            takeOne += recursive(n + 2, s);
        }

        return takeOne;
    }

    private int tabulation(String s, int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            int ways = 0;

            ways = dp[i + 1];

            if(i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                ways += dp[i + 2];
            }

            dp[i] = ways;
        }

        return dp[0];
    }
}
