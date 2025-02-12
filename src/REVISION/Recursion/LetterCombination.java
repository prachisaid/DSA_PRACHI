package REVISION.Recursion;

import java.util.*;

public class LetterCombination {
	public static void main(String[] args) {
		System.out.println(letterCombinations("12"));
	}

	public static List<String> letterCombinations(String digits) {
		String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> ans = new ArrayList<>();

		if(digits.length() == 0) return ans;
		helper(digits, "", ans, map);
		return ans;
	}

	private static void helper(String digits, String res, List<String> ans, String[] map) {
		if(digits.isEmpty()) {
			ans.add(res);
			return;
		}

		char ch = digits.charAt(0);
		String num = map[ch - '0'];

		for(char c : num.toCharArray()) helper(digits.substring(1), res + c, ans, map);
	}
}
