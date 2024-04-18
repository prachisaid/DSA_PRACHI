package Trees;

import java.util.*;

public class SmallestStringFromLeaf extends BinaryTreeDemo{
    public static void main(String[] args) {

    }

    public String smallestFromLeaf(Node root) {
        ArrayList<String> lst = new ArrayList<>();
        findPath(root, "", lst);

        Collections.sort(lst);
        // System.out.println(lst);

        return lst.get(0);
    }

    private void findPath(Node root, String str, ArrayList<String> lst) {
        if(root == null) {
            return;
        }

        str += (char) (97 + root.value);

        if(root.left == null && root.right == null) {
            StringBuilder s = new StringBuilder(str);
            lst.add(s.reverse().toString());
            return;
        }

        findPath(root.left, str, lst);
        findPath(root.right, str, lst);
    }
}
