package BinarySearch;

public class SingleElementInSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};
        System.out.println(duplicate(arr));
    }

    public static int duplicate(int[] arr) {
        int n = arr.length;
        if(arr.length == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[arr.length - 1] != arr[arr.length - 2]) return arr[arr.length - 1];

        int start = 1;
        int end = arr.length - 2;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) return mid;

            if(arr[mid] == arr[mid - 1]) {
                if(mid % 2 == 0) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else{
                if(mid % 2 == 0) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
