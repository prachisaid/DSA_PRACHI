package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAnagram {
    public static void main(String[] args) {

    }

    public List<String> removeAnagrams(String[] strs) {
        List<String> ans = new ArrayList<>();

        int n = strs.length;

        for(int i = 0; i < n;) {
            int j = i + 1;

            while(j < n && comp(strs[i], strs[j])) {
                j++;
            }

            ans.add(strs[i]);
            i = j;
        }

        return ans;
    }

    private boolean comp(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        if(Arrays.equals(s1, t1)) return true;
        else return false;
    }
}
