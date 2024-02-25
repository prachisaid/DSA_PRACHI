package BitManipulation;

public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {-2,-2,1,1,4,1,4,4,-4,-2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int[] count = new int[32];

        for(int i = 0; i < nums.length; i++) {
           for(int j = 0; j < 32; j++) {
               if((nums[i] & (1 << j)) != 0) {
                   count[j] += 1;
               }
           }
        }

        long ans = 0;

        for(int i = 0; i < 32; ++i) {
            ans += (long) ((count[i] % 3) * Math.pow(2, i));
        }

        return (int) ans;
    }
}
