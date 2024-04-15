package Contest.Weekly393;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumPrimeDifference {
    public static void main(String[] args) {

    }

    public int maximumPrimeDifference(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(isPrime(nums[i])) {
                ans.add(i);
            }
        }

        Collections.sort(ans);
        System.out.println(ans);

        return Math.abs(ans.get(0) - ans.get(ans.size() - 1));
    }

    private boolean isPrime(int num) {
        if(num <= 1) return false;

        for(int i = 2; i <= (num/2); i++) {
            if((num % i) == 0) return false;
        }

        return true;
    }
}
