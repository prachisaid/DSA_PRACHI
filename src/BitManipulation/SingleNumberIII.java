package BitManipulation;

import java.util.Arrays;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 5, 1, 4, 4, 7, 3, 3};
//        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(arr)));
        System.out.println();
    }

    public int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor = xor ^ num;
        }

        int cnt = 0;
        int mask = 1;

        while(xor != 0) {
            if((xor & mask) == 0) {
                mask = mask << 1;
                cnt++;
            }
            else {
                break;
            }
        }

        System.out.println(cnt);

        int xor1 = 0;
        int xor2 = 0;

        for (int num : nums) {
            if ((num & (1 << cnt)) == 0) {
                xor1 = xor1 ^ num;
            } else {
                xor2 = xor2 ^ num;
            }
        }

        int[] ans = new int[2];
        ans[0] = xor1;
        ans[1] = xor2;

        return ans;
    }
}
