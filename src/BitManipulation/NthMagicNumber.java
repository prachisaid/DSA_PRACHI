package BitManipulation;

public class NthMagicNumber {
    public static void main(String[] args) {
        System.out.println(magicNumber(2));
    }

    public static int magicNumber(int num) {
        int ans = 0;
        int i = 1;
        while (num != 0) {
            ans += (int) ((num & 1) * Math.pow(5, i));
            i++;
            num = num >> 1;
        }

        return ans;
    }
}
