package POTD;

import java.util.*;

public class SortTheJumbledNumbers {
	public static void main(String[] args) {

	}

	class Tuple implements Comparable<Tuple> {
		int newNum;
		int oldNum;
		int index;

		Tuple(int oldNum, int newNum, int index) {
			this.newNum = newNum;
			this.oldNum = oldNum;
			this.index = index;
		}

		public int compareTo(Tuple p1) {
			if(p1.newNum == this.newNum) {
				return this.index - p1.index;
			}
			else {
				return this.newNum - p1.newNum;
			}
		}
	}

	public int[] sortJumbled(int[] mapping, int[] nums) {
		List<Tuple> lst = new ArrayList<>();

		for(int i = 0; i < nums.length; i++) {
			String s = Integer.toString(nums[i]);
			StringBuilder sb = new StringBuilder();

			for(char ch : s.toCharArray()) {
				int value = mapping[ch - '0'];
				sb.append(value);
			}

			// System.out.println(sb);
			lst.add(new Tuple(nums[i], Integer.parseInt(sb.toString()), i));
		}

		Collections.sort(lst);

		int[] ans = new int[nums.length];
		int i = 0;

		for(Tuple t : lst) {
			ans[i++] = t.oldNum;
		}

		return ans;
	}
}
