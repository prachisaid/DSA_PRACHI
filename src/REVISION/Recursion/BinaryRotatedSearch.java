package REVISION.Recursion;

public class BinaryRotatedSearch {
	public static void main(String[] args) {
		int[] arr = {3, 6, 7, 8, 9, 1, 2, 3};
		System.out.println(search(arr, 0, arr.length - 1, 9));
	}

	private static int search(int[] arr, int s, int e, int target) {
		if(s > e) return -1;

		int m = s + (e - s) / 2;

		if(arr[m] == target) return m;

		if(arr[s] <= arr[m]) {
			if(arr[s] <= target && arr[m] >= target) {
				return search(arr, s, m - 1, target);
			}
			else {
				return search(arr, m + 1, e, target);
			}
		}
		else if(target >= arr[m] && target <= arr[e]) {
			return search(arr, m + 1, e, target);
		}
		else {
			return search(arr, s, m - 1, target);
		}
	}
}
