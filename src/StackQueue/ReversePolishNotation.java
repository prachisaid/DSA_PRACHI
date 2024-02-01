package StackQueue;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] arr = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new ReversePolishNotation().evalRPN(arr));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            if(checkOp(tokens[i])) {
                int num2 = s.pop();
                int num1 = s.pop();

                if(tokens[i].equals("+")) {
                    s.push(num1 + num2);
                }
                else if(tokens[i].equals("-")) {
                    s.push(num1 - num2);
                }
                else if(tokens[i].equals("*")) {
                    s.push(num1 * num2);
                }
                else {
                    s.push(num1 / num2);
                }
            }
            else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }

        return s.pop();
    }

    private boolean checkOp(String str){
        if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) return true;
        else return false;
    }
}
