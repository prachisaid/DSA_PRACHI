package Heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class PQueue {
    static class Pair{
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1.a, pair2.a));

//        queue.add(70);
//        queue.add(70);
//        queue.add(55);
//        queue.add(45);
//        queue.add(50);
//        queue.add(65);

        queue.add(new Pair(12, 22));
        queue.add(new Pair(10, 23));
        queue.add(new Pair(9, 23));

        System.out.println(queue.peek().a);
    }
}
