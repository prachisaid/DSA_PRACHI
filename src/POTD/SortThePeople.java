package POTD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortThePeople {
	class Pair implements Comparable<Pair> {
		int height;
		String name;

		Pair(int height, String name) {
			this.height = height;
			this.name = name;
		}

		public int compareTo(Pair p1) {
			return p1.height - this.height;
		}
	}

	public String[] sortPeople(String[] names, int[] heights) {
		List<Pair> lst = new ArrayList<>();
		int n = heights.length;

		for(int i = 0; i < n; i++) {
			lst.add(new Pair(heights[i], names[i]));
		}

		Collections.sort(lst);

		String[] ans = new String[n];

		for(int i = 0; i < n; i++) {
			ans[i] = lst.get(i).name;
		}

		return ans;
	}

	public static void main(String[] args) {
		
	}
}
