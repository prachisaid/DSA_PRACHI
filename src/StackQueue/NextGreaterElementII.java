package StackQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int [] nums1 = {4, 1, 2};
        int [] nums2 = {1, 3, 4, 2};

        nextGreaterElement(nums1, nums2);
    }

    public static void nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = nums2.length-1; i >= 0; i--){
            int curr = nums2[i];

            while(!stack.isEmpty() && stack.peek() <= curr){
                stack.pop();
            }

            if(stack.isEmpty()){
                map.put(nums2[i], -1);
                stack.push(curr);
            }else{
                map.put(nums2[i], stack.peek());
                stack.push(curr);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            if(map.containsKey(nums1[i])){
                ans[i] = map.get(nums1[i]);
            }else{
                ans[i] = -1;
            }
        }

        System.out.println(map);
        System.out.println(Arrays.toString(ans));
    }
}
