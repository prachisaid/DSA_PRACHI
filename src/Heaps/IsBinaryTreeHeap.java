package Heaps;

import Trees.BinarySearchTree;

public class IsBinaryTreeHeap extends BinarySearchTree {
    boolean isHeap(Node root) {
        int totalCount = countNodes(root);
        return (isCBT(root, 0, totalCount) && isMaxOrder(root));
    }

    public boolean isCompleteTree(Node root) {
        int count = countNodes(root);
        return isCBT(root, 0, count);
    }

    private boolean isCBT(Node root, int i, int count) {
        if (root == null) return true;

        if (i >= count) return false;

        else {
            boolean left = isCBT(root.left, (2 * i + 1), count);
            boolean right = isCBT(root.right, (2 * i + 2), count);

            return (left && right);
        }
    }

    private int countNodes(Node root) {
        if (root == null) return 0;

        int ans = 1 + countNodes(root.left) + countNodes(root.right);

        return ans;

    }

    boolean isMaxOrder(Node root){
        if(root.left == null && root.right == null){
            return true;
        }

        if(root.right == null){
            return (root.value > root.left.value);
        }

        else{
            boolean left = isMaxOrder(root.left);
            boolean right = isMaxOrder(root.right);

            if(left && right && (root.value > root.left.value) && (root.value > root.right.value)){
                return true;
            }
            else{
                return false;
            }
        }
    }
}
