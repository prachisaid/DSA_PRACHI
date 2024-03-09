package Array;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 5},
                {1, 2},
                {2, 5},
                {2, 4}
        };

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for(int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }
}
