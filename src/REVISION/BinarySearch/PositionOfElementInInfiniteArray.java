package REVISION.BinarySearch;

public class PositionOfElementInInfiniteArray {
	public static void main(String[] args) {
		int[] nums = {2, 3, 5, 6, 7, 8, 10, 11, 12, 15, 20, 23, 27, 40, 45, 48, 53, 59, 66, 70, 72, 76};
		System.out.println(binarySearch(nums, 23));
	}

	private static int binarySearch(int[] nums, int target) {
		int s = 0;
		int e = 1;
		int n = 2;

		while(e <= nums.length) {
			int ind = helper(s, e, nums, target);
			if(ind != -1) return ind;

			n = (int) Math.pow(2, n);
			s = e + 1;
			e = s + n - 1;
			System.out.println(s + " " + e + " " + n);
		}

		return -1;
	}

	private static int helper(int s, int e, int[] nums, int target) {
		while(s <= e) {
			int m = s + (e - s) / 2;

			if(nums[m] == target) return m;
			else if(nums[m] < target) {
				s = m + 1;
			}
			else {
				e = m - 1;
			}
		}

		return -1;
	}
}
