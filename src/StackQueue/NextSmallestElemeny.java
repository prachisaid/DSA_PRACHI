package StackQueue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextSmallestElemeny {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(2);
        lst.add(1);
        lst.add(4);
        lst.add(3);

        System.out.println(nextSmallerElement(lst, lst.size()));
    }

    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] lst = new int[n];


        for(int i = n-1; i >= 0; i--){
            int curr = arr.get(i);

            while(stack.peek() >= curr){
                stack.pop();
            }

            lst[i] = stack.peek();
            stack.push(curr);
        }

        ArrayList<Integer> ans = new ArrayList<Integer>(lst.length);
        for (int i : lst)
        {
            ans.add(i);
        }

        return ans;
    }
}
