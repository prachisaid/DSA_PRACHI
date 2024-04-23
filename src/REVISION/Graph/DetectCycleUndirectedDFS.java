package REVISION.Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleUndirectedDFS {
	public static void main(String[] args) {
		DetectCycleUndirectedDFS obj = new DetectCycleUndirectedDFS();
		System.out.println(obj.isCycle(3, obj.adjList(3, 2)));
	}

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] visited = new int[V];
		return checkForCycle(0, -1, visited, adj);
	}

	private boolean checkForCycle(int node, int parent, int[] visited, ArrayList<ArrayList<Integer>> adj) {
		visited[node] = 1;

		for(int adjacent : adj.get(node)) {
			if(visited[adjacent] == 0) {
				if(checkForCycle(adjacent, node, visited, adj)) return true;
			}

			else if(adjacent != parent) return true;
		}

		return false;
	}

	private ArrayList<ArrayList<Integer>> adjList(int V, int E) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
//
//		System.out.println("Enter edges");
//		Scanner sc = new Scanner(System.in);
//
//		for(int i = 0; i < E; i++) {
//			int u = sc.nextInt();
//			int v = sc.nextInt();
//
//			adj.get(u).add(v);
//			adj.get(v).add(u);
//		}
//
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);
		return adj;
	}
}
