package recursion;

public class SubtractSumAndProduct {
    public static void main(String[] args) {
//        System.out.println(subtractProductAndSum(234));
        int n = 1111111101;
        int cnt = 0;

        while(n != 0){
            int rem = n % 10;
            if(rem == 1){
                cnt++;
            }
            n = n / 10;
        }

        System.out.println(cnt);
    }

    public static int subtractProductAndSum(int n) {
        return helper(n, 0, 1);
    }

    private static int helper(int n, int sum, int product){
        if(n == 0){
            return product - sum;
        }

        int rem = n % 10;
        return helper(n/10, sum + rem, product * rem);
    }
}
