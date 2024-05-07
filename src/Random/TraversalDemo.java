package Random;

import java.util.*;

public class TraversalDemo {
	List<String> vertex = new ArrayList<>();
	public static void main(String[] args) {
		TraversalDemo obj = new TraversalDemo();
		obj.bfs(obj.adjList(3, 2), 3);
	}

	public void bfs(List<List<Integer>> adj, int V) {
		Queue<Integer> q = new LinkedList<>();
		List<String> ans = new ArrayList<>();
		int[] visited = new int[V];

		q.add(0);
		visited[0] = 1;

		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(vertex.get(node));

			for(int adjNode : adj.get(node)) {
				if(visited[adjNode] == 0) {
					q.add(adjNode);
					visited[adjNode] = 1;
				}
			}
		}

		System.out.println(ans);
	}

	private List<List<Integer>> adjList(int N, int M) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			adj.add(new ArrayList<>());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of cities");

		for(int i = 0; i < N; i++) {
			vertex.add(sc.nextLine());
		}

		System.out.println("Enter edges");
		for(int i = 0; i < M; i++) {
			String start = sc.next();
			String end = sc.next();

			int u = vertex.indexOf(start);
			int v = vertex.indexOf(end);

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		return adj;
	}
}
