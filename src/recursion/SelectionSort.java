package recursion;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 8, 1};
        selectionSort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int r, int c, int max){
        if(r == 0){
            return;
        }

        if(c < r){
            if(arr[max] < arr[c]){
                max = c;
            }
            selectionSort(arr, r , c + 1, max);
        }
        else{
            int temp = arr[c-1];
            arr[c-1] = arr[max];
            arr[max] = temp;
            selectionSort(arr, r - 1, 0, 0);
        }
    }
}
