package REVISION.Graph;

import Graphs.DetectCycleBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DetectCycleUndirectedBFS {
	static class Pair {
		int node;
		int parent;

		Pair(int node, int parent) {
			this.node = node;
			this.parent = parent;
		}
	}

	public static void main(String[] args) {
		DetectCycleUndirectedBFS obj = new DetectCycleUndirectedBFS();
		System.out.println(obj.isCycle(3, obj.adjList(3, 2)));
	}

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] visited = new int[V];

		for(int i = 0; i < V; i++) {
			if(visited[i] == 0) {
				if(checkForCycle(i, V, adj, visited)) return true;
			}
		}

		return false;
	}

	private boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, int[] visited) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src, -1));
		visited[src] = 1;

		while(!q.isEmpty()) {
			int node = q.peek().node;
			int parent = q.peek().parent;
			q.poll();

			for(int neighbour : adj.get(node)) {
				if(visited[neighbour] == 0) {
					q.add(new Pair(neighbour, node));
					visited[neighbour] = 1;
				}
				else if(parent != neighbour) {
					return true;
				}
			}
		}

		return false;
	}

	private ArrayList<ArrayList<Integer>> adjList(int V, int E) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for(int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}

		System.out.println("Enter edges");
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		return adj;
	}
}
