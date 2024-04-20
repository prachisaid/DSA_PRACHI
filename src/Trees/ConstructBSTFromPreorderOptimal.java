package Trees;

public class ConstructBSTFromPreorderOptimal extends BinaryTreeDemo{
	public static void main(String[] args) {

	}

	public Node bstFromPreorder(int[] preorder) {
		int[] ind = new int[1];
		return construct(preorder, Integer.MAX_VALUE, ind);
	}

	private Node construct(int[] preorder, int ub, int[] ind) {
		if(ind[0] == preorder.length || preorder[ind[0]] > ub) {
			return null;
		}

		Node root = new Node(preorder[ind[0]++]);
		root.left = construct(preorder, root.value, ind);
		root.right = construct(preorder, ub, ind);
		return root;
	}
}
