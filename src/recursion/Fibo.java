package recursion;

public class Fibo {

    public static void main(String[] args) {
        System.out.println(fibo(50));
    }

    static int fibo(int n){
        int ans = 0;
        if(n < 2){
            return n;
        }

        ans = fibo(n - 1) + fibo(n - 2);
        return ans;
    }
}
