package POTD;

public class ShortestPalindrome {
	public static void main(String[] args) {
		
	}

	public String shortestPalindrome(String s) {
		if(s == null || s.length() == 0) return s;

		String new_s = s + "#" + new StringBuilder(s).reverse().toString();
		int n = new_s.length();

		int[] lps = new int[n];

		for (int i = 1; i < n; i++) {
			int length = lps[i - 1];

			while (length > 0 && new_s.charAt(i) != new_s.charAt(length)) {
				length = lps[length - 1];
			}

			if (new_s.charAt(i) == new_s.charAt(length)) {
				length++;
			}

			lps[i] = length;
		}

		String suffixToAdd = s.substring(lps[n - 1]);

		String suffixReversed = new StringBuilder(suffixToAdd).reverse().toString();

		return suffixReversed + s;
	}
}
