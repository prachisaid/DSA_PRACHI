package Heaps;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    private static long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long ans = 0;

        for(int i = 0; i < n; i++){
            pq.add(arr[i]);
        }

        while(pq.size() != 1){
            long num1 = pq.poll();
            long num2 = pq.poll();

            ans += (num1 + num2);
            pq.add(num1 + num2);
        }


        return ans;
    }
    public static void main(String[] args) {
        long[] arr = {4, 3, 2, 6};

        System.out.println(minCost(arr, 4));
    }
}
