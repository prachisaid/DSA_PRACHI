package Random;

class Solution2 {
	public static void main(String[] args) {
		String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		System.out.println(isValidSerialization(s));

		System.out.println(Integer.compare(5, 6));
	}

	public static boolean isValidSerialization(String preorder) {
		String[] val = preorder.split(",");
		int[] ind = new int[1];
		boolean ans = helper(val, ind);
		return ans && ind[0] >= val.length;
	}

	private static boolean helper(String[] preorder, int[] ind) {
		if(ind[0] == preorder.length) return true;

		boolean left = false;
		boolean right = false;
		// Left
		ind[0] += 1;
		if(ind[0] == preorder.length) return false;
		else if(!preorder[ind[0]].equals("#")) {
			left = helper(preorder, ind);
		}
		else {
			left = true;
		}

		// Right
		ind[0] += 1;
		if(ind[0] == preorder.length) return false;
		else if(!preorder[ind[0]].equals("#")) {
			right = helper(preorder, ind);
		}
		else {
			right = true;
		}

		return left && right;
	}
}
