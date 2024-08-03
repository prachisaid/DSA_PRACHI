package POTD;

public class MinimumDeletetionToMakeStringBalance {
	public static void main(String[] args) {

	}

	public int minimumDeletions(String s) {
		int a = 0;
		int b = 0;
		boolean first = true;

		int ans = 0;

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if(first && ch == 'b') {
				first = false;
			}

			if(ch == 'a') ans++;
		}

		a = 0;
		b = 0;
		int ans2 = 0;

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if(ch == 'b') {
				b++;
			}
			else {
				if(b > 0) {
					b--;
					ans2++;
				}
			}
		}

		return Math.min(ans, ans2);

		// return ans;
	}
}
