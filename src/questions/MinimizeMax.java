package questions;

public class MinimizeMax {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 7, 10};
        System.out.println(minimizeMax(arr, 2));

    }

    public static int minimizeMax(int[] nums, int p) {
        int low = 0;
        int high = nums[nums.length-1];

        while(low < high){
            int count = 0;
            int mid = low + (high - low) / 2;

                for (int i = 0; i < nums.length-1; i+=2) {
                    if(nums[i+1] - nums[i] <= mid){
                        count++;
                    }
                }

            if(count < p){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return low;
    }
}
