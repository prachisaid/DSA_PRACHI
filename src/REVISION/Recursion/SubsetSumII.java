package REVISION.Recursion;

import java.util.*;

public class SubsetSumII {
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 2};
		List<List<Integer>> ans = new ArrayList<>();
		subsetSum(0, arr, ans, new ArrayList<>());
		System.out.println(ans);
	}

	public static void subsetSum(int ind, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
		ans.add(new ArrayList<>(ds));

		for(int i = ind; i < arr.length; i++) {
			if(i != ind && arr[i] == arr[i - 1]) continue;
			ds.add(arr[i]);
			subsetSum(i + 1, arr, ans, ds);
			ds.remove(ds.size() - 1);
		}
	}
}
