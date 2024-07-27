package POTD;

import java.util.*;

public class MinimumCostToConvertString {
	public static void main(String[] args) {

	}

	static class Pair {
		char target;
		int cost;

		Pair(char target, int cost) {
			this.target = target;
			this.cost = cost;
		}
	}

	public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
		HashMap<Character, List<Pair>> map = new HashMap<>();
		int n = original.length;

		for(int i = 0; i < n; i++) {
			char s = original[i];
			char t = changed[i];
			int c = cost[i];
			boolean duplicate = false;

			if(map.containsKey(s)) {

				for(Pair p : map.get(s)) {
					if(p.target == t && p.cost > c) {
						duplicate = true;
					}
				}

				if(duplicate) {
					List<Pair> temp = map.get(s);
					temp.add(new Pair(t, c));
					map.put(s, temp);
				}
				else {
					List<Pair> temp = map.get(s);
					temp.add(new Pair(t, c));
					map.put(s, temp);
				}
			}
			else {
				List<Pair> temp = new ArrayList<>();
				temp.add(new Pair(t, c));
				map.put(s, temp);
			}
		}

		long ans = 0;

		for(int i = 0; i < source.length(); i++) {
			long temp = findShortestPath(source.charAt(i), target.charAt(i), map);
			if(temp == -1) return temp;
			ans += temp;
		}

		return ans;
	}

	public long findShortestPath(char start, char end, HashMap<Character, List<Pair>> adj) {
		if(start == end) return 0;

		HashMap<Character, Integer> dist = new HashMap<>();
		Queue<Pair> q = new LinkedList<>();

		dist.put(start, 0);
		q.add(new Pair(start, 0));

		while(!q.isEmpty()) {
			char node = q.peek().target;
			int cost = q.peek().cost;
			q.poll();

			if(node == end) continue;

			if(adj.containsKey(node)) {
				for(Pair p : adj.get(node)) {
					char adjNode = p.target;
					int adjCost = p.cost + cost;

					if(dist.containsKey(adjNode)) {
						if(dist.get(adjNode) > adjCost) {
							dist.put(adjNode, adjCost);
							q.add(new Pair(adjNode, adjCost));
						}
					}
					else {
						dist.put(adjNode, adjCost);
						q.add(new Pair(adjNode, adjCost));
					}
				}
			}
		}

		if(!dist.containsKey(end)) return -1;
		return dist.get(end);
	}
}
