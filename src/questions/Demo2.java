package questions;

public class Demo2 {
    public static void main(String[] args) {
        int[] nums = {-1, 3, 2, 4, 5};
//        System.out.println(new Demo2().maximumSubarraySum(nums, 3));
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++) {
            int max = nums[i] + nums[i + 1];
            for(int j = i + 1; j < nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) == k) {
                    if(j != i + 1) {
                        max += nums[j];
                    }
                    break;
                }
            }

            maxi = Math.max(max, maxi);
        }

        return maxi;
    }
}
