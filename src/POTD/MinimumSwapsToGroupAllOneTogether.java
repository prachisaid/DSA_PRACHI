package POTD;

public class MinimumSwapsToGroupAllOneTogether {
	public static void main(String[] args) {
		int[] arr = {1,1,0,0,1};
		System.out.println(minSwaps(arr));
	}

	public static int minSwaps(int[] nums) {
		int i = 0;
		int j = 0;

		int one = 0;
		int zero = 0;
		int ans = Integer.MAX_VALUE;

		for(int num : nums) {
			if(num == 1) one++;
		}

		if(one == 0) return 0;

		while(i < nums.length) {
			if(nums[j] == 0) zero++;

			if(j - i + 1 < one && i <= j) {
				j = (j + 1) % nums.length;
			}
			else {
				ans = Math.min(zero, ans);
				if(nums[i] == 0) zero--;
				i++;
				j = (j + 1) % nums.length;
			}
		}

		return ans;
	}
}
