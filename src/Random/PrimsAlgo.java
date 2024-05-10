package Random;

import java.util.*;

public class PrimsAlgo {
	List<String> vertex = new ArrayList<>();

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static class Tuple {
		int weight;
		int node;
		int parent;

		Tuple(int weight, int node, int parent) {
			this.weight = weight;
			this.node = node;
			this.parent = parent;
		}
	}

	public static void main(String[] args) {
		PrimsAlgo obj = new PrimsAlgo();
		obj.prims(5, obj.adjList(5, 6));
	}

	public void prims(int V, List<List<Pair>> adj) {
		PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
		int[] visited = new int[V];
		List<Pair> ans = new ArrayList<>();
		int sum = 0;

		pq.add(new Tuple(0, 0, -1));

		while(!pq.isEmpty()) {
			int weight = pq.peek().weight;
			int node = pq.peek().node;
			int parent = pq.peek().parent;
			pq.poll();

			if(parent == -1) {
				visited[node] = 1;
			}
			else {
				if(visited[node] == 0) {
					visited[node] = 1;
					sum += weight;
					ans.add(new Pair(parent, node));
				}
			}

			for(Pair it : adj.get(node)) {
				int adjNode = it.first;

				if(visited[adjNode] == 0) {
					pq.add(new Tuple(it.second, adjNode, node));
				}
			}
		}

		for(Pair it : ans) {
			System.out.println(it.first + " " + it.second);
		}
	}

	private List<List<Pair>> adjList(int N, int M) {
		List<List<Pair>> adj = new ArrayList<>();

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

			adj.get(u).add(new Pair(v, wt));
			adj.get(v).add(new Pair(u, wt));
		}

		return adj;
	}
}
