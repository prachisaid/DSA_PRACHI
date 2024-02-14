package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReverseSort {
    public static void main(String[] args) {
        int[] nums = {36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34};

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int ind = 0; ind < nums.length; ind++) {
            if(ind % 2 == 1) {
                neg.add(nums[ind]);
            }
            else {
                pos.add(nums[ind]);
            }
        }

        Collections.sort(pos);
        neg.sort(Collections.reverseOrder());

        int i = 0;
        int ind1 = pos.size();
        int ind2 = neg.size();
        int prev = 0;
        int prev2 = 0;

        for(int ind = 0; ind < Math.min(pos.size(), neg.size()); ind++) {
            nums[i] = pos.get(ind);
            ind1--;
            i++;
            nums[i] = neg.get(ind);
            ind2--;
            i++;
            prev = ind;
            prev2 = ind;
        }

//        while(ind1 >= 0){
//            nums[i] = pos.get(prev);
//            prev++;
//            ind1--;
//        }
//
//        while(ind2 >= 0){
//            nums[i] = pos.get(prev2);
//            prev2++;
//            ind2--;
//        }

        System.out.println(Arrays.toString(nums));
    }
}
