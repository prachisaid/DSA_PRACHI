package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
	public static void main(String[] args) {
		int[] arr = {3, 1, 2};
		func(0, arr, new ArrayList<>());
	}

	private static void func(int ind, int[] arr, List<Integer> ans) {
		if(ind >= arr.length) {
			System.out.println(ans);
			return;
		}

		ans.add(arr[ind]);
		func(ind + 1, arr, ans);
		ans.remove(ans.size() - 1);
		func(ind + 1, arr, ans);
	}
}
