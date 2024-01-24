package StackQueue;

import java.util.*;

public class InBuiltExamples {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(34);
        stack.push(32);
        stack.push(45);
        stack.push(2);
        stack.push(9);

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(8);
        queue.add(9);
        queue.add(7);
        queue.add(10);

//        System.out.println(queue.remove());
//        System.out.println(queue.remove());


        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(89);
        deque.addLast(78);
        deque.addFirst(69);

        deque.removeLast();
        System.out.println(deque);
    }
}
