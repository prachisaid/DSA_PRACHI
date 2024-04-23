package POTD;

import java.util.*;

public class FindMinimumHeightTree {
	public static void main(String[] args) {

	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<List<Integer>> adj = adjList(n, edges);
		List<Integer> lst = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = Integer.MAX_VALUE;

		for(int i = 0; i < n; i++) {
			int val = bfs(adj, i, n);
			if(val <= ans) {
				ans = val;
				map.put(i, ans);
			}
		}

		for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
			if(mp.getValue() == ans) {
				lst.add(mp.getKey());
			}
		}

		return lst;
	}

	private int bfs(List<List<Integer>> adj, int src, int V) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[V];

		q.add(src);
		visited[src] = 1;
		int cnt = 0;

		while(!q.isEmpty()) {
			int size = q.size();

			for(int i = 0; i < size; i++) {
				int node = q.poll();

				for(int adjacent : adj.get(node)) {
					if(visited[adjacent] == 0) {
						q.add(adjacent);
						visited[adjacent] = 1;
					}
				}
			}

			cnt += 1;
		}

		return cnt;
	}

	private List<List<Integer>> adjList(int n, int[][] edges) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for(int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		return adj;
	}
}
