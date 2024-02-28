package BinarySearch;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 0)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        int first = binarySearch(nums, target, true);
        int second = binarySearch(nums, target, false);

        arr[0] = first;
        arr[1] = second;

        return arr;
    }

    private static int binarySearch(int[] nums, int target, boolean isFirst) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] > target) {
                end = mid - 1;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else if(nums[mid] == target) {
                // potential ans found
                ans = mid;
                if(isFirst) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
