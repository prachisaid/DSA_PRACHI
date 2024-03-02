package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {

    }
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int start = 1;
        int end = stalls[n - 1] - stalls[0];

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(canPlaceCows(stalls, mid, k)) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }

    private static boolean canPlaceCows(int[] arr, int min, int k) {
        int cntCows = 1, last = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - last >= min) {
                cntCows++;
                last = arr[i];
            }
        }

        if(cntCows >= k) return true;
        else return false;
    }
}
