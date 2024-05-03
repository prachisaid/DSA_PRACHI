package questions;

import java.util.HashMap;
import java.util.Stack;

public class Demo {
	static class Pair {
		char ch;
		int val;

		Pair(char ch, int val) {
			this.ch = ch;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abcd", 2));
	}

	public static String removeDuplicates(String s, int k) {
		Stack<Pair> stack = new Stack<>();

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if(stack.isEmpty() || (stack.peek().val != k && stack.peek().ch != ch)) {
				stack.push(new Pair(ch, 1));
			}
			if(!stack.isEmpty() && stack.peek().val == k) {
				stack.pop();
			}
			if(!stack.isEmpty() && stack.peek().ch == ch) {
				Pair p = stack.pop();
				stack.push(new Pair(p.ch, p.val + 1));
			}
		}

		StringBuilder ans = new StringBuilder();
		while(!stack.isEmpty()) {
			ans.append(stack.pop().ch);
		}

		return ans.reverse().toString();
	}
}
