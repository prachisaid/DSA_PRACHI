package REVISION.Recursion;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {4, 2, 8, 1, 3, 10, 7};
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int s, int e) {
		if(s >= e) return;

		int mid = s + (e - s) / 2;
		mergeSort(arr, s, mid);
		mergeSort(arr, mid + 1, e);

		merge(arr, s, mid, e);
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int[] ans = new int[end - start + 1];

		int i = start;
		int j = mid + 1;
		int ind = 0;

		while(i <= mid && j <= end) {
			if(arr[i] < arr[j]) {
				ans[ind++] = arr[i++];
			}
			else if(arr[j] < arr[i]) {
				ans[ind++] = arr[j++];
			}
		}

		while(i <= mid) {
			ans[ind++] = arr[i++];
		}

		while(j <= end) {
			ans[ind++] = arr[j++];
		}

		ind = 0;
		for(int s = start; s <= end; s++) {
			arr[s] = ans[ind++];
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
