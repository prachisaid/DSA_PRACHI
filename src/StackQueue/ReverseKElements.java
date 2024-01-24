package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(4);
        queue.add(3);
        queue.add(1);
        queue.add(10);
        queue.add(2);

        System.out.println(reverseElements(queue, 3));

    }

    public static Queue<Integer> reverseElements(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < k; i++){
            stack.push(q.remove());
        }

        for(int i = 0; i < k; i++){
            q.add(stack.pop());
        }

        for(int i = 0; i < q.size()-k; i++){
            q.add(q.remove());
        }
        return q;
    }
}
