package Array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        int n = nums.length;

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
            suffix[n - i - 1] = suffix[n - i] * nums[n - i - 1];
        }

        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(suffix));

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                nums[i] = suffix[i + 1];
            }
            else if (i == n - 1) {
                nums[i] = prefix[i - 1];
            }
            else {
                nums[i] = prefix[i - 1] * suffix[i + 1];
            }
        }

        return nums;
    }
}
