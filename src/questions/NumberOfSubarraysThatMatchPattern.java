package questions;

import java.util.Arrays;
import java.util.Collections;

public class NumberOfSubarraysThatMatchPattern {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] p = {1,1};

        System.out.println(countMatchingSubarrays(arr, p));
    }

    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;
        int i = 1;
        int prev = i;

        while(i <= (nums.length - pattern.length)) {
            int innerCnt = 0;
            for(int j = 0; j < pattern.length; j++) {
                if(pattern[j] == 0 && nums[i - 1] == nums[i]) {
                    innerCnt += 1;
                }
                else if(pattern[j] == 1 && nums[i - 1] < nums[i]) {
                    innerCnt += 1;
                }
                else if(pattern[j] == -1 && nums[i - 1] > nums[i]) {
                    innerCnt += 1;
                }
                else {
                    break;
                }
                i++;
            }

            if(innerCnt == pattern.length) {
                count++;
            }
            i = prev + 1;
            prev = i;
        }

        return count;
    }
}
