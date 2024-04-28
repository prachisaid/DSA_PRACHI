package REVISION.Graph;

import java.util.Arrays;
import java.util.List;

public class DijkstraPriorityQueue {

	public static void main(String[] args) {
		int[] a = {4, 7, 5};
		int[] b = {5};

		System.out.println(minimumAddedInteger(a, b));
	}

	public static int minimumAddedInteger(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int mini = Integer.MAX_VALUE;
		int ind = -1;

		for(int i = 0; i < nums1.length; i++) {
			int diff = Math.abs(nums2[0] - nums1[i]);
			if(mini >= diff) {
				mini = diff;
				ind = i;
			}
		}

		int x = nums1[ind] - nums2[0];
		if(x < 0) return Math.abs(x);
		else return -(x);
	}
}
