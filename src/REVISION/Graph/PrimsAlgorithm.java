package REVISION.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsAlgorithm {

	static List<String> vertex = new ArrayList<>();

	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second= second;
		}
	}

	static class Tuple {
		int weight;
		int node;
		int parent;

		Tuple(int w, int n, int p) {
			this.weight = w;
			this.node = n;
			this.parent = p;
		}
	}
	public static void main(String[] args) {
		System.out.println(spanningTree(5, 6, adjList(5, 6)));
	}

	public static int spanningTree(int V, int E, List<List<Pair>> adj) {
		int[] visited = new int[V];
		PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
		ArrayList<Pair> lst = new ArrayList<>();
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
					lst.add(new Pair(parent, node));
				}
			}

			for(Pair p : adj.get(node)) {
				int n = p.first;
				int wt = p.second;

				if(visited[n] == 0) {
					pq.add(new Tuple(wt, n, node));
				}
			}
		}

		List<List<String>> mst = new ArrayList<>();

		for(int i = 0; i < V; i++) {
			mst.add(new ArrayList<>());
		}

		for(int i = 0; i < lst.size(); i++) {
			int u = lst.get(i).first;
			int v = lst.get(i).second;

			mst.get(u).add(vertex.get(v));
			mst.get(v).add(vertex.get(u));
		}

		System.out.println(mst);
		return sum;
	}

	private static List<List<Pair>> adjList(int n, int m){
		List<List<Pair>> adj = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		System.out.println("Enter all the cities");
		for(int i = 0; i < n; i++) {
			vertex.add(sc.nextLine());
		}

		System.out.println("Enter edges and weight: ");
		for(int i = 0; i < m; i++) {
			String start = sc.next();
			String end = sc.next();
			int w = sc.nextInt();

			int u = vertex.indexOf(start);
			int v = vertex.indexOf(end);

			adj.get(u).add(new Pair(v, w));
			adj.get(v).add(new Pair(u, w));
		}

		System.out.println(adj);
		return adj;
	}
}
