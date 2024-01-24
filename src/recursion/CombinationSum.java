package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        System.out.println(combinationSum(arr, 7));
    }

    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void helper(int[] candidates, int target, int index, List<Integer> lst, List<List<Integer>> ans) {
        if(index == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(lst));
            }
            return;
        }

        if(candidates[index] <= target) {
            lst.add(candidates[index]);
            helper(candidates, target - candidates[index], index, lst, ans);
            lst.remove(lst.size()-1);
        }

        helper(candidates, target, index+1, lst, ans);
    }
}
