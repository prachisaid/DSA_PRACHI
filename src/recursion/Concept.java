package recursion;

public class Concept {
    public static void main(String[] args) {
//        fun(5);
//        int val = 1;
//        int rev = 4;
//
//        rev = (rev * 10) + val;
//        rev = rev * 10 + 7;
//        System.out.println(rev);
    }

    static void fun(int n){
        if (n == 0) {
            return;
        }

//        fun(n--);
        System.out.println(n);
        fun(--n);
    }
}
