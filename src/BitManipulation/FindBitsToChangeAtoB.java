package BitManipulation;

public class FindBitsToChangeAtoB {
    public static void main(String[] args) {
        System.out.println(solve(5, 4));
    }

    public static int solve(int a, int b) {
        int xor = a ^ b;
        int mask = 1;
        int cnt = 0;

        while(xor != 0) {
            if((xor & mask) == 1) {
                cnt += 1;
            }
            xor = xor >> 1;
        }

        return cnt;
    }
}
