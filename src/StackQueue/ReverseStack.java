package StackQueue;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(83);
        stack.push(74);
        stack.push(67);
        stack.push(49);
        stack.push(94);
        reverseStack(stack);
        System.out.println(stack);

    }

    public static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }

        int num = stack.peek();

        stack.pop();
        reverseStack(stack);
        solve(stack, num);
    }

    public static void solve(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }

        int num = stack.peek();
        stack.pop();

        solve(stack, x);
        stack.push(num);
    }
}


