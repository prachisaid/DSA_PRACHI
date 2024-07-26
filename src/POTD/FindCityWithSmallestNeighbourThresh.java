package POTD;

import java.util.*;

public class FindCityWithSmallestNeighbourThresh {
	public static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public int findTheCity(int n, int[][] edges, int distanceThreshold) {
		List<List<Pair>> adj = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		for(int[] edge : edges) {
			adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
			adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
		}

		int smallestCities = Integer.MAX_VALUE;
		int greatestAns = 0;

		for(int i = 0; i < n; i++) {
			int ans = findDistance(i, n, adj, distanceThreshold);
			if(ans <= smallestCities) {
				smallestCities = ans;
				greatestAns = i;
			}
		}

		return greatestAns;
	}

	public int findDistance(int start, int n, List<List<Pair>> adj, int thres) {
		// int[] visited = new int[n];
		int[] dist = new int[n];

		Arrays.fill(dist, (int) (1e9));
		Queue<Pair> q = new LinkedList<>();

		// visited[start] = 1;
		q.add(new Pair(start, 0));

		while(!q.isEmpty()) {
			int node = q.peek().first;
			int weight = q.peek().second;
			q.poll();

			for(Pair adjNode : adj.get(node)) {
				int sum = adjNode.second + weight;
				if(dist[adjNode.first] > sum) {
					// System.out.println(adjNode.first + " " + sum);
					if(sum <= thres) {
						q.add(new Pair(adjNode.first, sum));
						dist[adjNode.first] = sum;
					}
				}
			}
		}

		// System.out.println(Arrays.toString(dist));
		int size = 0;
		for(int i = 0; i < n; i++) {
			if(dist[i] != (int)(1e9) && i != start) size++;
		}

		// System.out.println(size);
		// System.out.println();
		return size;
	}

	public static void main(String[] args) {

	}
}
