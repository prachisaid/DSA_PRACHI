package SlidingWindow;

public class LargestSubarrayWithSumK {
    public static void main(String[] args) {

    }

    public static int longestSubarrayWithSumK(int []a, long k) {
        int i = 0;
        int j = 0;

        long sum = 0;
        int len = 0;

        while(j < a.length) {
            sum += a[j];

            if(sum < k) {
                j++;
            }

            else if(sum == k) {
                len = Math.max(len, (j - i) + 1);
                j++;
            }

            else if(sum > k) {
                while(i <= j && sum > k) {
                    sum -= a[i];
                    i++;
                    // System.out.println(sum + " i " + i + " j " + j);
                }

                if(sum == k) {
                    len = Math.max(len, (j - i) + 1);
                }
                j++;
            }
        }

        return len;
    }
}
