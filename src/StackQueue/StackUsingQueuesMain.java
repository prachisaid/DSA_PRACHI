package StackQueue;

public class StackUsingQueuesMain {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(12);

//        System.out.println(stack.pop());
//
//        stack.push(13);
//
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.empty());

        System.out.println(stack.top());
    }
}
