package recursion;

public class Factorial_Sum {
    public static void main(String[] args) {
        System.out.println(fact(5));
        int val = 5909;
        System.out.println(val/10);
    }

    static int fact(int n){
        if(n == 1){
            return 1;
        }

        return n * fact(n - 1);
    }

    static int sum(int n){
        if(n == 1){
            return 1;
        }

        return n + sum(n - 1);
    }
}
