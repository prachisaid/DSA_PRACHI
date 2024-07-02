package REVISION.Recursion;

public class CountPermutation {
	public static void main(String[] args) {
		System.out.println(permutation("abc", ""));
	}

	public static int permutation(String up, String p) {
		if(up.isEmpty()) return 1;

		int count = 0;
		char ch = up.charAt(0);

		for(int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i);
			String last = p.substring(i);
			count += permutation(up.substring(1), first + ch + last);
		}

		return count;
	}
}
