package Trees;

import java.util.*;

public class MostFrequentSubtreeSum extends BinaryTreeDemo{
	public static void main(String[] args) {
		MostFrequentSubtreeSum obj = new MostFrequentSubtreeSum();
		obj.insert();
		System.out.println(Arrays.toString(obj.findFrequentTreeSum(obj.root)));
	}

	public int[] findFrequentTreeSum(Node root) {
		int[] maxFreq = new int[1];
		Map<Integer, Integer> map = new HashMap<>();
		postorder(root, map, maxFreq);

		List<Integer> ans = new ArrayList<>();

		for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
			if(mp.getValue() == maxFreq[0]) {
				ans.add(mp.getKey());
			}
		}

		int[] arr = new int[ans.size()];
		for(int i = 0; i < ans.size(); i++) {
			arr[i] = ans.get(i);
		}

		return arr;

	}

	private void postorder(Node root, Map<Integer, Integer> map, int[] maxFreq) {
		if(root == null) return;

		postorder(root.left, map, maxFreq);
		postorder(root.right, map, maxFreq);

		int sum = 0;

		if(root.left != null) sum += root.left.value;
		if(root.right != null) sum += root.right.value;

		sum += root.value;

		root.value = sum;

		if(map.containsKey(sum)) {
			map.put(sum, map.get(sum) + 1);
			maxFreq[0] = Math.max(maxFreq[0], map.get(sum));
		}
		else{
			map.put(sum, 1);
			maxFreq[0] = Math.max(maxFreq[0], 1);
		}
	}
}
