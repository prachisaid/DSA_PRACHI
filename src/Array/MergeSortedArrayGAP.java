package Array;

import java.util.Arrays;

public class MergeSortedArrayGAP {
    public static void main(String[] args) {
        long[] a = {1, 3, 5, 7};
        long[] b = {0, 2, 6, 8, 9};

        mergeTwoSortedArraysWithoutExtraSpace(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        int n = a.length;
        int m = b.length;
        int len = (n + m);

        int gap = (len / 2) + (len % 2);

        while(gap > 0) {
            int left = 0;
            int right = left + gap;

            while(right < len) {
                //arr1 and arr2
                if(left < n && right >= n) {
                    swapIfGreater(a, b, left, (right - n));
                }

                //arr2 and arr2
                else if(left >= n) {
                    swapIfGreater(b, b, (left - n), (right - n));
                }

                //arr1 and arr1
                else {
                    swapIfGreater(a, a, left, right);
                }

                left++;
                right++;
            }

            if(gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void swapIfGreater(long []a, long []b, int ind1, int ind2) {
        if(a[ind1] > b[ind2]) {
            long temp = a[ind1];
            a[ind1] = b[ind2];
            b[ind2] = temp;
        }
    }
}
