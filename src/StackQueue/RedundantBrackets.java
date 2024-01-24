package StackQueue;

import java.util.Stack;

public class RedundantBrackets {
    public static void main(String[] args) {
        System.out.println(findRedundantBrackets("(a*b+(c/d))"));
    }

    public static boolean findRedundantBrackets(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(isOperator(ch) || ch == '('){
                stack.push(ch);
            }

            else{
                if(ch == ')'){
                    boolean isRedundant = true;
                    while(stack.peek() != '('){
                        char top = stack.peek();
                        if(isOperator(top)){
                            isRedundant = false;
                        }
                        stack.pop();
                    }

                    if(isRedundant){
                        return true;
                    }

                    stack.pop();
                }
            }
        }

        return false;
    }

    private static boolean isOperator(char ch) {
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            return true;
        }
        return false;
    }
}
