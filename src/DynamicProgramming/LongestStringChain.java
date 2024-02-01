package DynamicProgramming;

import java.util.*;

public class LongestStringChain implements Comparator<String> {
    public static void main(String[] args) {

    }
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        List<String> word = Arrays.asList(words);
        word.sort(new LongestStringChain());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int ind = 0; ind < n; ind++) {
            for(int prev = 0; prev < ind; prev++) {
                if(comp(word.get(ind),word.get(prev)) && dp[ind] < dp[prev] + 1) {
                    dp[ind] = Math.max(dp[ind], dp[prev] + 1);
                }
            }
        }

        int maxi = 0;
        for(int val : dp) {
            maxi = Math.max(val, maxi);
        }
        return maxi;
    }

    private boolean comp (String s, String t) {
        if(s.length() != t.length() + 1) return false;
        int first = 0;
        int second = 0;

        while(first < s.length()) {
            if(second < t.length() && s.charAt(first) == t.charAt(second)) {
                first++;
                second++;
            }
            else {
                first++;
            }
        }

        if(first == s.length() && second == t.length()) return true;
        return false;
    }
}
