package REVISION.Graph;

import java.util.ArrayList;

public class DetectCycleInDirectedDFS {
	public static void main(String[] args) {

	}

	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		int[] vis = new int[V];
		int[] pathVis = new int[V];

		for(int i = 0; i < V; i++) {
			if(vis[i] == 0) {
				if(dfs(i, adj, vis, pathVis)) return true;
			}
		}

		return false;
	}

	private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
		vis[node] = 1;
		pathVis[node] = 1;

		for(int adjNode : adj.get(node)) {
			if(vis[adjNode] == 0) {
				if(dfs(adjNode, adj, vis, pathVis)) return true;
			}

			else if(vis[adjNode] == 1) {
				if(pathVis[adjNode] == 1) return true;
			}
		}

		pathVis[node] = 0;
		return false;
	}
}
