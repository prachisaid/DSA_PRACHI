package REVISION.Recursion;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {4, 2, 8, 1, 3, 10, 7, 9, 5, 11};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int s, int e) {
		if(s >= e) return;
		int pivot = partition(arr, s, e);
		quickSort(arr, s, pivot - 1);
		quickSort(arr, pivot + 1, e);
	}

	private static int partition(int[] arr, int s, int e) {
		int pivot = arr[s];
		int cnt = 0;

		for(int i = s + 1; i <= e; i++) {
			if(arr[i] < pivot) cnt++;
		}

		int pivotIndex = s + cnt;
		swap(arr, pivotIndex, s);

		int i = s;
		int j = e;
		while(i < pivotIndex && j > pivotIndex) {
			while(arr[i] < pivot) i++;
			while(arr[j] > pivot) j--;

			if(i < pivotIndex && j > pivotIndex) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}

		return pivotIndex;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
