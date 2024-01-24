package StackQueue;
public class TwoStack {

    int[] arr;
    int top1, top2, size;

    // Initialize TwoStack.
    public TwoStack(int s) {
        this.size = s;
        this.arr = new int[s];
        this.top1 = -1;
        this.top2 = s;

    }

    // Push in stack 1.
    public void push1(int num) {
        if(top2 - top1 > 1){
            top1++;
            arr[top1] = num;
        }
    }

    // Push in stack 2.
    public void push2(int num) {
        if(top2 - top1 > 1){
            top2--;
            arr[top2] = num;
        }
    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        if(top1 == -1){
            return -1;
        }
        else{
            int ans = arr[top1];
            top1--;
            return ans;
        }
    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        if(top2 == size){
            return -1;
        }
        else{
            int ans = arr[top2];
            top2++;
            return ans;
        }

    }

}



