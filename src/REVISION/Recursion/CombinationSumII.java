package REVISION.Recursion;

import java.util.*;

public class CombinationSumII {
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 2};
		List<List<Integer>> ans = new ArrayList<>();
		combinationSum(0, 4, arr, ans, new ArrayList<>());
		System.out.println(ans);
	}

	public static void combinationSum(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
		if(target == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for(int i = ind; i < arr.length; i++) {
			if(i > ind && arr[i] == arr[i - 1]) continue;
			if(arr[i] > target) break;
			ds.add(arr[i]);
			combinationSum(i + 1, target - arr[i], arr, ans, ds);
			ds.remove(ds.size() - 1);
		}
	}
}
