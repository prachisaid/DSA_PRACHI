package POTD;

public class LongestSubarrayWithMaximumBitwiseAND {
	public static void main(String[] args) {

	}

	public int longestSubarray(int[] nums) {
		int maxVal = 0;
		for (int num : nums) {
			maxVal = Math.max(maxVal, num);
		}
		int maxLength = 0;
		int currentLength = 0;

		for (int num : nums) {
			if (num == maxVal) {
				currentLength++;
			} else {
				maxLength = Math.max(maxLength, currentLength);
				currentLength = 0;
			}
		}

		maxLength = Math.max(maxLength, currentLength);

		return maxLength;
	}
}
