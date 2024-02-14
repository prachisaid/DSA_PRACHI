package questions;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if(s.isEmpty() || s.length() < t.length()) return "";

        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for(char ch : t.toCharArray()) {
            map[ch]++;
        }

        while(end < s.length()) {
            if(map[s.charAt(end)] > 0) {
                count--;
            }

            map[s.charAt(end)]--;
            end++;

            while(count == 0) {
                if(end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }

                if(map[s.charAt(start)] == 0) {
                    count++;
                }

                map[s.charAt(start)]++;
                start++;
            }
        }

        if(minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, minLen);
    }
    public String minWindow1(String s, String t) {
        if(t.length() > s.length()) return "";
        String ans = "";
        int ansLen = (int) (1e7);
        int i = 0, j = t.length() - 1;

        while(i < s.length() && j < s.length()) {
            String temp = s.substring(i, j + 1);
            if(checkEquals(temp, t)) {
                if(ansLen > temp.length()) {
                    ans = temp;
                    ansLen = ans.length();
                }
                i++;
            }
            else {
                j++;
            }
        }

        return ans;
    }

    private boolean checkEquals(String s, String t) {
        List<Character> sChars = new ArrayList<>();
        for(Character temp : s.toCharArray()) {
            sChars.add(temp);
        }

        boolean usable = !t.isEmpty();

        for(int i = 0; i < t.length() && usable; i++) {
            usable = sChars.remove((Character) t.charAt(i));
        }

        return usable;
    }
}
