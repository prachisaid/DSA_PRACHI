package SlidingWindow;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {9,10,9,-7,-4,-8,2,-6};
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 5)));
    }

    public static int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int ind = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int i = 0, j = 0;

        while(j < n) {
            if(!pq.isEmpty() && pq.peek() > arr[j]) {
                pq.add(arr[j]);
            }
            else if(!pq.isEmpty() && pq.peek() < arr[j]) {
                pq.removeAll(pq);
                pq.add(arr[j]);
            }
            else {
                pq.add(arr[j]);
            }

            if((j - i + 1) < k) {
                j++;
            }

            else if((j - i + 1) == k) {
                if(!pq.isEmpty()) {
                    ans[ind] = pq.peek();
                    ind++;
                }

                if(!pq.isEmpty() && arr[i] == pq.peek()) {
                    pq.remove(arr[i]);
                }

                i++;
                j++;
            }
        }

        return ans;
    }
}
