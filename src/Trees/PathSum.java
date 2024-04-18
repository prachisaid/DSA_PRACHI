package Trees;

public class PathSum extends BinaryTreeDemo{
    public static void main(String[] args) {

    }

    public boolean hasPathSum(Node root, int targetSum) {
        return findPath(root, 0, targetSum);
    }

    private boolean findPath(Node root, int pathsum, int target) {
        if(root == null) {
            return false;
        }

        pathsum += root.value;

        if(root.left == null && root.right == null) {
            if(pathsum == target) {
                return true;
            }
            else {
                return false;
            }
        }

        if(findPath(root.left, pathsum, target)) return true;
        if(findPath(root.right, pathsum, target)) return true;

        return false;
    }
}
