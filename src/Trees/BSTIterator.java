package Trees;

import java.util.*;

public class BSTIterator extends BinaryTreeDemo{
	Stack<Node> stack;

	public BSTIterator(Node root) {
		stack = new Stack<>();
		insertInStack(root);
	}

	private void insertInStack(Node root) {
		while(root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	public int next() {
		Node node = stack.pop();
		if(node.right != null) insertInStack(node.right);
		return node.value;
	}

	public boolean hasNext() {
		if(stack.isEmpty()) return false;
		else return true;
	}

	public static void main(String[] args) {
		BinaryTreeDemo obj = new BinaryTreeDemo();
		obj.insert();
		BSTIterator obj2 = new BSTIterator(obj.root);
		System.out.println(obj2.next());
	}
}
