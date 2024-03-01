package BinarySearch;

public class RecursiveBS {
    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        System.out.println(recursiveBS(arr, 19));
    }

    public static int recursiveBS(int[] arr, int target) {
        return helper(0, arr.length - 1, arr.length / 2, arr, target);
    }

    private static int helper(int start, int end, int mid, int[] arr, int target) {
        if(start > end) return -1;

        if(arr[mid] == target) return mid;

        if(arr[mid] > target) return helper(start, mid - 1, start + ((mid - 1) - start) / 2, arr, target);
        return helper(mid + 1, end, (mid + 1) + (end - (mid + 1)) / 2, arr, target);
    }
}
