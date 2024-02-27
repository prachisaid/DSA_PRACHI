package BitManipulation;

public class PowerOf2 {
    public static void main(String[] args) {
        int num = 8;

        if(num == 0) System.out.println("No");
        if((num & (num - 1))== 0) System.out.println("Yes");
        else System.out.println("No");
    }
}
