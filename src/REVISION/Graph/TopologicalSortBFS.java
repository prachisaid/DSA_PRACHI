package REVISION.Graph;

import java.util.*;

public class TopologicalSortBFS {
	public static void main(String[] args) {
		TopologicalSortBFS obj = new TopologicalSortBFS();
		System.out.println(Arrays.toString(obj.topoSort(6, obj.adjList(6, 6))));
	}

	public int[] topoSort(int V, List<List<Integer>> adj) {
		int[] indegree = new int[V];

		for(int i = 0; i < V; i++) {
			for(int it : adj.get(i)) {
				indegree[it] += 1;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0; i < V; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}

		int[] topo = new int[V];
		int i = 0;

		while(!q.isEmpty()) {
			int node = q.poll();
			topo[i++] = node;

			for(int adjNode : adj.get(node)) {
				indegree[adjNode] -= 1;

				if(indegree[adjNode] == 0) {
					q.offer(adjNode);
				}
			}
		}

		return topo;
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
