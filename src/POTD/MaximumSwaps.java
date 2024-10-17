package POTD;

public class MaximumSwaps {
	public static void main(String[] args) {

	}

	public int maximumSwap(int num) {
		char[] nums = String.valueOf(num).toCharArray();
		int n = nums.length;
		int maxNum [] = new int[n];
		maxNum[n-1] = n-1;

		for(int i = n-2; i >= 0; i--){

			int cur = nums[i] - '0';
			int prev = nums[maxNum[i + 1]] - '0';

			if(cur <= prev){
				maxNum[i] = maxNum[i+1];
			}
			else{
				maxNum[i] = i;
			}
		}

		for(int i = 0; i < n; i++){

			int cur = nums[i] - '0';
			int next = nums[maxNum[i]] - '0';

			if(cur < next){
				int index = maxNum[i];
				char ch = nums[i];
				nums[i] = nums[index];
				nums[index] = ch;

				break;
			}
		}

		return Integer.parseInt(new String(nums));
	}
}
