package REVISION.Recursion;

public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = {1, 4, 5, 2, 3,8};
		System.out.println(searchI(arr, 0, 92));
	}

	private static boolean search(int[] arr, int ind, int target) {
		if(ind == arr.length) return false;
		return arr[ind] == target || search(arr, ind + 1, target);
	}

	private static int searchI(int[] arr, int ind, int target) {
		if(ind == arr.length) return -1;
		if(arr[ind] == target) return ind;
		return searchI(arr, ind + 1, target);
	}
}
