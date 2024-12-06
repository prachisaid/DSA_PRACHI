package POTD;

import java.util.HashSet;

public class MaximumNumberInRange {
	public static void main(String[] args) {

	}

	public int maxCount(int[] banned, int n, int maxSum) {
		HashSet<Integer> set = new HashSet<>();
		for(int b : banned) {
			if(b <= n) {
				set.add(b);
			}
		}

		// System.out.println(maxSum);
		int sum = 0;
		int count = 0;

		for(int i = 1; i <= n; i++) {
			if((sum + i) <= maxSum) {
				if(!set.contains(i)) {
					sum += i;
					count++;
				}
			}
		}

		return count;
	}
}
