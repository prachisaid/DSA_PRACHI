package Maths;

import java.util.Arrays;

public class SieveOfEratosthenes {
    static boolean[] isPrime = new boolean[30];
    public static void main(String[] args) {
        sieve();
        checkPrime(20);
    }

    public static void checkPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(isPrime[i]) {
                System.out.println(i);
            }
        }
    }

    private static void sieve() {
        Arrays.fill(isPrime, true);
        for(int i = 2; i < 30; i++) {
            if(isPrime[i]) {
                for(int j = 2 * i; j < 30; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
