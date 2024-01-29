package questions;

import java.util.Arrays;

public class MaximumNumberOfPairsInArray {
    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(Arrays.toString(numberOfPairs(arr)));
    }

    public static int[] numberOfPairs(int[] nums) {
        int[] arr = new int[2];
        if(nums.length == 1) {
            arr[1] = 1;
            return arr;
        }

        Arrays.sort(nums);
        int pairs = 0;
        int leftover = nums.length;

        for(int i = 0; i < nums.length; i++) {
            if(i + 1 < nums.length && nums[i] == nums[i + 1]) {
                pairs++;
                leftover -= 2;
                i++;
            }
        }

        arr[0] = pairs;
        arr[1] = leftover;

        return arr;
    }
}
