package StackQueue;

import java.util.Stack;

public class CelebrityOptimal {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 0},
                {0, 0, 0},
                {0, 1, 0}};

        System.out.println(celebrity(M, M.length));
    }

    static int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            stack.push(i);
        }

        while(stack.size() > 1){
            int a = stack.peek();
            stack.pop();

            int b = stack.peek();
            stack.pop();

            if(knows(M, a, b)){
                stack.push(b);
            }else{
                stack.push(a);
            }
        }

        int ans = stack.peek();

        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            if(M[ans][i] == 0){
                zeroCount++;
            }
        }

        if(zeroCount != n){
            return -1;
        }

        int oneCount = 0;

        for (int i = 0; i < n; i++) {
            if(M[i][ans] == 1){
                oneCount++;
            }
        }

        if(oneCount != n-1){
            return -1;
        }

        return ans;
    }

    static private boolean knows(int[][] m, int a, int b) {
        if(m[a][b] == 1){
            return true;
        }

        return false;
    }
}
