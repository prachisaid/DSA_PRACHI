package BitManipulation;

public class XorFrom1ToN {
    public static void main(String[] args) {
        int num = 5;
        range(5);
    }

    public static void range(int num) {
        if(num % 4 == 0) {
            System.out.println(num);
        }
        if(num % 4 == 1) {
            System.out.println(1);
        }
        if(num % 4 == 2) {
            System.out.println(num + 1);
        }
        if(num % 4 == 3) {
            System.out.println(0);
        }
    }
}
