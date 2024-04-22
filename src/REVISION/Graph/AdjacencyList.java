package REVISION.Graph;

import java.util.*;

public class AdjacencyList {
	public static void main(String[] args) {
//		System.out.println(adjList(4, 5));
		String ans = "answer";
		if(ans.contains("ans")) System.out.println(ans);
	}

	public static List<List<Integer>> adjList(int n, int m) {
		List<List<Integer>> adjList = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		for(int i = 0; i < m; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter edge u & v");
			int u = sc.nextInt();
			int v = sc.nextInt();

			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		return adjList;
	}
}
