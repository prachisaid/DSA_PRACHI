package REVISION.Recursion;

import java.util.*;

public class PrintPermutation {
	public static void main(String[] args) {
		List<String> lst = new ArrayList<>();
		permutations("abc", "", lst);
		System.out.println(lst);
	}

	public static void permutations(String up, String p, List<String> ans) {
		if(up.isEmpty()) {
			ans.add(p);
			return;
		}

		char ch = up.charAt(0);

		for(int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String last = p.substring(i, p.length());
			permutations(up.substring(1), first + ch + last, ans);
		}
	}
}
