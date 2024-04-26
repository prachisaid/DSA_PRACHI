package REVISION.Graph;

import java.util.*;

public class TopologicalSortDFS {
	public static void main(String[] args) {
		TopologicalSortDFS obj = new TopologicalSortDFS();
		System.out.println(Arrays.toString(obj.topoSort(6, obj.adjList(6, 6))));
	}

	public int[] topoSort(int V, List<List<Integer>> adj) {
		Stack<Integer> stack = new Stack<>();
		int[] vis = new int[V];
		int[] topo = new int[V];

		for(int i = 0; i < V; i++) {
			if(vis[i] == 0) {
				dfs(i, adj, stack, vis);
			}
		}

		int i = 0;
		while(!stack.isEmpty()) {
			topo[i++] = stack.pop();
		}

		return topo;
	}

	private void dfs(int node, List<List<Integer>> adj, Stack<Integer> stack, int[] vis) {
		vis[node] = 1;

		for(int adjNode : adj.get(node)) {
			if(vis[adjNode] == 0) {
				dfs(adjNode, adj, stack, vis);
			}
		}

		stack.push(node);
	}

	private List<List<Integer>> adjList(int N, int M) {
		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter edges");

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj.get(u).add(v);
		}

		return adj;
	}
}
