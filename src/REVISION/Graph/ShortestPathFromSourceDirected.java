package REVISION.Graph;

import java.util.*;

public class ShortestPathFromSourceDirected {
	static class Pair {
		int v;
		int wt;

		Pair(int v, int wt) {
			this.v = v;
			this.wt = wt;
		}
	}

	public static void main(String[] args) {

	}


	public  static int[] shortestPath(int M,int N, int[][] edges) {
		List<List<Pair>> adj = new ArrayList<>();

		for(int i = 0; i < M; i++) {
			List<Pair> temp = new ArrayList<>();
			adj.add(temp);
		}

		for(int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int wt = edge[2];

			adj.get(u).add(new Pair(v, wt));
		}

		int[] vis = new int[M];
		Stack<Integer> s = new Stack<>();

		for(int i = 0; i < M; i++) {
			if(vis[i] == 0) {
				dfs(i, s, vis, adj);
			}
		}

		int[] dist = new int[M];
		Arrays.fill(dist, (int) (1e9));
		dist[0] = 0;

// 		System.out.println(s);

		while(!s.isEmpty()) {
			int node = s.pop();
			int d = dist[node];

			for(Pair pair : adj.get(node)) {
				int currDist = d + pair.wt;
				dist[pair.v] = Math.min(dist[pair.v], currDist);
			}
		}

		for(int i = 0; i < dist.length; i++) {
			if(dist[i] == (int)(1e9)) {
				dist[i] = -1;
			}
		}

		return dist;
	}

	private static void dfs(int node, Stack<Integer> s, int[] vis, List<List<Pair>> adj) {
		vis[node] = 1;

		for(Pair pair : adj.get(node)) {
			int adjNode = pair.v;

			if(vis[adjNode] == 0) {
				dfs(adjNode, s, vis, adj);
			}
		}

		s.push(node);
	}
}
