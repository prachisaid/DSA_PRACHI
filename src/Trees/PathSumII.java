package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII extends BinaryTreeDemo{
    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(Node root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();

        findPath(root, targetSum, 0, ans, new ArrayList<>());

        return ans;
    }

    private void findPath(Node root, int target, int sum, List<List<Integer>> ans, List<Integer> lst) {
        if(root == null) {
            return;
        }

        sum += root.value;
        lst.add(root.value);

        if(root.left == null && root.right == null) {
            if(sum == target) {
                ans.add(new ArrayList<>(lst));
            }

            return;
        }

        if(root.left != null) {
            findPath(root.left, target, sum, ans, lst);
            lst.remove(lst.size() - 1);
        }

        if(root.right != null) {
            findPath(root.right, target, sum, ans, lst);
            lst.remove(lst.size() - 1);
        }
    }
}
