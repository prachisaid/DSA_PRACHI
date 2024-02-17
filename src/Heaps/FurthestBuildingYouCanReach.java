package Heaps;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] arr = {4,2,7,6,9,14,12};
        System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(arr, 5, 1));
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);

        int i = 0, diff = 0;
        for (i = 0; i < heights.length - 1; i++) {
            diff = heights[i + 1] - heights[i];

            if (diff <= 0) {
                continue;
            }

            bricks -= diff;
            p.offer(diff);

            if (bricks < 0) {
                bricks += p.poll();
                ladders--;
            }

            if(ladders < 0) {
                break;
            }
        }

        return i;
    }
}
