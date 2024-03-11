package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomSort {
    public static void main(String[] args) {
        String order = "kqep", s = "pekeq";
        System.out.println(customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        char[] ch = new char[s.length()];
        int j = 0;
        System.out.println(mp);

        for(Map.Entry<Character, Integer> m : mp.entrySet()) {
            if(map.containsKey(m.getKey())) {
                j = 0;

                while(m.getValue() > 0) {
                    ch[map.get(m.getKey()) + j] = m.getKey();
                    mp.put(m.getKey(), m.getValue() - 1);
                    j++;
                }
            }
            else{
                j = 1;

                while(m.getValue() > 0) {
                    ch[ch.length - j] = m.getKey();
                    System.out.println(Arrays.toString(ch));
                    mp.put(m.getKey(), m.getValue() - 1);
                    j++;
                }
            }
        }

        System.out.println(map);

        return new String(ch);
    }
}
