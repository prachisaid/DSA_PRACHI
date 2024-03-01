package BinarySearch;

public class FindingSqrtOfNumber {
    public static void main(String[] args) {
        System.out.println(sqrt(28));
    }

    public static int sqrt(int num) {
        int start = 1;
        int end = num;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if((mid * mid) <= num) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return end;
    }
}
