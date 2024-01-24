package StackQueue;

import java.util.HashMap;
import java.util.Map;

public class FrequencySort {
    public static void main(String[] args) {
        frequencySort("Aabb");
    }

    public static void frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i), 1);
            }
        }

        StringBuilder str = new StringBuilder();
        int size = map.size();

        for (int i = 0; i < size; i++) {
            int val = 0;
            char key = 0;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                if (entry.getValue() > val) {
                    val = entry.getValue();
                    key = entry.getKey();
                }
            }

            for (int j = 0; j < val; j++) {
                str.append(key);
            }

            map.remove(key);
        }
        
        System.out.println(str);
    }
}
