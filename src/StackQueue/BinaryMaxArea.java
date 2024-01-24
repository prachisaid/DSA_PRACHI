package StackQueue;

import java.util.Stack;

public class BinaryMaxArea {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0},
                    {1, 1, 1, 1},
                    {1, 1, 1, 1},
                    {1, 1, 0, 0}};

        System.out.println();
        BinaryMaxArea ba = new BinaryMaxArea();
        System.out.println(ba.maxArea(M, M.length, M[0].length));
    }

    public int maxArea(int M[][], int n, int m) {
        //compute area for first row
        int area = largestRectangleArea(M[0], n );

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(M[i][j] != 0){
                    M[i][j] = M[i-1][j] + M[i][j];
                }
            }

            area = Math.max(area, largestRectangleArea(M[i], n));
        }

        return area;
    }

    public int largestRectangleArea(int[] heights, int size) {
//        int size = heights.length;

        int[] next = new int[size];
        next = nextSmallerElement(heights, size);

        int[] prev = new int[size];
        prev = prevSmallerElement(heights, size);
        int area = Integer.MIN_VALUE;

        for(int i = 0; i < size; i++){
            int l = heights[i];
            if(next[i] == -1){
                next[i] = size;
            }
            int w = next[i] - prev[i] - 1;
//            System.out.println(prev[i]);

            int newArea = l * w;
            area = Math.max(area, newArea);
        }

        return area;
    }

    private int[] nextSmallerElement(int[] arr, int n){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] lst = new int[n];

        for(int i = n-1; i >= 0; i--){
            int curr = arr[i];
            //we can't check for -1 index soo stack.peek() != -1
            while(stack.peek() != -1 && arr[stack.peek()] >= curr){
                stack.pop();
            }

            lst[i] = stack.peek();
            stack.push(i);
        }

        return lst;
    }

    private int[] prevSmallerElement(int[] arr, int n){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] lst = new int[n];

        for(int i = 0; i < n; i++){
            int curr = arr[i];
            while(stack.peek() != -1 && arr[stack.peek()] >= curr){
                stack.pop();
            }

            lst[i] = stack.peek();
            stack.push(i);
        }

        return lst;
    }
}
