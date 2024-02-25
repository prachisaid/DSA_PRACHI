package BitManipulation;

public class CheckIfBitwiseOrHasTrailingZero {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(hasTrailingZeros(arr));
    }
    public static boolean hasTrailingZeros(int[] nums) {
        int even = 0;

        for(int num : nums){
            if((num & 1) == 0){
                even++;
            }
        }

        if(even >= 2) return true;
        return false;
    }
}
