package POTD;

import java.util.*;

public class KthSmallestPrimeFraction {
	static class Pair {
		double fraction;
		int first;
		int second;

		Pair(double fr, int f, int s) {
			this.fraction = fr;
			this.first = f;
			this.second = s;
		}
	}

	public static void main(String[] args) {

	}

	public static class Comp implements Comparator<Pair> {
		public int compare(Pair left, Pair right) {
			return (left.fraction) > (right.fraction) ? 1 : -1;
		}
	}

	public int[] kthSmallestPrimeFraction(int[] arr, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comp());


		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j < arr.length; j++) {
				double fraction = (double)((double )arr[i] / (double) arr[j]);
				pq.add(new Pair(fraction, arr[i], arr[j]));
			}
		}


		while(k != 1) {
			pq.poll();
			k -= 1;
		}

		return new int[]{pq.peek().first, pq.peek().second};
	}
}
