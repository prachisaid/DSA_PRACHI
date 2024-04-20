package Trees;

import java.util.*;

class BSTIteratorHelper extends BinaryTreeDemo{
	Stack<Node> stack = new Stack<>();
	boolean reverse = true;

	public BSTIteratorHelper(Node root, boolean isReverse) {
		this.reverse = isReverse;
		pushAll(root);
	}

	public void pushAll(Node root) {
		while(root != null) {
			stack.push(root);

			if(reverse) {
				root = root.right;
			}
			else{
				root = root.left;
			}
		}
	}

	public int next() {
		Node node = stack.pop();

		if(reverse) pushAll(node.left);
		else pushAll(node.right);

		return node.value;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}
}

public class TwoSumIV extends BinaryTreeDemo{
	public static void main(String[] args) {
		TwoSumIV obj = new TwoSumIV();
		obj.insert();
		System.out.println(obj.findTarget(obj.root, 9));
	}

	public boolean findTarget(Node root, int k) {
		BSTIteratorHelper l = new BSTIteratorHelper(root, false);
		BSTIteratorHelper r = new BSTIteratorHelper(root, true);

		int i = l.next(), j = r.next();

		while(i < j) {
			if(i + j == k) return true;

			if(i + j > k) j = r.next();
			else i = l.next();
		}

		return false;
	}
}
