package StackQueue;

import java.util.Stack;

public class MinimumCost {
    public static void main(String[] args) {

    }

    public static int findMinimumCost(String str){
        if(str.length()%2 == 1){
            return -1;
        }

        Stack<Character> stack = new Stack<>();
        int a = 0, b = 0;

        for(char ch : str.toCharArray()) {
            if (ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
            //stack contains invalid expression
            while(!stack.isEmpty()){
                if(stack.peek() == '{'){
                    b++;
                }
                else{
                    a++;
                }
                stack.pop();
            }

            int ans = (a + 1)/2 + (b + 1)/2;
        return ans;
    }
}
