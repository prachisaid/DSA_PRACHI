package REVISION.Recursion;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5};
//		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0);
		System.out.println(Arrays.toString(arr));
	}

	public static void reverse(int[] arr, int i, int j) {
		if(i >= j) {
			return;
		}

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		reverse(arr, i + 1, j - 1);
	}

	public static void reverse(int[] arr, int i) {
		if(i == arr.length / 2) {
			return;
		}

		int temp = arr[i];
		arr[i] = arr[arr.length - i - 1];
		arr[arr.length - i - 1] = temp;
		reverse(arr, i + 1);
	}
}
