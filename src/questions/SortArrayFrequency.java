package questions;

import java.util.*;

public class SortArrayFrequency {
    static class ValueComparator implements Comparator<Integer> {
        Map<Integer, Integer> base;

        public ValueComparator(Map<Integer, Integer> base) {
            this.base = base;
        }
        public int compare(Integer a, Integer b) {
            if (base.get(a) < base.get(b)) {
                return -1;
            }
            else if (base.get(a) == base.get(b)) {
                if(a > b) return -1;
                return 1;
            }
            else {
                return 1;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {-1,1,-6,4,5,-6,1,4,1};
        new SortArrayFrequency().frequencySort(arr);
    }

    public void frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ValueComparator vc = new ValueComparator(map);
        TreeMap<Integer,Integer> tMap = new TreeMap<>(vc);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        tMap.putAll(map);
        int i = 0;

        for(Map.Entry<Integer, Integer> e : tMap.entrySet()) {
            int freq = e.getValue();
            while(freq != 0) {
                nums[i] = e.getKey();
                freq--;
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
