package questions;

public class CodeForces {
    public static void main(String[] args) {
        int[] a = {1, 5, 10, 14};
        int[] b = {2, 1, 8, 1};

        int k = 8;

        System.out.println(findPairs(a, b, k));
    }

    private static int findPairs(int[] a, int[] b, int k) {
        int ans = 0;

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++) {
                if((a[i] + b[j])< k) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
