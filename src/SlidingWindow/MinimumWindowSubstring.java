package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int len = Integer.MAX_VALUE;
        String ans = "";
        String substr = "";

        for(char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = map.size();

        while(j <  s.length()) {
            ans += s.charAt(j);
            if(map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);

                if(map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }

            if(count > 0) {
                j++;
            }

            else if(count == 0) {
                while(count == 0) {
                    if((j - i + 1) < len) {
                        substr = s.substring(i, j + 1);
                        len = j - i + 1;
                    }

                    if(map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

                        if(map.get(s.charAt(i)) == 1) {
                            count++;
                        }
                    }
                    i++;
                }

                j++;
            }
        }

        System.out.println(len);

        return substr;
    }
}
