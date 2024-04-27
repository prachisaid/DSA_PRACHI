package REVISION.Graph;

import java.util.*;

public class ShortestPathSourceUndirected {

	static class Pair {
		int first;
		int weight;

		Pair(int first, int weight) {
			this.first = first;
			this.weight = weight;
		}
	}
	public static void main(String[] args) {
		int[][] edges = {
			{0, 1, 2},
			{0, 2, 4},
			{1, 2, 1}
		};

		System.out.println(Arrays.toString(shortestPath(3, edges)));
	}

	public static int[] shortestPath(int N, int[][] edges) {
		List<List<Pair>> adj = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			List<Pair> temp = new ArrayList<>();
			adj.add(temp);
		}

		for(int[] edge : edges) {
			adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
			adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
		}

		Queue<Pair> q = new LinkedList<>();
		int[] dist = new int[N];
		Arrays.fill(dist, (int)(1e9));
		dist[0] = 0;
		q.add(new Pair(0, 0));

		while(!q.isEmpty()) {
			int node = q.peek().first;
			int weight = q.peek().weight;
			q.poll();

			for(Pair pair : adj.get(node)) {
				int adjNode = pair.first;
				int adjDist = pair.weight;

				if(adjDist + weight < dist[adjNode]) {
					dist[adjNode] = adjDist + weight;
 					q.add(new Pair(adjNode, adjDist + weight));
				}
			}
		}

		return dist;
	}
}
