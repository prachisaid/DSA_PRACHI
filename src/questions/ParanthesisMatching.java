package questions;
import java.util.Stack;

public class ParanthesisMatching {
    public static void main(String[] args) {
        String s  = "(){}[]";
        s = "[}";
        s = "(){";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        boolean isMatching = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if(!checkMatching(s.charAt(i), stack)){
                    return false;
                }else {
                    isMatching = true;
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }
        return isMatching;
    }

    private static boolean checkMatching(char charAt, Stack<Character> stack) {
        if(stack.isEmpty()){
            return false;
        }
        char ch = stack.pop();

        if(ch == '(' && charAt == ')'){
            return true;
        }else if(ch == '[' && charAt == ']'){
            return true;
        }else if(ch == '{' && charAt == '}'){
            return true;
        }else{
            return false;
        }
    }
}
