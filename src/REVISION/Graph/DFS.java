package REVISION.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
	public static void main(String[] args) {
		List<Integer> ans = new ArrayList<>();
		int[] visited = new int[10];
		dfs(1, adjList(9, 9), visited, ans);
		System.out.println(ans);
	}

	public static void dfs(int node, List<List<Integer>> adj, int[] visited, List<Integer> ans) {
		visited[node] = 1;
		ans.add(node);

		for(int neighbour : adj.get(node)) {
			if(visited[neighbour] == 0) {
				dfs(neighbour, adj, visited, ans);
			}
		}
	}

	public static List<List<Integer>> adjList(int N, int M) {
		List<List<Integer>> adj = new ArrayList<>();

		for(int i = 0; i <= N; i++) {
			adj.add(new ArrayList<>());
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter edges");

		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		return adj;
	}
}
