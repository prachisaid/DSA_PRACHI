package REVISION.Graph;

import java.util.*;

public class AlienDictionary {
	public static void main(String[] args) {
		AlienDictionary obj = new AlienDictionary();
		String[] dict = {"baa", "abcd", "abca", "cab", "cad"};

		System.out.println(obj.findOrder(dict, 5, 4));
	}

	public String findOrder(String[] dict, int N, int K)
	{
		List<List<Integer>> adj = adjList(dict, K, N);
		int[] indegree = new int[K];

		for(int i = 0; i < K; i++) {
			for(int it : adj.get(i)) {
				indegree[it] += 1;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0; i < K; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}

		String ans = "";

		while(!q.isEmpty()) {
			int node = q.poll();
			char ch = (char) (node + 'a');
			ans += ch;

			for(int adjNode : adj.get(node)) {
				indegree[adjNode] -= 1;

				if(indegree[adjNode] == 0) {
					q.offer(adjNode);
				}
			}
		}

		return ans;
	}

	private List<List<Integer>> adjList(String[] dict, int V, int N) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		for(int i = 0; i < N - 1; i++) {
			String s1 = dict[i];
			String s2 = dict[i + 1];

			for(int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
				if(s1.charAt(j) != s2.charAt(j)) {
					adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
					break;
				}
			}
		}

		System.out.println(adj);

		return adj;
	}
}
