package Trees;

public class SecondMinimumNodeInBT extends BinaryTreeDemo{
	public static void main(String[] args) {
		SecondMinimumNodeInBT obj = new SecondMinimumNodeInBT();
		obj.insert();
		System.out.println(obj.findSecondMinimumValue(obj.root));
	}

	public int findSecondMinimumValue(Node root) {
		long[] first = new long[1];
		long[] second = new long[1];

		first[0] = second[0] = Long.MAX_VALUE;

		inorder(root, first, second);

		if(second[0] == Long.MAX_VALUE) return -1;
		int ans = (int) second[0];

		return ans;
	}

	private void inorder(Node root, long[] first, long[] second) {
		if(root == null) return;

		if(first[0] > root.value) {
			second[0] = first[0];
			first[0] = root.value;
		}
		else if(first[0] != root.value && second[0] > root.value) {
			second[0] = root.value;
		}

		inorder(root.left, first, second);
		inorder(root.right, first, second);
	}
}
