package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
	public static void main(String[] args) {
		List<String> ans = new ArrayList<>();
		func("abc", "", 0, ans);
		System.out.println(ans);
		System.out.println(func1("abc", ""));
	}

	private static void func(String p, String up, int ind, List<String> lst) {
		if(ind == p.length()) {
			if(!up.isEmpty()) lst.add(up);
			return;
		}

		char ch = p.charAt(ind);
		func(p, up, ind + 1, lst);
		func(p, up + ch, ind + 1, lst);
	}

	private static List<String> func1(String p, String up) {
		List<String> ans = new ArrayList<>();
		if(p.isEmpty()) {
			if(!up.isEmpty()) ans.add(up);
			return ans;
		}

		char ch = p.charAt(0);
		ans.addAll(func1(p.substring(1), up + ch));
		ans.addAll(func1(p.substring(1), up));
		return ans;
	}
}
