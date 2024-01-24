package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    static public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        func(0, nums, lst);
        return lst;
    }

    private static void func(int ind, int[] nums, List<List<Integer>> lst) {
        if(ind == nums.length){
            List<Integer> ans = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                ans.add(nums[i]);
            }

            lst.add(new ArrayList<>(ans));
            return;
        }

        for(int i = ind; i < nums.length; i++){
            int temp = nums[ind];
            nums[ind] = nums[i];
            nums[i] = temp;

            func(ind+1, nums, lst);

            temp = nums[ind];
            nums[ind] = nums[i];
            nums[i] = temp;
        }
    }

}
