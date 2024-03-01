package BinarySearch;

public class MinimumDaysToMakeBouquet {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        System.out.println(minDays(arr, 2, 3));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (m * k)) return -1;

        long start = Integer.MAX_VALUE, end = 0;

        for(int bloom : bloomDay) {
            start = Math.min(bloom, start);
            end = Math.max(bloom, end);
        }

        for(long i = start; i <= end; i++) {
            int count = 0, noOfB = 0;

            for(int j = 0; j < bloomDay.length; j++) {
                if(bloomDay[j] <= i) {
                    count++;
                }
                else{
                    noOfB += (count / k);
                    count = 0;
                }
            }

            noOfB += (count / k);

            if(noOfB >= m) return (int) i;
        }

        return -1;
    }
}
