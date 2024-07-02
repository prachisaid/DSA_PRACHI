package REVISION.Recursion;

public class RotatedBinarySearch {
	public static int rotatedSearch(int[] arr, int target) {
		return helper(0, arr.length - 1, arr, target);
	}

	public static int helper(int start, int end, int[] arr, int target) {
		if(start > end) return -1;

		int mid = start + (end - start) / 2;

		if(arr[mid] == target) return mid;

		if(arr[start] <= arr[mid]) {
			if(target >= arr[start] && target <= arr[mid]) {
				return helper(start, mid - 1, arr, target);
			}
			else {
				return helper(mid + 1, end, arr, target);
			}
		}
		else {
			if(target >= arr[mid] && target <= arr[end]) {
				return helper(mid + 1, end, arr, target);
			}
			else {
				return helper(start, mid - 1, arr, target);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
		System.out.println(rotatedSearch(arr, 9));
	}
}
