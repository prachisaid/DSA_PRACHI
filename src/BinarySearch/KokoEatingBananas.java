package BinarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] arr = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,
                679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,
                718203285,629455728,941802184};
        System.out.println(minEatingSpeed(arr, 823855818));

    }

    public static int minEatingSpeed(int[] piles, int h) {
        int end = 0;
        int start = 1;
        for(int pile : piles) {
            end = Math.max(end, pile);
        }

        while(start <= end) {
            int mid = start + (end - start) / 2;

            long hours = findHours(piles, mid);

            if(hours <= h) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static long findHours(int[] piles, int k) {
        long ans = 0;

        for(int i = 0; i < piles.length; i++) {
            ans += (int) Math.ceil((double) piles[i] / k);
        }

        return ans;
    }

    public static int minEatingSpeed1(int[] piles, int h) {
        int n = 0;
        int hours = 0;
        for(int a : piles) n = Math.max(n, a);

        for(int k = 1; k <= n; k++){
            long hour = 0;
            for(int i = 0; i < piles.length; i++) {
                hour += (int) Math.ceil((double) piles[i] / k);
                System.out.println(hour);
            }

            System.out.println();
            if(hour <= h) {
                return k;
            }
        }

        return piles.length;
    }
}
