package StackQueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = (2 * n -1); i >= 0; i--){
            while(!stack.isEmpty() && nums[i % n] >= stack.peek()){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i % n] = -1;
            }else{
                ans[i % n] = stack.peek();
            }

            stack.push(nums[i%n]);
        }

        return ans;
    }
}
