package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 3, 1, 4, 5, 6};
        System.out.println(majorityElement(arr));
        int[] nums = {3, 1};
        int k = (int) Math.floor((double) nums.length / 3.0);
        System.out.println(k);
    }

    public static List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        int count = 0;

        int i = 0;
        int j = 0;

        while(j < nums.length) {
            if(nums[i] == nums[j]) {
                count++;
                j++;
            }
            else {
                if(nums.length / 3 < count) {
                    ans.add(nums[i]);
                }
                count = 0;
                i = j;
            }
        }

        if(nums.length / 3 < count) {
            System.out.println(count);
            ans.add(nums[i]);
        }

        return ans;
    }
}
