package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> arr = new ArrayList<>();

        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;

        while(i < n && j < m) {
            if(nums1[i] == nums2[j]) {
                arr.add(nums1[i]);
                i++;
                j++;
            }

            else if(nums1[i] < nums2[j]) {
                i++;
            }

            else {
                j++;
            }
        }

        int[] ans = new int[arr.size()];
        for(i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }

        return ans;
    }
}
