package REVISION.Recursion;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {6, 2, 1, 3, 4};
		sort(arr, arr.length - 1, 0);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int row, int ind) {
		if(row == 0) return;

		if(ind < row) {
			if(arr[ind] > arr[ind + 1]) {
				int temp = arr[ind];
				arr[ind] = arr[ind + 1];
				arr[ind + 1] = temp;
			}
			sort(arr, row, ind + 1);
		}
		else {
			sort(arr, row - 1, 0);
		}
	}
}
