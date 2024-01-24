package StackQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {
    public static void main(String[] args) {
        int nums[] = {1};
        topKFrequent(nums, 1);
    }

    public static void topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
                map.put(nums[i], 1);
            }
        }

        int [] maxKey = new int[k];

        for (int i = 0; i < k; i++) {
            int val = 0, key = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                if (entry.getValue() > val) {
                    val = entry.getValue();
                    key = entry.getKey();
                }
            }

            maxKey[i] = key;
            map.remove(key);
        }

        System.out.println(Arrays.toString(maxKey));
    }
}
