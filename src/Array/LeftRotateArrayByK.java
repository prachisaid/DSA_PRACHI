package Array;

import java.util.ArrayList;

public class LeftRotateArrayByK {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);

        return arr;
    }

    private static void reverse(ArrayList<Integer> arr, int s, int e) {
        // System.out.println(s + " " + e);
        while(s <= e) {
            int temp = arr.get(s);
            arr.set(s, arr.get(e));
            arr.set(e, temp);
            s++;
            e--;
        }
    }
}
