package BitManipulation;

public class BitMaskith {
    public static void main(String[] args) {
        int a = 53;
        int mask = 1;

        // find ith bit;
        mask = mask << 4;
        if((a & mask) == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(1);
        }

        // set ith bit
        mask = 1;
        int ans = a | (mask << 3);
        System.out.println(ans);

        // clear ith bit
        ans = a & ~(mask << 4);
        System.out.println(ans);
    }
}
