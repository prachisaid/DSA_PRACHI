package StackQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(FirstNonRepeating("aabc"));
    }

    public static String FirstNonRepeating(String A) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();

        String ans = "";

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else{
                map.put(ch, 1);
            }

            q.add(ch);

            while(!q.isEmpty()){
                if(map.get(q.peek()) > 1){
                    q.remove();
                }
                else{
                    ans += q.peek();
                    break;
                }
            }

            if(q.isEmpty()){
                ans += '#';
            }
        }

        return ans;
    }
}
