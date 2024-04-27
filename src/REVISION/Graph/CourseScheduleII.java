package REVISION.Graph;

import java.util.*;

public class CourseScheduleII {
	public static void main(String[] args) {
		System.out.println('b' - 'a');
	}

	public int[] findOrder(int V, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for(int[] arr : prerequisites) {
			adj.get(arr[1]).add(arr[0]);
		}


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

		int[] topo = new int[V];
		int i = 0;

		while(!q.isEmpty()) {
			int node = q.poll();
			topo[i++] = node;

			for(int adjNode : adj.get(node)) {
				indegree[adjNode] -= 1;

				if(indegree[adjNode] == 0) {
					q.offer(adjNode);
				}
			}
		}

		if(i == V) return topo;
		int[] arr = new int[0];

		return arr;
	}
}
