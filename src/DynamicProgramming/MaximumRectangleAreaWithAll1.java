package DynamicProgramming;

import java.util.Stack;

public class MaximumRectangleAreaWithAll1 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        System.out.println(maximalAreaOfSubMatrixOfAll1(arr, 4, 5));
    }

    public static int maximalAreaOfSubMatrixOfAll1(int[][] mat, int n, int m) {
        int[] heights = new int[m];
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) heights[j]++;
                else heights[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangle(heights));
        }

        return maxArea;
    }

    private static int largestRectangle(int[] heights) {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int max = 0;

        for(int i = 1; i < heights.length; i++) {
            while(!s.isEmpty() && heights[i] < heights[s.peek()]) {
                max = Math.max(max, getMax(heights, s, i));
            }
            s.push(i);
        }

        int i = heights.length;
        while(!s.isEmpty()) {
            max = Math.max(max, getMax(heights, s, i));
        }

        return max;
    }

    private static int getMax(int[] heights, Stack<Integer> s, int i) {
        int area = 0;
        int cur = s.pop();

        if(s.isEmpty()) return area = heights[cur] * i;
        else return area = heights[cur] * (i - s.peek() - 1);
    }
}
