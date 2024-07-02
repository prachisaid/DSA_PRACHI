package REVISION.Recursion;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 4, 5};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int low, int high) {
		if(low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}
	}

	public static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high;

		while(i < j) {
			while(arr[i] <= pivot && i < high) {
				i++;
			}

			while(arr[j] > pivot && j > low) {
				j--;
			}

			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[j];
		arr[j] = arr[low];
		arr[low] = temp;

		return j;
	}
}
