package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequencesWithSum {
	public static void main(String[] args) {
		int[] arr = {1, 2, 1};
		List<List<Integer>> ans = new ArrayList<>();
		printSubseq(0, 2, arr, ans, new ArrayList<>());
		System.out.println(ans);
	}

	public static void printSubseq(int ind, int sum, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
		if(ind == arr.length) {
			if(sum == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		if(arr[ind] <= sum) {
			ds.add(arr[ind]);
			sum -= arr[ind];
			printSubseq(ind + 1, sum, arr, ans, ds);
			ds.remove(ds.size() - 1);
			sum += arr[ind];
		}

		printSubseq(ind + 1, sum, arr, ans, ds);
	}
}
