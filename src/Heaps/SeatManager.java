package Heaps;

import java.util.PriorityQueue;

public class SeatManager {
    public static void main(String[] args) {

    }

    PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            pq.add(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}
