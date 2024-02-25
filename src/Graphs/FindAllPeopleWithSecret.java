package Graphs;

import java.util.*;
public class FindAllPeopleWithSecret {
    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) {

    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < meetings.length; i++) {
            adj.get(meetings[i][0]).add(new Pair(meetings[i][1], meetings[i][2]));
            adj.get(meetings[i][1]).add(new Pair(meetings[i][0], meetings[i][2]));
        }

        int[] vis = new int[n];

        PriorityQueue<Pair> q = new PriorityQueue<>((pair1, pair2) -> Integer.compare(pair1.a, pair2.a));

        q.add(new Pair(0, 0));
        q.add(new Pair(0, firstPerson));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int t = p.a;
            int person = p.b;

            if(vis[person] == 1) {
                continue;
            }
            vis[person] = 1;

            for(Pair i : adj.get(person)) {
                int time = i.b;
                int next = i.a;

                if(vis[next] == 0 && t <= time) {
                    q.add(new Pair(time, next));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < vis.length; i++) {
            if(vis[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }
}
