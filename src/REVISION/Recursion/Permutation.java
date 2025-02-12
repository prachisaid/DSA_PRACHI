package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	public static void main(String[] args) {
		System.out.println(func("abc", ""));
	}

	private static List<String> func(String p, String up) {
		List<String> ans = new ArrayList<>();

		if(p.isEmpty()) {
			ans.add(up);
			return ans;
		}

		char ch = p.charAt(0);

		for(int i = 0; i < up.length() + 1; i++) {
			String start = up.substring(0, i);
			String end = up.substring(i);

			ans.addAll(func(p.substring(1), start + ch + end));
		}

		return ans;
	}
}
