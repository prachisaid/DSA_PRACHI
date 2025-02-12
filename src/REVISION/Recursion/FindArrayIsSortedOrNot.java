package REVISION.Recursion;

public class FindArrayIsSortedOrNot {
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 6};
		System.out.println(isSorted(arr, 0));
	}

	private static boolean isSorted(int[] arr, int ind) {
		if(ind == arr.length - 1) return true;
//		if(arr[ind] < arr[ind + 1]) {
//			return isSorted(arr, ind + 1);
//		}
//		return false;
		return (arr[ind] < arr[ind + 1]) && isSorted(arr, ind + 1);
	}
}
