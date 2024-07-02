package REVISION.Recursion;

import java.util.Arrays;

public class MergeSortInPlace {
	public static void main(String[] args) {
		int[] arr = {2, 8, 5, 3};
		merge(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void merge(int[] arr, int start, int end) {
		if(start >= end) return;

		int mid = start + (end - start) / 2;
		merge(arr, start, mid);
		merge(arr, mid + 1, end);
		mergeSort(arr, start, end, mid);
	}

	public static void mergeSort(int[] arr, int start, int end, int mid) {
		int[] ans = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;

		while(i <= mid && j <= end) {
			if(arr[i] < arr[j]) {
				ans[k++] = arr[i++];
			}
			else {
				ans[k++] = arr[j++];
			}
		}

		while(i <= mid) {
			ans[k++] = arr[i++];
		}

		while(j <= end) {
			ans[k++] = arr[j++];
		}

		for(int x = 0; x < ans.length; x++) {
			arr[start + x] = ans[x];
		}
	}
}
