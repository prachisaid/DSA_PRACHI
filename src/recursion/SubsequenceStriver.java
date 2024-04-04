package recursion;

import java.util.ArrayList;

public class SubsequenceStriver {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int ans = subSeqCount(0, arr, 0, 2);
        System.out.println(ans);
    }

    public static void subSeq(int ind, int[] arr, int sum, int target, ArrayList<Integer> ans) {
        if(ind == arr.length) {
            if(sum == target) {
                System.out.println(ans);
            }

            return;
        }

        ans.add(arr[ind]);
        subSeq(ind + 1, arr, sum + arr[ind], target, ans);
        ans.remove(ans.size() - 1);
        subSeq(ind + 1, arr, sum, target, ans);
    }

    public static boolean subSeqOne(int ind, int[] arr, int sum, int target, ArrayList<Integer> ans) {
        if(ind == arr.length) {
            if(sum == target) {
                System.out.println(ans);
                return true;
            }
            else return false;
        }

        ans.add(arr[ind]);
        if(subSeqOne(ind + 1, arr, sum + arr[ind], target, ans)) return true;
        ans.remove(ans.size() - 1);
        if(subSeqOne(ind + 1, arr, sum, target, ans)) return true;

        return false;
    }

    public static int subSeqCount(int ind, int[] arr, int sum, int target) {
        if(ind == arr.length) {
            if(sum == target) {
                return 1;
            }

            return 0;
        }

        int l = subSeqCount(ind + 1, arr, sum + arr[ind], target);
        int r = subSeqCount(ind + 1, arr, sum, target);

        return l + r;
    }
}
