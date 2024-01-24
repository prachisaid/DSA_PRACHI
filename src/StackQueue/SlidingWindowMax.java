package StackQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }

    public static int[] maxSlidingWindow(int[] arr, int k){
        int i = 0, j = 0;
        int size = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int[size - k + 1];

        while(j != size){
            if(dq.isEmpty()){
                dq.addLast(j);
            }
            else{
                while(!dq.isEmpty() && dq.peekLast() < arr[j]){
                    dq.removeLast();
                }
                dq.addLast(j);
            }

            if(j - i + 1 < k){
                j++;
            }
            else if(j - i + 1 == k){
                ans[i] = arr[dq.peekFirst()];

                if(arr[i] == arr[dq.peekFirst()]){
                    dq.removeFirst();
                }

                i++;
                j++;
            }
        }

        return ans;
    }
}
