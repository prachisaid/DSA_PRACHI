package Graphs;

import java.util.*;

public class NetworkDelay {
	class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		List<List<Pair>> adj = adjList(times, n);

		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.offer(new Pair(k, 0));
		dist[k] = 0;

		while(!pq.isEmpty()) {
			int node = pq.peek().first;
			int cost = pq.peek().second;
			pq.poll();

			for(Pair p : adj.get(node)) {
				int adjNode = p.first;
				int adjCost = p.second + cost;

				if(dist[adjNode] > adjCost) {
					dist[adjNode] = adjCost;
					pq.offer(new Pair(adjNode, adjCost));
				}
			}
		}

		int ans = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			if(dist[i] == Integer.MAX_VALUE) return -1;
			if(i != k) {
				ans = Math.max(dist[i], ans);
			}
		}

		return ans;
	}

	private List<List<Pair>> adjList(int[][] times, int n) {
		List<List<Pair>> adj = new ArrayList<>();

		for(int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}

		for(int[] time : times) {
			adj.get(time[0]).add(new Pair(time[1], time[2]));
		}

		return adj;
	}

	public static void main(String[] args) {
		
	}
}
