package StackQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterLeaveQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);


        interLeaveQueue1(queue);
        System.out.println(queue);
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

    public static void interLeaveQueue1(Queue<Integer> q){
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int n = q.size()/2;

        while(q.size() != n){
            st.push(q.remove());
        }

        int stn = st.size();
        while(!st.isEmpty()){
            st2.push(st.pop());
        }

        while(!st2.isEmpty()){
            int val = st2.peek();
            st2.pop();
            q.add(val);

            int val2 = q.peek();
            q.remove();
            q.add(val2);

        }
    }
}
