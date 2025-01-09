package REVISION.BinarySearch;

public class FindPivotInRotatedArray {
	public static void main(String[] args) {
		int[] nums = {3, 4, 5, 6, 2};
		System.out.println(pivot(nums));
	}

	public static int pivot(int[] nums) {
		int s = 0;
		int e = nums.length - 1;

		while(s <= e) {
			int m = s + (e - s) / 2;

			if(nums[m] > nums[m + 1]) return m;
			if(nums[m] < nums[m - 1]) return m - 1;
			if(nums[s] > nums[m]) {
				e = m - 1;
			}
			else {
				s = m + 1;
			}
		}

		return 0;
	}
}
