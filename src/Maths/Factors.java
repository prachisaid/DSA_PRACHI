package Maths;

public class Factors {
    public static void main(String[] args) {
        factors(36);
    }

    private static void factors(int num) {
        // O(n)
//        for(int i = 1; i < num; i++) {
//            if(num % i == 0) {
//                System.out.println(i);
//            }
//        }

        // O(sqrt(n))
        for(int i = 1; i * i <= num; i++) {
            if(num % i == 0) {
                if(num/i == i) {
                    System.out.println(i);
                }else{
                    System.out.println(i + " " + num / i);
                }
            }
        }
    }
}
