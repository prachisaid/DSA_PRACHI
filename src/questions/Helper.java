package questions;

import java.util.*;

public class Helper {
    public static void main(String[] args) {
//        List<List<Integer>> l = new ArrayList<>();
//        List<Integer> ans = new ArrayList<>();
//        ans.add(2);
//        ans.add(1);
//        ans.add(2);
//        Collections.sort(ans);
//        l.add(ans);
//
//        ans = new ArrayList<>();
//
//        ans.add(2);
//        ans.add(1);
//        ans.add(2);
//        Collections.sort(ans);
//        ans = new ArrayList<>();
//
//        ans.add(2);
//        ans.add(2);
//        ans.add(1);
//        Collections.sort(ans);
//        if(l.contains(ans)){
//            System.out.println(l);
//        }
//        else{
//            l.add(ans);
//        }
//        System.out.println(l);
        ArrayList<Character> lst = new ArrayList<>();
        lst.add('4');
        lst.add('a');
//        lst.remove('4');
        String ch = "abs";
        ch.contains(Character.toString('c'));
//        char ch1 = ch.charAt(0);
//        int val = 1;
//        char ans = (char) (ch1 + val);

        int ans =  ((ch.charAt(1) - 'a' + 1) % 26 + 'a'); ;
        ans = 'b';
        System.out.println(ans);
        System.out.println(lst);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(2, 2);
        map.put(3, 4);
        map.put(5, 6);
        map.put(2, 3);
        System.out.println(map);
    }
}
