package REVISION.Graph;

import Graphs.DijkstraPQ;

import java.util.*;

public class DijkstraPriorityQueue {
	List<String> vertex = new ArrayList<>();
	static class Pair{
		int distance;
		int node;

		Pair(int d, int n) {
			this.distance = d;
			this.node = n;
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
		DijkstraPriorityQueue dj = new DijkstraPriorityQueue();
		System.out.println(Arrays.toString(dj.dijkstra(3, dj.adjList(3, 3), 0)));
	}

	public int[] dijkstra(int V, ArrayList<ArrayList<Node>> adj, int S) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
		int[] dist = new int[V];
		Arrays.fill(dist, (int) (1e9));

		pq.add(new Pair(0, S));
		dist[S] = 0;

		while(!pq.isEmpty()) {
			int distance = pq.peek().distance;
			int node = pq.peek().node;

			pq.poll();

			for(int i = 0; i < adj.get(node).size(); i++) {
				Node curr = adj.get(node).get(i);
				System.out.println(curr.node);
				int edgeWeight = curr.weight;
				int adjNode = curr.node;

				int newDist = edgeWeight + distance;

				if(dist[adjNode] > newDist) {
					pq.add(new Pair(newDist, adjNode));
					dist[adjNode] = newDist;
				}
			}
		}

		String start = vertex.get(S);
		for(int i = 0; i < V; i++) {
			System.out.println(start + "->" + vertex.get(i) + " = " + dist[i]);
		}

		return dist;
	}

	private ArrayList<ArrayList<Node>> adjList(int n, int m){
		ArrayList<ArrayList<Node>> adj = new ArrayList<>();
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

			adj.get(u).add(new Node(v, w));
			adj.get(v).add(new Node(u, w));
		}

//		for(ArrayList<Node> lst: adj) {
//			for(Node node : lst) {
//				System.out.print(node.node);
//			}
//		}
		return adj;
	}
}
