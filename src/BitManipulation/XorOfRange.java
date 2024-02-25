package BitManipulation;

public class XorOfRange {
    public static void main(String[] args) {
        System.out.println(solve(2, 4));
        String ans = Integer.toString(4 % 3);
    }

    public static int solve(int l, int r){
        int xorR = range(r);
        int xorL = range(l - 1);

        return xorR ^ xorL;
    }

    public static int range(int num) {
        if(num % 4 == 0) {
            return num;
        }
        if(num % 4 == 1) {
            return 1;
        }
        if(num % 4 == 2) {
            return num + 1;
        }
        if(num % 4 == 3) {
            return 0;
        }

        return -1;
    }
}
