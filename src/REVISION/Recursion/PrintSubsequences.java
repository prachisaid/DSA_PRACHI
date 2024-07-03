package REVISION.Recursion;

import java.util.*;

public class PrintSubsequences {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		List<List<Integer>> ans = new ArrayList<>();
		printSubseq(0, arr, ans, new ArrayList<>());
		System.out.println(ans);
	}

	public static void printSubseq(int ind, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
		if(ind == arr.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		ds.add(arr[ind]);
		printSubseq(ind + 1, arr, ans, ds);
		ds.remove(ds.size() - 1);
		printSubseq(ind + 1, arr, ans, ds);
	}
}
