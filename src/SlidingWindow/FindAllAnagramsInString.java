package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {

    }

    // Could also ask to return the count of the anagrams
    public List<Integer> findAnagrams(String txt, String pat) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        int k = pat.length();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : pat.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int cnt = map.size();

        while (j < txt.length()) {
            if (map.containsKey(txt.charAt(j))) {
                map.put(txt.charAt(j), map.get(txt.charAt(j)) - 1);

                if (map.get(txt.charAt(j)) == 0) {
                    cnt--;
                }
            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (cnt == 0) {
                    ans.add(i);
                }

                if (map.containsKey(txt.charAt(i))) {
                    map.put(txt.charAt(i), map.get(txt.charAt(i)) + 1);

                    if (map.get(txt.charAt(i)) == 1) {
                        cnt++;
                    }
                }

                i++;
                j++;
            }
        }

        return ans;
    }
}
