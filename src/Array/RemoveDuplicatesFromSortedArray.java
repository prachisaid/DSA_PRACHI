package Array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 7, 8};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0, r = l+1;

        if(n == 0){
            return 0;
        }


        while (r < n) {
            if(nums[l] == nums[r]){
                r++;
            }
            else if(nums[l] != nums[r]){
                l++;
                nums[l] = nums[r];
                r++;
            }
        }

        return l + 1;
    }
}
