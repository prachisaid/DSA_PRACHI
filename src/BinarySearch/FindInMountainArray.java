package BinarySearch;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        System.out.println(findInMountainArray(3, arr));
    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        int n = mountainArr.length;
        int peak = findPeakInMountain(mountainArr, n);

        int ans = binarySearch(0, peak, mountainArr, target, true);
        if(ans != -1) return ans;
        else return binarySearch(peak + 1, n - 1, mountainArr, target, false);
    }

    private static int binarySearch(int start, int end, int[] mountainArr, int target, boolean isAsc) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int val = mountainArr[mid];

            if(val == target) return mid;
            if(isAsc) {
                if(val > target) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if(val > target) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    private static int findPeakInMountain(int[] mountainArr, int n) {
        int start = 0;
        int end = n - 1;

        while(start < end){
            int mid = start + (end - start) / 2;
            int val = mountainArr[mid];
            int mid1 = mountainArr[mid + 1];

            if(val > mid1) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }
}
