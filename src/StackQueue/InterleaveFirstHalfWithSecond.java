package StackQueue;

import java.util.Queue;

public class InterleaveFirstHalfWithSecond {
    public static void main(String[] args) {

    }

    public static void interLeaveQueue(Queue< Integer > q) {
        int[] s1 = new int[q.size()/2];
        int[] s2 = new int[q.size() - s1.length];

        for(int i = 0; i < s1.length; i++){
            s1[i] = q.remove();
        }

        for(int i = 0; i < s2.length; i++){
            s2[i] = q.remove();
        }

        int i = 0, j = 0;

        while(i != s1.length && j != s2.length){
            q.add(s1[i]);
            q.add(s2[j]);
            i++;
            j++;
        }
    }
}
