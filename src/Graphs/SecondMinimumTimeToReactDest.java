package Graphs;

import java.util.*;

public class SecondMinimumTimeToReactDest {
	class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public int secondMinimum(int n, int[][] edges, int time, int change) {
		List<List<Integer>> adj = new ArrayList<>();
		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		// create graph
		for(int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		// initialize variables needed
		int[] dist1 = new int[n + 1];
		int[] dist2 = new int[n + 1];

		Arrays.fill(dist1, Integer.MAX_VALUE);
		Arrays.fill(dist2, Integer.MAX_VALUE);

		int[] freq = new int[n + 1];
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);

		// initial config
		pq.add(new Pair(1, 0));
		dist1[1] = 0;

		// dijkstra algo
		while(!pq.isEmpty()) {
			int node = pq.peek().first;
			int timeTaken = pq.peek().second;
			freq[node]++;
			pq.poll();


			// return if freq is 2
			if(node == n && freq[node] == 2) {
				return timeTaken;
			}

			if((timeTaken / change) % 2 == 1) {
				timeTaken = timeTaken + (change - (timeTaken % change)) + time;
			}
			else {
				timeTaken += time;
			}

			for(int adjNode : adj.get(node)) {
				if(freq[adjNode] == 2) continue;

				if(dist1[adjNode] > timeTaken) {
					dist2[adjNode] = dist1[adjNode];
					dist1[adjNode] = timeTaken;
					pq.add(new Pair(adjNode, timeTaken));
				}
				else if(dist2[adjNode] > timeTaken && dist1[adjNode] != timeTaken) {
					dist2[adjNode] = timeTaken;
					pq.add(new Pair(adjNode, timeTaken));
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {

	}
}
