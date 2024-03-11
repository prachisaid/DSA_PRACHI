package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithRepeatingChars {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int len = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while(j < s.length()) {
            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.size() == (j - i + 1)) {
                len = Math.max(len, (j - i + 1));
                j++;
            }

            else if(map.size() < (j - i + 1)) {
                while(map.size() < (j - i + 1)) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);

                    if(map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }

                    i++;
                }

                j++;
            }
        }

        return len;
    }
}
