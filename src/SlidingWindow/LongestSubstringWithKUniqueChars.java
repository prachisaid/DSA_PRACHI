package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKUniqueChars {
    public static void main(String[] args) {

    }

    public int longestkSubstr(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int n = s.length();
        int len = Integer.MIN_VALUE;

        while(j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j) , 0) + 1);

            if(map.size() < k) {
                j++;
            }

            else if(map.size() == k) {
                len = Math.max(len, j - i + 1);
                j++;
            }

            else if(map.size() > k) {
                while(map.size() > k) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                    if(map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }

                    i++;
                }

                j++;
            }
        }

        return (len < 0) ? -1 : len;
    }
}
