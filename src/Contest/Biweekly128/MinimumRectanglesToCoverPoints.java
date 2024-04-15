package Contest.Biweekly128;

import java.util.*;

public class MinimumRectanglesToCoverPoints {
    class Comp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            else{
                return Integer.compare(a[0], b[0]);
            }
        }
    }

    public static void main(String[] args) {

    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, new Comp());

        int rectangles = 0;

        for(int i = 0; i < points.length; i++) {
            // if(i == points.length - 1) rectangles += 1;

            int[] first = points[i];
            int cur = i + 1;

            while(cur < points.length && Math.abs(first[0] - points[cur][0]) <= w) {
                cur += 1;
            }

            rectangles += 1;
            i = cur - 1;
        }

        return rectangles;
    }
}
