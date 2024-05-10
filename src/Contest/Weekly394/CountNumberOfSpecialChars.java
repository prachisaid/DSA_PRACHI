package Contest.Weekly394;

import java.util.*;

public class CountNumberOfSpecialChars {
	public static void main(String[] args) {

	}

	public int numberOfSpecialChars(String s) {
		Map<Character, Integer> map = new HashMap<>();
		ArrayList<Character> ans = new ArrayList<>();
		int cnt = 0;

		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if(Character.isLowerCase(ch)) {
				if(!ans.contains(ch) && !ans.contains(Character.toUpperCase(ch)) && map.containsKey(Character.toUpperCase(ch))) {
					cnt += 1;
					ans.add(ch);
				}
				else{
					map.put(ch, map.getOrDefault(ch, 0) + 1);
				}
			}
			else{
				if(!ans.contains(ch) && !ans.contains(Character.toLowerCase(ch)) && map.containsKey(Character.toLowerCase(ch))) {
					cnt += 1;
					ans.add(ch);
				}
				else{
					map.put(ch, map.getOrDefault(ch, 0) + 1);
				}
			}

		}

		return cnt;
	}
}
