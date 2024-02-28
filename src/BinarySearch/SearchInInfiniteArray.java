package BinarySearch;

public class SearchInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {
                1, 2, 4, 6, 8, 9, 11, 12, 15, 18, 22, 25, 34, 38, 42, 43, 47, 56, 57, 78, 110, 123, 145, 178, 190, 200, 290, 389
        };

        System.out.println(infiniteBS(arr, 123));
    }

    public static int infiniteBS(int[] nums, int target) {
        int size = 1;
        int start = 0;
        int end = 0;

        while(true) {
            while(start <= end) {
                int m = start + (end - start) / 2;

                if (nums[m] == target) return m;

                if (nums[m] > target) end = m - 1;
                else start = m + 1;
            }

            start = end + 1;
            end = end + (size * 2);
            size = end - start + 1;
            System.out.println(end);
        }
    }
}
