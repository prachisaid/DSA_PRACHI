package REVISION.Recursion;

public class SkipACharacter {
	public static void main(String[] args) {
		System.out.println(func("", "baacaa", 0));
		System.out.println(func1("baacaa", 0));
	}

	private static String func(String str, String org, int ind) {
		if(ind == org.length()) return str;

		if(org.charAt(ind) != 'a'){
			str += org.charAt(ind);
		}

		return func(str, org, ind + 1);
	}

	private static String func1(String str, int ind) {
		String ans = "";
		if(ind == str.length()) return ans;

		if(str.charAt(ind) != 'a') ans += str.charAt(ind);

		return ans += func1(str, ind + 1);
	}
}
