package BitManipulation;

public class XorOperationInArray {
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }

    public static int xorOperation(int n, int start) {
        int ans = 0;

        for(int i = 0; i < n; i++) {
            ans ^= (start + 2 * i);
        }

        return ans;
    }
}
