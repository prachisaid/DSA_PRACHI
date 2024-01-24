package StackQueue;

import java.util.Arrays;

public class DoubleQueueMain {
    public static void main(String[] args) {
        DoubleEndedQueue dq = new DoubleEndedQueue(5);

        System.out.println(dq.isEmpty());
        System.out.println(dq.pushFront(10));
        System.out.println(dq.pushFront(20));
        System.out.println(dq.pushRear(30));
        System.out.println(Arrays.toString(dq.arr));
    }
}
