package BinarySearch;

import java.util.HashMap;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        String a = "aabcbbca";
        System.out.println(lastNonEmptyString(a));
    }

    public static String lastNonEmptyString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxi = 0;

        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxi = Math.max(maxi, map.get(ch));
        }

        StringBuilder str = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(map.get(s.charAt(i)) == maxi) {
                str.append(s.charAt(i));
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
        }

        str.reverse();
        return str.toString();
    }
}
