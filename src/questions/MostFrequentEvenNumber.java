package questions;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenNumber {
    public static void main(String[] args) {
        int[] arr = {8154,9139,8194,3346,5450,9190,133,8239,4606,8671,8412,6290};
        System.out.println(new MostFrequentEvenNumber().mostFrequentEven(arr));
    }

    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0)
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        System.out.println(map);

        int size = map.size();

        int key = -1;
        int val = 0;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > val) {
                val = entry.getValue();
                key = entry.getKey();
            }
            else if(entry.getValue() == val) {
                key = Math.min(key, entry.getKey());
            }
        }

        return key;
    }
}
