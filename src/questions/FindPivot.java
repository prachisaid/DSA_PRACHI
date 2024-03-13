package questions;

public class FindPivot {
    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }

    public static int pivotInteger(int n) {

        for(int i = 1; i <= n; i++) {
            int prefix = 0;
            int suffix = 0;

            for(int j = 1; j <= i; j++) {
                prefix += j;
            }

            for(int j = i; j <=n; j++) {
                suffix += j;
            }

            if(prefix == suffix) return i;
        }

        return -1;
    }
}
