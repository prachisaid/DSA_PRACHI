package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
	public static boolean search(int ind, int[] arr, int target) {
		if(ind >= arr.length) return false;
		if(arr[ind] == target) return true;

		return search(ind + 1, arr, target);
	}

	public static int findIndex(int ind, int[] arr, int target) {
		if(ind >= arr.length) return -1;
		if(arr[ind] == target) return ind;

		return findIndex(ind + 1, arr, target);
	}

	public static List<Integer> findIndexesI(int ind, int[] arr, int target) {
		List<Integer> lst = new ArrayList<>();
		if(ind == arr.length) return lst;

		if(arr[ind] == target) lst.add(ind);
		lst.addAll(findIndexesI(ind + 1, arr, target));
		return lst;
	}

	public static void findIndexesII(int ind, int[] arr, int target, List<Integer> lst) {
		if(ind == arr.length) return;

		if(arr[ind] == target) lst.add(ind);
		findIndexesII(ind + 1, arr, target, lst);
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 4, 5};
//		System.out.println(search(0, arr, 9));
//		System.out.println(findIndex(0, arr, 4));
//		System.out.println(findIndexesI(0, arr, 4));
		List<Integer> lst = new ArrayList<>();
		findIndexesII(0, arr, 4, lst);
		System.out.println(lst);
	}
}
