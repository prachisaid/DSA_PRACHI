package Trees;

import java.util.ArrayList;

public class SumRootToLeafNumber extends BinaryTreeDemo{
    public static void main(String[] args) {

    }

    public int sumNumbers(Node root) {
        ArrayList<String> lst = new ArrayList<>();
        findPath(root, "", lst);

        int sum = 0;

        for(String s : lst) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    private void findPath(Node root, String str, ArrayList<String> lst) {
        if(root == null) {
            return;
        }

        str += root.value;

        if(root.left == null && root.right == null) {
            lst.add(str);
            return;
        }

        findPath(root.left, str, lst);
        findPath(root.right, str, lst);
    }
}
