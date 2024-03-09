package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversionVariation {
    public int[] ans;
    static class Pair {
        int val;
        int ind;

        Pair(int v, int i) {
            this.val = v;
            this.ind = i;
        }
    }
    public static void main(String[] args) {
        int[] arr= {5, 2, 6, 1};
        System.out.println(new CountInversionVariation().countSmaller(arr));
    }
    private void merge(Pair[] arr, int low, int mid, int hl, int high) {
        int m = mid - low + 1;
        int n = high - hl + 1;
        int i = 0, j = 0, cnt = 0, k = 0;
        Pair[] temp = new Pair[m + n];

        while(i < m && j < n) {
            if(arr[low + i].val <= arr[hl + i].val) {
                ans[arr[low + i].ind] += cnt;
                temp[k] = arr[low + i];
                k++;
                i++;
            }
            else{
                temp[k] = arr[hl + j];
                k++;
                j++;
                cnt++;
            }
        }

        while(i < m) {
            ans[arr[low + i].ind] += cnt;
            temp[k] = arr[low + i];
            k++;
            i++;
        }

        while(j < n) {
            temp[k] = arr[hl + j];
            k++;
            j++;
        }

        for(int x = 0; x < temp.length; x++) {
            arr[low + x] =  temp[x];
        }
    }

    private void mergeSort(Pair[] arr, int low, int high) {
        if(low >= high) return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, mid + 1, high);
    }

    public List<Integer> countSmaller(int[] nums) {
        ans = new int[nums.length];
        Pair[] arr = new Pair[nums.length];

        for(int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, nums.length - 1);

        List<Integer> result = new ArrayList<>(ans.length);
        for(int x=0; x<ans.length; x++)
        {
            result.add(ans[x]);
        }
        return result;
//        return a;
    }

//    public static List<Integer> solve(int[] nums) {
//        List<Integer> lst = new ArrayList<>();
//
//        for(int i = 0; i < nums.length; i++) {
//            int cnt = 0;
//            for(int j = i + 1; j < nums.length; j++) {
//                if(nums[i] > nums[j]) {
//                    cnt++;
//                }
//            }
//            lst.add(cnt);
//        }
//
//        return lst;
//    }
}
