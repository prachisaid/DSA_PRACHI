package POTD;

public class MinimumStringLengthAfterRemovingSubStr {
	public static void main(String[] args) {

	}

	public int minLength(String s) {
		StringBuilder sb = new StringBuilder(s);

		int i = 0;
		int j = i + 1;

		while(i < sb.length() && j < sb.length()) {
			if(sb.substring(i, j + 1).equals("AB") || sb.substring(i, j + 1).equals("CD")) {
				StringBuilder temp = new StringBuilder(sb.substring(0, i));
				temp.append(sb.substring(j + 1, sb.length()));
				sb = temp;
				i = 0;
				j = i + 1;
			}
			else {
				i++;
				j++;
			}

			// System.out.println(sb);

		}

		return sb.length();
	}
}
