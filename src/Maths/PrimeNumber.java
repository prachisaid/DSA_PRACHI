package Maths;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(20));
    }

    private static boolean isPrime(int num) {
//        for(int i = 2; i < num; i++) {
//            if(num % i == 0) {
//                return false;
//            }
//        }

        for(int i = 2; i * i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
