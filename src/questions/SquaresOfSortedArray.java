package questions;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] arr = {-4, -1, 0, 3, 10};

        System.out.println(Arrays.toString(new SquaresOfSortedArray().sortedSquares(arr)));
    }

    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }
}
