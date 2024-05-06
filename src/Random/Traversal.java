package Random;

import java.util.*;

public class Traversal {
	List<String> vertex = new ArrayList<>();

	public static void main(String[] args) {
		// BFS
		Traversal obj = new Traversal();
		List<List<Integer>> lst = obj.adjList(5, 4);
		System.out.println(obj.bfsOfGraph(lst, 5));

		// DFS
		int[] visited = new int[5];
		List<Integer> ans = new ArrayList<>();
		obj.dfs(0, lst, visited, ans);
		System.out.println(ans);
	}

	public void dfs(int node, List<List<Integer>> adj, int[] visited, List<Integer> ans) {
		visited[node] = 1;
		ans.add(node);

		for(int neighbour : adj.get(node)) {
			if(visited[neighbour] == 0) {
				dfs(neighbour, adj, visited, ans);
			}
		}
	}

	public ArrayList<String> bfsOfGraph(List<List<Integer>> adj, int V) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited= new int[V];
		ArrayList<Integer> ans = new ArrayList<>();

		q.add(0);
		visited[0] = 1;

		while(!q.isEmpty()) {
			int node = q.poll();
			ans.add(node);

			System.out.println(vertex.get(node));
			for(int neighbour : adj.get(node)) {
				if(visited[neighbour] == 0) {
					q.add(neighbour);
					visited[neighbour] = 1;
				}
			}
		}

		ArrayList<String> answer = new ArrayList<>();
		for(int i = 0; i < ans.size(); i++) {
			answer.add(vertex.get(ans.get(i)));
		}

		return answer;
	}

	private List<List<Integer>> adjList(int N, int M) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < N; i++) {
			adj.add(new ArrayList<>());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter all the cities");

		for(int i = 0; i < N; i++) {
			vertex.add(sc.nextLine());
		}

		System.out.println("Enter edges");

		for(int i = 0; i < M; i++) {
			String start = sc.nextLine();
			String end = sc.nextLine();

			int u = vertex.indexOf(start);
			int v = vertex.indexOf(end);

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		return adj;
	}
}
