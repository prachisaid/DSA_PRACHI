package BinarySearch;

public class FindSqrt {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        int ans = 1;

        for(int i = 0; i <= x; i++) {
            if((i * i) <= x) ans = i;
            else break;
        }

        return ans;
    }

    public int mySqrtBS(int x) {
        int low = 0;
        int high = x;
        int ans = 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int sqrt = mid * mid;

            if(sqrt > x) {
                high = mid - 1;
            }
            else {
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;
    }
}
