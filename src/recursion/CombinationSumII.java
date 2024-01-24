package recursion;

import java.util.*;
import java.util.stream.IntStream;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        System.out.println(combinationSumII(arr, 5));
    }

    static public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper1(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private static void helper(int[] candidates, int target, int index, List<Integer> lst, List<List<Integer>> ans) {
        if(index == candidates.length){
            if(target == 0){
                if(!ans.contains(lst)) {
                    ans.add(new ArrayList<>(lst));
                }
            }
            return;
        }

        if(candidates[index] <= target) {
            lst.add(candidates[index]);
            helper(candidates, target - candidates[index], index+1, lst, ans);
            lst.remove(lst.size()-1);
        }

        helper(candidates, target, index+1, lst, ans);
    }

    private static void helper1(int[] arr, int target, int index, List<Integer> lst, List<List<Integer>> ans) {
        if(target == 0){
            ans.add(new ArrayList<>(lst));
            return;
        }

        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i - 1]){
                continue;
            }

            if(arr[i] > target){
                break;
            }

            lst.add(arr[i]);
            helper1(arr, target - arr[i], index + 1, lst, ans);
            lst.remove(lst.size() - 1);
        }
    }
}
