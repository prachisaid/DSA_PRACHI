package Trees;

import java.util.ArrayList;
import java.util.List;

public class PseudoPalindromeOptimal extends BinarySearchTree{
    public static void main(String[] args) {
        PseudoPalindromeOptimal obj = new PseudoPalindromeOptimal();
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(3);
        obj.insert(1);
        obj.insert(1);

        System.out.println(obj.pseudoPalindromicPaths(obj.root));
    }

    public int pseudoPalindromicPaths (Node root) {
        int[] digits = new int[10];
        return path(root, digits);
    }

    private static int path(Node root, int[] digits) {
        if(root == null) return 0;

        digits[root.value]++;
        if(root.left == null && root.right == null) {
            int cnt = countOdd(digits);
            digits[root.value]--;
            return (cnt <= 1) ? 1 : 0;
        }

        int left = path(root.left, digits);
        int right = path(root.right, digits);
        digits[root.value]--;

        return left + right;
    }

    private static int countOdd(int[] digits) {
        int cnt = 0;
        for(int i = 1; i < 10; i++) {
            if(digits[i] % 2 == 1) cnt++;
        }

        return cnt;
    }
}
