package REVISION.Graph;

import java.util.*;

public class BipartiteGraphDFS {
	public static void main(String[] args) {
		BipartiteGraphDFS obj = new BipartiteGraphDFS();
		System.out.println(obj.isBipartite(obj.adjList(6, 6), 6));
	}

	public boolean isBipartite(List<List<Integer>> adj, int V) {
		int[] visited = new int[V];
		Arrays.fill(visited, -1);

		visited[0] = 0;
		return dfs(0, adj, visited);
	}

	private boolean dfs(int node, List<List<Integer>> adj, int[] visited) {
		for(int adjNode : adj.get(node)) {
			if(visited[adjNode] == -1) {
				visited[adjNode] = 1 - visited[node];
				if(!dfs(adjNode, adj, visited)) return false;
			}
			else if(visited[adjNode] == visited[node]) return false;
		}

		return true;
	}

	private List<List<Integer>> adjList(int V, int E) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i <= V; i++) {
			adj.add(new ArrayList<>());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter edges ");

		for(int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		return adj;
	}
}
