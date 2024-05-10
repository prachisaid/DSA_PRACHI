package Random;

import java.util.*;

public class DijkstraRev {
	List<String> vertex = new ArrayList<>();
	static class Pair {
		int distance;
		int node;

		Pair(int distance, int node) {
			this.distance = distance;
			this.node = node;
		}
	}

	static class Node {
		int node;
		int weight;

		Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}
	public static void main(String[] args) {
		DijkstraRev obj = new DijkstraRev();
		obj.dijkstra(3, obj.adjList(3, 3), 0);
	}

	public void dijkstra(int V, List<List<Node>> adj, int S) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
		int[] dist = new int[V];
		Arrays.fill(dist, (int) (1e9));

		pq.add(new Pair(0, S));
		dist[S] = 0;

		while(!pq.isEmpty()) {
			int distance = pq.peek().distance;
			int node = pq.peek().node;
			pq.poll();

			for(Node it : adj.get(node)) {
				int adjNode = it.node;
				int weight = it.weight;
				int totalDist = distance + weight;

				if(totalDist < dist[adjNode]) {
					dist[adjNode] = totalDist;
					pq.add(new Pair(totalDist, adjNode));
				}
			}
		}

		System.out.println(Arrays.toString(dist));
	}

	private List<List<Node>> adjList(int N, int M) {
		List<List<Node>> adj = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			adj.add(new ArrayList<>());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter all the cities");

		for(int i = 0; i < N; i++) {
			vertex.add(sc.nextLine());
		}

		System.out.println("Enter the distance");
		for(int i = 0; i < M; i++) {
			String start = sc.next();
			String end = sc.next();
			int wt = sc.nextInt();

			int u = vertex.indexOf(start);
			int v = vertex.indexOf(end);

			adj.get(u).add(new Node(v, wt));
			adj.get(v).add(new Node(u, wt));
		}

		return adj;
	}
}
