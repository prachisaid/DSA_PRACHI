package recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        boolean[] ans = new boolean[nums.length];
        func(nums, new ArrayList<>(), lst, ans);
        return lst;
    }

    static private void func(int[] nums, ArrayList<Integer> anslist, List<List<Integer>> lst, boolean[] ans) {
        if(anslist.size() == nums.length){
            lst.add(new ArrayList<>(anslist));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!ans[i]){
                ans[i] = true;
                anslist.add(nums[i]);
                func(nums, anslist, lst, ans);
                ans[i] = false;
                anslist.remove(anslist.size()-1);
            }
        }
    }
}
