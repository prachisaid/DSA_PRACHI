package BitManipulation;

public class SingleNumberI {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 5, 1, 4, 4, 7, 3, 3};
        System.out.println((new SingleNumberI().singleNumber(arr)));
    }

    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) {
            xor = xor ^ num;
        }

        return xor;
    }
}
