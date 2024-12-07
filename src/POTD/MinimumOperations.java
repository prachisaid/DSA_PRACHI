package POTD;

public class MinimumOperations {
	public static void main(String[] args) {

	}

	public int minimumSize(int[] nums, int maxOperations) {
		int left = 1 , right = 0;

		for(int num : nums) {
			right = Math.max(right, num);
		}

		int result = Integer.MAX_VALUE;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			// System.out.println(result);

			if(search(mid, nums, maxOperations)) {
				result = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}

		return result;
	}

	public boolean search(int mid, int[] nums, int maxOperations) {
		int operations = 0;

		for(int num: nums){
			if(num > mid) {
				operations += Math.ceil((double)(num - mid) / mid);
			}
		}

		return operations <= maxOperations;
	}
}
