package BinarySearch;

public class NthRootOfInteger {
    public static void main(String[] args) {

    }

//    Brute -> For loop from 1 to M -> Function for calculating Nth root

    public double myPow(double x, int n) {
        double ans = 1.0;
        long num = n;

        if(num < 0) {
            num = -1 * num;
        }

        while(num > 0) {
            if(num % 2 == 1) {
                ans = ans * x;
                num = num - 1;
            }
            else {
                x = x * x;
                num = num / 2;
            }
        }

        if(n < 0) {
            ans = (double) (1.0) / (double) ans;
        }
        return ans;
    }

    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int node = func(mid, n, m);

            if(node == 1) return mid;

            else if(node == 0) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }

    private static int func(int mid, int n, int m) {
        long ans = 1;
        for(int i = 1; i <= n; i++) {
            ans = ans * mid;
            if(ans > m) {
                return 2;
            }
        }

        if(ans == m) return 0;
        return 1;
    }
}
