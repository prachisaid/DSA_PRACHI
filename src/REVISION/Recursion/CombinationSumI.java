package REVISION.Recursion;

import java.util.*;

public class CombinationSumI {
	public static void main(String[] args) {
		int[] arr = {2, 3, 6, 7};
		List<List<Integer>> ans = new ArrayList<>();
		combinationSum(0, 7, arr, ans, new ArrayList<>());
		System.out.println(ans);
	}

	public static void combinationSum(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
		if(ind == arr.length) {
			if(target == 0) ans.add(new ArrayList<>(ds));
			return;
		}

		if(arr[ind] <= target) {
			ds.add(arr[ind]);
			target -= arr[ind];
			combinationSum(ind, target, arr, ans, ds);
			ds.remove(ds.size() - 1);
			target += arr[ind];
		}

		combinationSum(ind + 1, target, arr, ans, ds);
	}

}
