package Array;

import java.util.Arrays;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotateArray(arr, arr.length)));
    }

    static int[] rotateArray(int[] arr, int n) {
        int elem = arr[0];
        for(int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        arr[n - 1] = elem;

        return arr;
    }
}
