package recursion;

import java.util.Arrays;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 1, 4, 9, 10};
//        arrayChange(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(sorted(arr, 0));
    }

    static void arrayChange(int[] arr){
        arr[2] = 12;
    }
    static boolean sorted(int[] arr, int n){
        if((arr.length)-1 == n){
            return true;
        }

        return ((arr[n] < arr[n+1]) && sorted(arr, ++n));
    }
}
