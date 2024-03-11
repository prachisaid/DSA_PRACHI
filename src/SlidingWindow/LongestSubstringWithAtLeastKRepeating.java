package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithAtLeastKRepeating {
    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;

        System.out.println(longestSubstring(s, k));
    }

    public static int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int ans = 0;


        while(j < s.length()) {
            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() == 1 && map.get(ch) < k) {
                j++;
            }

            else if(map.size() == 1 && map.get(ch) >= k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            }

            else if(map.size() > 1) {
                while(map.size() > 1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                    if(map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }

                    i++;
                }

                j++;
            }
        }

        return ans;
    }
}
