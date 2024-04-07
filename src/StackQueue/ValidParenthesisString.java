package StackQueue;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {

    }

    public boolean checkValidString(String s) {
        int star = 0;

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        Stack<Character> s3 = new Stack<>();

        boolean a1 = true, a2 = true, a3 = true;

        int leftCount = 0;
        int rightCount = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                s1.push(ch);
                s2.push(ch);
                s3.push(ch);
            }

            if(ch == ')') {
                if(!s1.isEmpty()) {
                    s1.pop();
                }
                else{
                    a1 = false;
                }

                if(!s2.isEmpty()) {
                    s2.pop();
                }
                else{
                    a2 = false;
                }

                if(!s3.isEmpty()) {
                    s3.pop();
                }
                else{
                    a3 = false;
                }
            }

            if(ch == '*') {
                s1.push('(');

                if(!s2.isEmpty()) {
                    s2.pop();
                }
                else{
                    a2 = false;
                }
            }
        }

        if(!a1 && !a2 && !a3) {
            return false;
        }
        else{
            return (s1.isEmpty() || s2.isEmpty() || s3.isEmpty());
        }
    }
}
