package BinarySearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(splitArray(nums, 2));
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for(int i : nums) {
            start = Math.max(i, start);
            end += i;
        }

        System.out.println(start + " " + end);

        while(start < end) {
            int mid = start + (end - start) / 2;
            int pieces = 1;
            int sum = 0;

            for(int i = 0; i < nums.length; i++) {
                if(sum + nums[i] > mid){
                    pieces++;
                    sum = nums[i];
                }
                else{
                    sum += nums[i];
                }
            }

            if(pieces <= k) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}
