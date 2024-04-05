package StackQueue;

import java.util.Stack;

public class MakeStringGreat {
    public static void main(String[] args) {
        System.out.println(new MakeStringGreat().makeGood("abBAcC"));
    }

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isLowerCase(ch)) {
                stack.push(ch);
            }

            else if(Character.isUpperCase(ch)) {
                if(!stack.isEmpty() && Math.abs(ch - stack.peek()) == 32) {
                    stack.pop();
                }
                else {
                    stack.push(ch);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}
