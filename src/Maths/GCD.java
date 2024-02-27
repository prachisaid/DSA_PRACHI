package Maths;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(4, 12));
        System.out.println((18 * 12) / gcd(12, 18));
    }

    private static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
}
