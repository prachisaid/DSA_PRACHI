package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSumII {
    public static void main(String[] args) {
        int [] arr = {1, 2, 2};
        System.out.println(subsetsWithDup(arr));
    }

    static public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lst = new ArrayList<>();
        func(0, nums, new ArrayList<>(), lst);
        return lst;
    }

    static private void func(int ind, int[] nums, List<Integer> ans, List<List<Integer>> lst) {
        lst.add(new ArrayList<>(ans));

        for(int i = ind; i < nums.length; i++){
            if(i != ind && nums[i] == nums[i-1]){
                continue;
            }

            ans.add(nums[i]);
            func(i+1, nums, ans, lst);
            ans.remove(ans.size()-1);
        }
    }


}
