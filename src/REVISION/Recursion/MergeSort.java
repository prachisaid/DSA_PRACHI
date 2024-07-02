package REVISION.Recursion;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = {2, 8, 5, 3};
		System.out.println(Arrays.toString(mergeSort(arr)));
	}

	public static int[] mergeSort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}

		int mid = arr.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

		return merge(left, right);
	}

	public static int[] merge(int[] a1, int[] a2) {
		int[] arr = new int[a1.length + a2.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < a1.length && j < a2.length) {
			if(a1[i] < a2[j]) {
				arr[k++] = a1[i++];
			}
			else {
				arr[k++] = a2[j++];
			}
		}

		while(i < a1.length) {
			arr[k++] = a1[i++];
		}

		while(j < a2.length) {
			arr[k++] = a2[j++];
		}

		return arr;
	}
}
