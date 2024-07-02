package REVISION.Recursion;

public class IsArraySorted {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 0};
		System.out.println(sort(0, arr));
	}

	public static boolean sort(int ind, int[] arr) {
		if(ind == arr.length - 1) return true;
		return arr[ind] < arr[ind + 1] && sort(ind + 1, arr);
	}
}
