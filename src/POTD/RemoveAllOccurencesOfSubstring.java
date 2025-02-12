package POTD;

public class RemoveAllOccurencesOfSubstring {
	public static void main(String[] args) {
		System.out.println(removeOccurrences("kpygkivtlqoockpygkivtlqoocssnextkqzjpycbylkaondsskpygkpygkivtlqoocssnextkqzjpkpygkivtlqoocssnextkqzjpycbylkaondsycbylkaondskivtlqoocssnextkqzjpycbylkaondssnextkqzjpycbylkaondshijzgaovndkjiiuwjtcpdpbkrfsi", "kpygkivtlqoocssnextkqzjpycbylkaonds"));
	}

	public static String removeOccurrences(String s, String part) {
		int j = 0, i = 0;
		StringBuilder sb = new StringBuilder();

		while(j < s.length()) {
			if(i == part.length()) {
				sb.delete(sb.length() - part.length(), sb.length());
				sb.append(s.substring(j));
				s = sb.toString();
				sb = new StringBuilder();
				i = 0;
				j = 0;
			}
			if(s.charAt(j) == part.charAt(i)) {
				sb.append(s.charAt(j));
				i++;
				j++;
			}
			else if(i > 0) {
				i = 0;
			}
			else {
				sb.append(s.charAt(j));
				j++;
			}
		}

		if(i == part.length()) {
			sb.delete(sb.length() - part.length(), sb.length());
			sb.append(s.substring(j));
			s = sb.toString();
		}

		return s;
	}
}
