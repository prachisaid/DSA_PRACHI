package REVISION.Graph;

import java.util.*;

public class BipartiteGraphLeetCode {
	public static void main(String[] args) {

	}

	public boolean isBipartite(int[][] graph) {
		int V = graph.length;
		List<List<Integer>> adj = adjList(V, graph);
		int[] visited = new int[V];
		Arrays.fill(visited, -1);

		for(int i = 0; i < V; i++) {
			if(visited[i] == -1) {
				if(!bfs(adj, V, visited, i)) return false;
			}
		}

		return true;
	}

	private boolean bfs(List<List<Integer>> adj, int V, int[] visited, int src) {
		Queue<Integer> q = new LinkedList<>();

		q.add(src);
		visited[src] = 0;

		while(!q.isEmpty()) {
			int node = q.poll();

			for(int adjacent : adj.get(node)) {
				if(visited[adjacent] == -1) {
					if(visited[node] == 1) {
						visited[adjacent] = 0;
						q.add(adjacent);
					}
					else {
						visited[adjacent] = 1;
						q.add(adjacent);
					}
				}

				else if (visited[adjacent] == visited[node]) return false;
			}
		}

		return true;
	}

	private List<List<Integer>> adjList(int V, int[][] graph) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[i].length; j++) {
				adj.get(i).add(graph[i][j]);
			}
		}

		return adj;
	}
}
