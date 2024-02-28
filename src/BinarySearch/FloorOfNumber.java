package BinarySearch;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7};
        System.out.println(searchInsert(nums, 4));
        System.out.println(searchInsert(nums, 8));
    }

    private static int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while(s <= e) {
            int m = s + (e -  s) / 2;

            if(nums[m] == target) return m;

            if(nums[m] > target) e = m - 1;
            else s = m + 1;
        }

        return nums[e];
    }
}
