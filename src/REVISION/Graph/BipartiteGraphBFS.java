package REVISION.Graph;

import java.util.*;

public class BipartiteGraphBFS {
	public static void main(String[] args) {
		BipartiteGraphBFS obj = new BipartiteGraphBFS();
		System.out.println(obj.isBipartite(obj.adjList(4, 4),  4));
	}

	public boolean isBipartite(List<List<Integer>> adj, int V) {
		int[] visited = new int[V + 1];
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<>();

		q.add(1);
		visited[1] = 0;

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
