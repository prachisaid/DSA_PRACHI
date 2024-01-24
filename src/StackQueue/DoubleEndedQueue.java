package StackQueue;

public class DoubleEndedQueue {
    int[] arr;
    int front;
    int rear;
    int size;

    DoubleEndedQueue(int n){
        size = n;
        front = -1;
        rear = -1;
        arr = new int[n];
    }

    boolean pushFront(int x){
        if(isFull()){
            return false;
        }

        else if(isEmpty() && rear != size-1){
            front = rear = 0;
        }

        else if(front == 0){
            front = size - 1;
        }

        else{
            front--;
        }

        arr[front] = x;
        return true;
    }

    boolean pushRear(int x){
        if(isFull()){
            return false;
        }

        else if(isEmpty()){
            front = rear = 0;
        }

        else if(rear == size-1 && front != 0){
            rear = 0;
        }

        else{
            rear++;
        }

        arr[rear] = x;
        return true;
    }

    int popFront(int x){
        if(isEmpty()){
            return -1;
        }

        int ans = arr[front];
        arr[front] = -1;

        if(front == rear){
            front = rear = -1;
        }

        else if(front == size - 1){
            front = 0;
        }

        else{
            front++;
        }

        return ans;
    }

    int popRear(){
        if(isEmpty()){
            return -1;
        }

        int ans = arr[rear];
        arr[rear] = -1;

        if(front == rear){
            front = rear = -1;
        }

        else if(rear == 0){
            rear = size - 1;
        }

        else{
            rear--;
        }

        return ans;
    }

    int getFront(){
        if(isEmpty()){
            return -1;
        }

        return arr[front];
    }

    int getRear(){
        if(isEmpty()){
            return -1;
        }

        return arr[rear];
    }

    boolean isEmpty(){
        if(front == -1){
            return true;
        }
        else{
            return false;
        }
    }

    boolean isFull(){
        if((front == 0 && rear == size-1) || (rear == (front-1)%(size-1))){
            return true;
        }
        else{
            return false;
        }
    }
}
