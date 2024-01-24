package Trees;

public class RangeSumBST extends BinarySearchTree{
    public static void main(String[] args) {

    }

    public int rangeSumBST(Node root, int low, int high) {
        return traversal(root, low, high);
    }

    private int traversal(Node root, int low, int high) {
        if(root == null) return 0;

        int left = traversal(root.left, low, high);
        int right = traversal(root.right, low, high);
        int ans = 0;

        if(root.value >= low && root.value <= high) {
            ans += root.value;
        }

        ans += left + right;

        return ans;
    }
}
