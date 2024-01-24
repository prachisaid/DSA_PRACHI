package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 20, 15};
        System.out.println(findKthLargest(arr, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(pq.peek() > nums[i]){
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}
