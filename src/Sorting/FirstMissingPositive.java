package Sorting;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1, -1, 4, 3};
        FirstMissingPositive obj = new FirstMissingPositive();
        System.out.println(obj.firstMissingPositive(arr));
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            int correct = nums[i] - 1;

            if(correct >= nums.length || nums[i] >= nums.length || nums[i] <= 0) i++;
            else if(nums[i] != nums[correct]) swap(nums, i, correct);
            else i++;
        }

        System.out.println(Arrays.toString(nums));

        for(int j = 0; j < nums.length; j++) {
            int correct = nums[j] - 1;

            if(j != correct) return j + 1;
        }

        return nums.length + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
