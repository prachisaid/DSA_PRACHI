package StackQueue;

import java.util.Stack;

public class MinAddToMakeValid {
    public static void main(String[] args) {
        String s = "))())(";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for(char ch : s.toCharArray()){
                if(ch == '('){
                    if(stack.isEmpty()){
                        stack.push(ch);
                    }
                    else{
                        if(stack.peek() == '('){
                            stack.push(ch);
                        }
                        else{
                            count++;
                            stack.pop();
                            stack.pop();
                            stack.push(ch);
                        }
                    }
                }

                else{
                    if(stack.isEmpty()){
                        count++;
                        stack.push('(');
                        stack.push(ch);
                    }
                    else{
                        if(stack.peek() == '('){
                            stack.push(ch);
                        }
                        else{
                            stack.pop();
                            stack.pop();
                        }
                    }
                }
            }

            if(stack.isEmpty()){
                return count;
            }
            else{
                while(!stack.isEmpty()){
                    char ch = stack.pop();
                    if(ch == '('){
                        count += 2;
                    }
                    else{
                        count += 1;
                        stack.pop();
                    }
                }

                return count;
            }
        }
}
