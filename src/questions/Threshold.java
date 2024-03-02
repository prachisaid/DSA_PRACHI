package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Threshold {
    public static void main(String[] args) {
        int[] arr = {999999999,999999999,999999999};
        System.out.println(minOperations(arr, 1000000000));
    }

    public static int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int cnt = 0;
        for(long num : nums) {
            pq.add(num);
        }

        while(!pq.isEmpty() && pq.peek() < k) {
            long x = 0;
            long y = 0;
            if(!pq.isEmpty()) {
                x = pq.poll();
            }
            if(!pq.isEmpty()) {
                y = pq.poll();
            }

            pq.add((long) (Math.min(x, y) * 2) + Math.max(x, y));
            cnt++;

        }

        return cnt;
    }
}
