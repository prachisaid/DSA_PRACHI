package BinarySearch;

/*
https://leetcode.com/problems/first-bad-version/submissions/
*/
public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while(s <= e) {
            int m = s + (e - s) / 2;

            if(nums[m] == target) return m;
            if(nums[m] > target) {
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }

        return nums[s];
    }
}
