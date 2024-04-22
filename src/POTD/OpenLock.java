package POTD;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenLock {
	public static void main(String[] args) {
		OpenLock obj = new OpenLock();
		String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
		System.out.println(obj.openLock(deadends, "8888"));
	}

	public int openLock(String[] deadends, String target) {
		Queue<String> q = new LinkedList<>();
		Set<String> set = new HashSet<>();

		for(int i = 0; i < deadends.length; i++) {
			set.add(deadends[i]);
		}

		if(!set.contains("0000")) {
			q.add("0000");
		}
		int cnt = 0;

		while(!q.isEmpty()) {
			int size = q.size();

			for(int i = 0; i < size; i++) {
				String node = q.poll();

				if(node.equals(target)) return cnt;

				for(int j = 0; j < 4; j++) {
					String right = turnRight(node, j);
					if(!set.contains(right)) {
						q.add(right);
						set.add(right);
					}
				}

				for(int j = 0; j < 4; j++) {
					String left = turnLeft(node, j);
					if (!set.contains(left)) {
						q.add(left);
						set.add(left);
					}
				}
			}

			cnt += 1;
		}

		return -1;
	}

	private String turnLeft(String node, int ind) {
		String ans = "";

		for(int i = 0; i < node.length(); i++) {
			char c = node.charAt(i);

			if(i == ind) {
				ans += (c == '0' ? (char) '9' : (char) (c - 1));
			}
			else {
				ans += c;
			}
		}

		return ans;
	}

	private String turnRight(String node, int ind) {
		String ans = "";

		for(int i = 0; i < node.length(); i++) {
			char c = node.charAt(i);

			if(i == ind) {
				ans += (c == '9' ? (char)'0' : (char)(c + 1));
			}
			else {
				ans += c;
			}
		}

		return ans;
	}
}
