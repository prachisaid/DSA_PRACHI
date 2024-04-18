package Trees;

public class SameTree extends BinaryTreeDemo{
    public static void main(String[] args) {

    }

    public boolean isSameTree(Node p, Node q) {
        if(p == null && q == null){
            return true;
        }

        boolean left = false, right = false;

        if(p != null && q != null && p.value == q.value){
            left = isSameTree(p.left, q.left);
            right = isSameTree(p.right, q.right);
        }

        return left && right;
    }
}
