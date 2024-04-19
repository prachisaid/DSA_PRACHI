package Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MorrisTraversal extends BinaryTreeDemo{
	public static void main(String[] args) {
		MorrisTraversal obj = new MorrisTraversal();
		obj.insert();
		obj.morrisTraversal(obj.root);
	}

	public void morrisTraversal(Node curr) {
		if(root == null) return;

		ArrayList<Integer> ans = new ArrayList<>();

		while(curr != null) {
			if(curr.left == null) {
				ans.add(curr.value);
				curr = curr.right;
			}

			else {
				Node prev = curr.left;

				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}

				if(prev.right == null) {
					prev.right = curr;
					curr = curr.left;
				}
				else {
					prev.right = null;
					ans.add(curr.value);
					curr = curr.right;
				}
			}
		}

		System.out.println(ans);
	}
}
