package questions;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] str = {"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};
        System.out.println(new GroupAnagram().groupAnagrams(str));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        int[] arr = new int[strs.length];

        for(int i = 0; i < strs.length; i++) {
            List<String> temp = new ArrayList<>();
            for(int j = i; j < strs.length; j++) {
                if(comp(strs[i], strs[j])) {
                    if(arr[j] == 0) {
                        temp.add(strs[j]);
                        arr[j] = 1;
                    }
                }
            }

            if(!temp.isEmpty()) ans.add(temp);
        }

        return ans;
    }

    private boolean comp(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        if (Arrays.equals(s1, t1)) return true;
        else return false;
    }

    public List<List<String>> groupAnagrams1(String[] words) {
            // Map to store anagram groups
        Map<String, List<String>> anagramGroups = new HashMap<>();

            // Iterate through each word in the input array
        for (String word : words) {
            // Sort the characters in the word to create a key
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // If key is not in the map, add a new entry with the word as a list
            if (!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>(List.of(word)));
            }
            // If key is already present, append the word to the existing list
            else {
                anagramGroups.get(key).add(word);
            }
        }

        // Convert map values to a list and return
        return new ArrayList<>(anagramGroups.values());
    }
}
