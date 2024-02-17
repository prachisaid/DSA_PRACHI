package questions;

import java.util.*;

public class ReverseSort {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        for(int ind = 0; ind < nums.length; ind++) {
            if(nums[ind] == 2) {
                swap(nums, ind, j);
                if(nums[i] == 0) i++;
                j--;


            }
            else if(nums[ind] == 0) {
                swap(nums, i, ind);
                i++;
            }
            if(i==j){
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
