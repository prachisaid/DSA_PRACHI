package StackQueue;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStacks(){
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x){
        first.push(x);
    }

    public int pop(){
        int firstSize = first.size();
        for (int i = 0; i < firstSize; i++){
            System.out.println(i);
            second.push(first.pop());
        }

        int removed = second.pop();
        int secondSize = second.size();
        for (int i = 0; i < secondSize; i++){
            first.push(second.pop());
        }

        System.out.println(first);
        return removed;
    }

    public int peek(){
        int firstSize = first.size();
        for (int i = 0; i < firstSize; i++){
            System.out.println(i);
            second.push(first.pop());
        }

        int removed = second.peek();
        int secondSize = second.size();
        for (int i = 0; i < secondSize; i++){
            first.push(second.pop());
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
