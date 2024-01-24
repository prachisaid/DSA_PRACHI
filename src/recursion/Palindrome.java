package recursion;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome(2147483647));

    }

    static long reverse2(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n , digits);
    }

    static long helper(long n, long digits) {
        if(n%10 == n){
            return n;
        }

        long rem = n % 10;

        return (long)(rem * Math.pow(10, digits-1) + helper(n/10, digits-1));
    }

    static boolean palindrome(int n){
        return n == reverse2(n);
    }
}
