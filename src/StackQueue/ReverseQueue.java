package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(4);
        queue.add(3);
        queue.add(1);
        queue.add(10);
        queue.add(2);
        queue.add(6);

        reverse(queue);
        System.out.println(queue);
    }

    public static void reverse(Queue< Integer > q) {
        if(q.isEmpty()){
            return;
        }

        int removed = q.remove();
        reverse(q);
        q.add(removed);
    }
}
