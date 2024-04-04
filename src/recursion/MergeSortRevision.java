package recursion;

import java.util.Arrays;

public class MergeSortRevision {
    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 5, 9, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, end, mid);
    }

    private static void merge(int[] arr, int s, int e, int m) {
        int[] ans = new int[e - s + 1];

        int i = s;
        int j = m + 1;
        int k = 0;

        while(i < (m + 1) && j < (e + 1)) {
            if(arr[i] < arr[j]) {
                ans[k] = arr[i];
                i++;
            }
            else{
                ans[k] = arr[j];
                j++;
            }

            k++;
        }

        while(i < (m + 1)) {
            ans[k] = arr[i];
            k++;
            i++;
        }

        while(j < (e + 1)) {
            ans[k] = arr[j];
            k++;
            j++;
        }

        for(int ind = 0; ind < ans.length; ind++) {
            arr[s + ind] = ans[ind];
        }
    }
}
