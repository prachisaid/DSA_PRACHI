package REVISION.Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSumI {
	public static void main(String[] args) {
		int[] arr = {3, 1, 2};
		List<Integer> ans = new ArrayList<>();
		subsetSum(0, 0, arr, ans);
		Collections.sort(ans);
		System.out.println(ans);
	}

	public static void subsetSum(int ind, int sum, int[] arr, List<Integer> ans) {
		if(ind == arr.length) {
			ans.add(sum);
			return;
		}

		subsetSum(ind + 1, sum + arr[ind], arr, ans);
		subsetSum(ind + 1, sum, arr, ans);
	}
}
