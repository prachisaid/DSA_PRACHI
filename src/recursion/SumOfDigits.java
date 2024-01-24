package recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(132));
    }

    static int sum(int val){
        if(val/10 == 0){
             return val;
        }

        int mod = val%10;

        return mod + sum(val/10);
    }

    static int mul(int val){
        if(val/10 == 0){
            return val;
        }

        int mod = val%10;

        return mod * sum(val/10);
    }
}
