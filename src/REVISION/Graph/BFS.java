package REVISION.Graph;

import java.util.*;

public class BFS {
	public static void main(String[] args) {
		BFS obj = new BFS();
		System.out.println(obj.bfsOfGraph(obj.adjList(9, 9), 9));
	}

	public ArrayList<Integer> bfsOfGraph(List<List<Integer>> adj, int V) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited= new int[V + 1];
		ArrayList<Integer> ans = new ArrayList<>();

		q.add(1);
		visited[1] = 1;

		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(node);

			for(int neighbour : adj.get(node)) {
				if(visited[neighbour] == 0) {
					q.add(neighbour);
					visited[neighbour] = 1;
				}
			}
		}

		return ans;
	}

	private List<List<Integer>> adjList(int N, int M) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter edges");

		for(int i = 0; i < M; i++) {
//			System.out.println(i);
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		return adj;
	}
}
