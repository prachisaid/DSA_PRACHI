package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CountInversionVariation {
    public static void main(String[] args) {
        int[] arr= {5, 2, 6, 1};
        System.out.println(solve(arr));
    }

    public static List<Integer> solve(int[] nums) {
        List<Integer> lst = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    cnt++;
                }
            }
            lst.add(cnt);
        }

        return lst;
    }
}
