package REVISION.Recursion;

public class SkipACharacter {
	public static void main(String[] args) {
		System.out.println(skip("baccad", "", 0));
	}

	public static String skip(String up, String p, int ind) {
		if(ind == up.length()) return p;

		char ch = up.charAt(ind);

		if(ch == 'a') return skip(up, p, ind + 1);
		return skip(up, p + ch, ind + 1);
 	}
}
