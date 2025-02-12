package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchAllIndexes {
	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<>();
		int[] arr = {1, 4, 2, 5, 2, 4, 2};
		find(arr, 0, 2, lst);
		System.out.println(func(arr, 0, 2));
		System.out.println(lst);
	}

	private static void find(int[] arr, int ind, int target, List<Integer> lst) {
		if(ind == arr.length) return;

		if(arr[ind] == target) lst.add(ind);

		find(arr, ind + 1, target, lst);
	}

	private static List<Integer> func(int[] arr, int ind, int target) {
		List<Integer> lst = new ArrayList<>();

		if(ind == arr.length) return lst;
		if(arr[ind] == target) lst.add(ind);

		lst.addAll(func(arr, ind + 1, target));

		return lst;
	}
}
