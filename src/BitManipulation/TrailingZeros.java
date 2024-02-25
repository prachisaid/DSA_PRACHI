package BitManipulation;

public class TrailingZeros {
    public static void main(String[] args) {
        System.out.println(solve(18));
    }
    public static int solve(int A) {
        int mask = 1;
        int cnt = 0;

        while(A != 0) {
            if((A & mask) == 0) {
                cnt += 1;
                A = A >> 1;
            }
            else {
                break;
            }
        }

        return cnt;
    }
}
