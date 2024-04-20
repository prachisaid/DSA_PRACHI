package Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindModeInBST extends BinaryTreeDemo{
	public static void main(String[] args) {
		FindModeInBST obj = new FindModeInBST();
		obj.insert();
		System.out.println(Arrays.toString(obj.findMode(obj.root)));
	}

	public int[] findMode(Node root) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] maxFreq = new int[1];
		int[] cnt = new int[1];

		findMode(root, maxFreq, cnt, map);

		int[] ans = new int[cnt[0]];
		int ind = 0;

		for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
			if(mp.getValue() == maxFreq[0]) {
				ans[ind++] = mp.getKey();
			}
		}

		return ans;
	}

	private void findMode(Node root, int[] maxFreq, int[] cnt, Map<Integer, Integer> map) {
		if(root == null) return;

		map.put(root.value, map.getOrDefault(root.value, 0) + 1);

		if(map.get(root.value) > maxFreq[0]) {
			maxFreq[0] = map.get(root.value);
			cnt[0] = 1;
		}
		else if(map.get(root.value) == maxFreq[0]) cnt[0] += 1;

		findMode(root.left, maxFreq, cnt, map);
		findMode(root.right, maxFreq, cnt, map);
	}
}
