package recursion;

import java.util.Arrays;

public class ArrayRev {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        arrayRev(arr, 0, arr.length-1);
        arrayRev1(arr, 0);

    }

    static void arrayRev(int [] arr, int i, int j){
        if(i >= j){
            System.out.println(Arrays.toString(arr));
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        arrayRev(arr, i+1, j-1);
    }

    static void arrayRev1(int [] arr, int i){
        if(i >= arr.length / 2){
            System.out.println(Arrays.toString(arr));
            return;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length-i-1];
        arr[arr.length-i-1] = temp;

        arrayRev1(arr, i+1);
    }
}
