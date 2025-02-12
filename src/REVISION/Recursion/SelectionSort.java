package REVISION.Recursion;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {4, 2, 8, 1, 3, 10, 7, 5, 4};
		sort(arr, arr.length - 1, 0, 0);
		System.out.println(Arrays.toString(arr));
	}

	private static void sort(int[] arr, int row, int col, int max) {
		if(row == 0) return;

		if(col <= row) {
			if(arr[col] > arr[max]) {
				max = col;
			}

			sort(arr, row, col + 1, max);
		}
		else {
			int temp = arr[row];
			arr[row] = arr[max];
			arr[max] = temp;

			sort(arr, row - 1, 0, 0);
		}
	}
}
