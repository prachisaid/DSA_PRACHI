package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    Queue<Integer> first;
    Queue<Integer> second;

    public StackUsingQueues(){
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    public void push(int x){
        first.add(x);
    }

    public int pop(){
        int s1 = first.size();
        for(int i = 0; i < s1-1; i++){
            second.add(first.remove());
        }

        int removed = first.remove();

        int s2 = second.size();
        for(int i = 0; i < s2; i++){
            first.add(second.remove());
        }

        return removed;
    }

    public int top(){
        int s1 = first.size();
        int removed = 0;

        for(int i = 0; i < s1; i++){
            if(i == s1-1){
                removed = first.peek();
            }
            second.add(first.remove());
        }

        int s2 = second.size();
        for(int i = 0; i < s2; i++){
            first.add(second.remove());
        }

        return removed;
    }

    public boolean empty(){
        if(first.isEmpty()){
            return true;
        }

        else{
            return false;
        }
    }
}
