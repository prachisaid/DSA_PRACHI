package StackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class FirstNegative {
    public static void main(String[] args) {
        int arr[] = {-8, 2, 3, -6, 10};
        System.out.println(Arrays.toString(firstNegative(arr, 5, 2)));
    }

    public static int[] firstNegative(int[] arr, int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int count  = 0;
        int max = 0;

        for(int i = 0; i < k; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        dq.addLast(max);

        if(dq.size() > 0){
            ans[count] = arr[dq.getFirst()];
            count++;
        }
        else{
            ans[count] = 0;
            count++;
        }

        for(int i = k; i < n; i++){
            if(!dq.isEmpty() && i - dq.getFirst() >= k){
                dq.removeFirst();
            }

            if(arr[i] < 0){
                dq.addLast(i);
            }

            if(dq.size() > 0){
                ans[count] = arr[dq.getFirst()];
                count++;
            }
            else{
                ans[count] = 0;
                count++;
            }
        }
        return ans;
    }
}
