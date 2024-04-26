package REVISION.Graph;

import java.util.*;

public class DetectCycleDirectedTOPO {
	public static void main(String[] args) {
		DetectCycleDirectedTOPO obj = new DetectCycleDirectedTOPO();
		System.out.println(obj.isCyclic(5, obj.adjList(5, 5)));
	}

	public boolean isCyclic(int V, List<List<Integer>> adj) {
		int[] indegree = new int[V];

		for(int i = 0; i < V; i++) {
			for(int it : adj.get(i)) {
				indegree[it] += 1;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0; i < V; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}

		int topoCount = 0;

		while(!q.isEmpty()) {
			int node = q.poll();
			topoCount += 1;

			for(int adjNode : adj.get(node)) {
				indegree[adjNode] -= 1;

				if(indegree[adjNode] == 0) {
					q.offer(adjNode);
				}
			}
		}

		return !(topoCount == V);
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
