package SlidingWindow;

import java.util.ArrayList;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        
    }

    static long maximumSumSubarray(int k, ArrayList<Integer> Arr, int N){
        int i = 0, j = 0;
        long maxi = Integer.MIN_VALUE;
        long sum = 0;

        while(j < N) {
            // System.out.println(j);
            sum += Arr.get(j);

            if((j - i + 1) < k) {
                j++;
            }
            else if((j - i + 1) == k) {

                maxi = Math.max(sum, maxi);
                sum -= Arr.get(i);
                i++;
                j++;
            }
        }

        return maxi;
    }
}
