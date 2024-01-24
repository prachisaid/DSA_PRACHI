package StackQueue;

import java.util.Stack;

public class DeleteMiddleStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
//        83 74 67 49 94 8 11 1
        stack.push(83);
        stack.push(74);
        stack.push(67);
        stack.push(49);
        stack.push(94);
        stack.push(8);
        stack.push(11);
        stack.push(1);


        deleteMiddle(stack, 8);
        System.out.println(stack);
    }

    public static void deleteMiddle(Stack<Integer> inputStack, int N) {
        int count = 0;
        solve(inputStack, count, N);
    }

    private static void solve(Stack<Integer> inputStack, int count, int n) {
        if(count == n/2){
            inputStack.pop();
            return;
        }

        int removed = inputStack.peek();
        inputStack.pop();
        solve(inputStack, ++count, n);
        inputStack.push(removed);
    }
}
