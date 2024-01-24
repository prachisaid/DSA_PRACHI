package Heaps;

import java.util.Arrays;

public class MergeHeaps {
    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int[] arr = new int[n + m];
        int ind = 0;

        for (int k : a) {
            arr[ind] = k;
            ind++;
        }

        for (int j : b) {
            arr[ind] = j;
            ind++;
        }

        int n1 = arr.length;
        for(int i = n1/2 - 1; i >= 0; i--){
            heapify(arr, n1, i);
        }

        return arr;
    }

    public static void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[largest] < arr[left]){
            largest = left;
        }

        if(right < n && arr[largest] < arr[right]){
            largest = right;
        }

        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n , largest);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};

        System.out.println(Arrays.toString(mergeHeaps(a, b, 4, 3)));
    }
}
