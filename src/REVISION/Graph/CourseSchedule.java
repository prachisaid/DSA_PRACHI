package REVISION.Graph;

import java.util.*;

public class CourseSchedule {
	public static void main(String[] args) {
		CourseSchedule obj = new CourseSchedule();
		int[][] preq = {
			{1, 0},
			{0, 1}
		};
		System.out.println(obj.canFinish(2, preq));
	}

	public boolean canFinish(int V, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for(int[] arr : prerequisites) {
			adj.get(arr[0]).add(arr[1]);
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

		int topoCount = 0;

		while(!q.isEmpty()) {
			int node = q.poll();
			topoCount += 1;

			for(int adjNode : adj.get(node)) {
				indegree[adjNode] -= 1;

				if(indegree[adjNode] == 0) {
					q.offer(adjNode);
				}
			}
		}

		return (topoCount == V);
	}
}
