package Random;

import java.util.*;

public class MinimumCostToMakeArrayIdenticals {
	public static void main(String[] args) {

	}

	public long minCost(int[] arr, int[] brr, long k) {
		long firstSol = 0;

		for(int i = 0; i < arr.length; i++) {
			firstSol += Math.abs(arr[i] - brr[i]);
		}

		int[] lst = new int[arr.length];
		int smallest = Integer.MAX_VALUE;
		int smallestIndex = 0;
		for(int i = 0; i < arr.length; i++) {
			int diff = Integer.MAX_VALUE;
			for(int j = 0; j < arr.length; j++) {
				int curDiff = 0;
				if(i != j) {
					if (arr[i] < 0) {
						curDiff = Math.abs(arr[i] - brr[i]);
					} else {
						curDiff = Math.abs(brr[i] - arr[i]);
					}
				}

				if(diff > curDiff) {
					diff = curDiff;
					lst[i] = j;
				}
			}

			if(smallest > diff) {
				smallest = diff;
				smallestIndex = i;
			}
		}

		for(int i = smallestIndex; i >= 0; i++) {

		}

		return firstSol;
	}
}
