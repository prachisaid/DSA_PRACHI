package recursion;

import java.util.*;
public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr));

        List<List<Integer>> ans = new ArrayList<>();
        recursive(0, arr, k, new ArrayList<>(), ans);

        return ans;
    }

    public void recursive(int ind, int[] arr, int k, List<Integer> lst, List<List<Integer>> ans) {
        if(ind == arr.length) {
            if(lst.size() == k) {
                ans.add(new ArrayList<>(lst));
            }

            return;
        }

        else if(lst.size() == k) {
            ans.add(new ArrayList<>(lst));
            return;
        }

        lst.add(arr[ind]);
        recursive(ind + 1, arr, k, lst, ans);
        lst.remove(lst.size() - 1);
        recursive(ind + 1, arr, k, lst, ans);
    }
}
