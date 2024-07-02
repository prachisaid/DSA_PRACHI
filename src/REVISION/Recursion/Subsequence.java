package REVISION.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {
	public static void main(String[] args) {
		List<String> lst = new ArrayList<>();
		subseq("abc", "", lst);
		System.out.println(lst);
	}

	public static void subseq(String up, String p, List<String> lst) {
		if(up.isEmpty()) {
			if(!p.isEmpty())
				lst.add(p);
			return;
		}

		char ch = up.charAt(0);
		subseq(up.substring(1), p + ch, lst);
		subseq(up.substring(1), p, lst);
	}
}
