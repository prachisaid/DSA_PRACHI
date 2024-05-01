package questions;

import java.util.HashMap;

public class CountVowelsSubstringOfAString {
	public static void main(String[] args) {
		System.out.println(countVowelSubstrings("aeiouu"));
	}

	public static int countVowelSubstrings(String word) {
		HashMap<Character, Integer> map = new HashMap<>();

		int cnt = 0;

		for(int i = 0; i < word.length(); i++) {
			map.clear();
			if(isVowel(word.charAt(i))) {
				for(int j = i; j < word.length(); j++) {
					if(!isVowel(word.charAt(j))) {
						break;
					}
					else{
						map.put(word.charAt(j), map.getOrDefault(word.charAt(j), 0) + 1);

						if(map.size() >= 5) {
							cnt += 1;
						}
					}
				}
			}
		}

		return cnt;
	}

	private static boolean isVowel(char ch) {
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
	}
}
