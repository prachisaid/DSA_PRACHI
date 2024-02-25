package BitManipulation;

public class OddOrEven {
    public static void main(String[] args) {
        int a = 10;

        if((a & 1) == 1) {
            System.out.println("Odd");
        }
        else {
            System.out.println("Even");
        }
    }
}
