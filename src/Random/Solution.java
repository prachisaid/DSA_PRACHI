package Random;
import java.util.*;

class Solution {
	class Pair {
		int first;
		int second;

		Pair(int f, int s) {
			this.first = f;
			this.second = s;
		}
	}
	public int[] longestSpecialPath(int[][] edges, int[] nums) {
		int n = edges.length;
		List<List<Pair>> adj = getAdj(edges, n);
		System.out.println(adj);
		int length = 0;
		int size = 1;

		for(int i = 0; i <= n; i++) {
			Set<Integer> set = new HashSet<>();
			set.add(nums[i]);
			int[] ans = solution(adj, i, 0, 1, nums, set);
			if(ans[0] > length) {
				length = ans[0];
				size = ans[1];
			}
			if(ans[0] == length && ans[1] < size) {
				size = ans[1];
			}
		}

		int[] ans = new int[2];
		ans[0] = length;
		ans[1] = size;
		return ans;
	}

	private int[] solution(List<List<Pair>> adj, int ind, int largest, int size, int[] nums, Set<Integer> set) {
		List<Pair> lst = adj.get(ind);
		int[] ans = new int[2];
		ans[1] = 1;

		for(Pair i : lst) {
			if(!set.contains(nums[i.first])) {
				set.add(nums[i.first]);
				ans = solution(adj, i.first, largest + i.second, size + 1, nums, set);
			}
		}

		if(ans[0] < largest) {
			ans[0] = largest;
			ans[1] = size;
		}

		return ans;
	}

	private List<List<Pair>> getAdj(int[][] edges, int n) {
		List<List<Pair>> adj = new ArrayList<>();

		for(int i = 0; i <= n; i++) {
			List<Pair> lst = new ArrayList<>();
			adj.add(lst);
		}

		for(int i = 0; i < n; i++){
			int u = edges[i][0];
			int v = edges[i][1];
			int wt = edges[i][2];

			adj.get(u).add(new Pair(v, wt));
		}

		return adj;
	}

	public static void main(String[] args) {
		int[][] edges = {{0,1,2},{1,2,3},{1,3,5},{1,4,4},{2,5,6}};
		int[] nums = {2,1,2,1,3,1};

//		int[][] edges = {{1, 0, 3}};
//		int[] nums = {5, 4};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.longestSpecialPath(edges, nums)));
	}
}
