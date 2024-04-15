package Trees;

public class MaximumDepthOfBT extends BinaryTreeDemo{
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        return recursive(root, 0);
    }

    private int recursive(Node root, int cnt) {
        if(root == null) {
            return cnt;
        }

        int left = recursive(root.left, cnt + 1);
        int right = recursive(root.right, cnt + 1);

        return Math.max(left, right);
    }
}
