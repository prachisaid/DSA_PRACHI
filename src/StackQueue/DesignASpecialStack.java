package StackQueue;

import java.util.Stack;

public class DesignASpecialStack {

    Stack<Integer> stack = new Stack<>();
    int min;
    public static void main(String[] args) {
        DesignASpecialStack obj = new DesignASpecialStack();

        obj.push(5);
        obj.push(3);
        obj.push(8);
        obj.push(2);
        obj.push(4);
        System.out.println(obj.getMin());
        System.out.println(obj.stack);
    }

    public void push(int data) {
        if(stack.isEmpty()) {
            stack.push(data);
            min = data;
        }

        else {
            if(data < min) {
                int val = 2 * data - min;
                stack.push(val);
                min = Math.min(min, data);
            }
            else{
                stack.push(data);
            }
        }
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        }

        int curr = stack.pop();

        if(curr > min) {
            return curr;
        }
        else{
            int prevMin = min;
            int val = 2 * min - curr;
            min = val;
            return prevMin;
        }
    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }

        int cur = stack.peek();

        if(cur < min) {
            return min;
        }
        else{
            return cur;
        }
    }

    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }

        return min;
    }
}
