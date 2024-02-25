package Graphs;

import java.lang.reflect.Array;
import java.util.*;

public class GreatestCommonDivisorTraversal {
    int MAX = (int)(1e5 + 5);
    boolean[] prime = new boolean[MAX];
    int[] lp = new int[MAX];
    int cnt = 0;
    public static void main(String[] args) {
        int[] nums = {10};
        System.out.println(new GreatestCommonDivisorTraversal().canTraverseAllPairs(nums));
    }

    private void sieve() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i = 1; i < MAX; i++) {
            lp[i] = i;
        }

        for(int i = 2; i * i < MAX; i++) {
            if(prime[i]) {
                for(int j = i * i; j < MAX; j+=i) {
                    if(prime[j]) {
                        lp[j] = i;
                    }
                    prime[j] = false;
                }
            }
        }
    }

    private ArrayList<Integer> getFactorization(int x) {
        Set<Integer> set = new HashSet<>();

        while(x > 1) {
            set.add(lp[x]);
            x = x / lp[x];
        }
        return new ArrayList<>(set);
    }

    public boolean canTraverseAllPairs(int[] nums) {
        sieve();

        int n = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            map.put(i, getFactorization(nums[i]));
        }

        HashMap<Integer, ArrayList<Integer>> remap = new HashMap<>();
        for(Map.Entry<Integer, ArrayList<Integer>> mp : map.entrySet()) {
            int id = mp.getKey();

            for(Integer temp : mp.getValue()) {
                if(!remap.containsKey(temp)) {
                    remap.put(temp, new ArrayList<>());
                }
                remap.get(temp).add(id);
            }
        }

        HashMap<Integer, ArrayList<Integer>> gr = new HashMap<>();
        for(Map.Entry<Integer, ArrayList<Integer>> mp1 : remap.entrySet()) {
            ArrayList<Integer> ids = mp1.getValue();

            if(ids.size() <= 1) continue;

            for(int i = 1; i < ids.size(); i++) {
                int u = ids.get(i - 1);
                int v = ids.get(i);

                if(!gr.containsKey(u)) {
                    gr.put(u, new ArrayList<>());
                }
                gr.get(u).add(v);

                if(!gr.containsKey(v)) {
                    gr.put(v, new ArrayList<>());
                }
                gr.get(v).add(u);
            }
        }
        
        boolean[] vis = new boolean[n];
        cnt = 0;
        dfs(0, gr, vis);
        if(cnt == n) return true;
        return false;
    }

    private void dfs(int node, HashMap<Integer, ArrayList<Integer>> map, boolean[] vis) {
        if(vis[node]) {
            return;
        }

        vis[node] = true;
        cnt++;
        for(Integer adj : map.get(node)) {
            if(!vis[adj]) {
                dfs(adj, map, vis);
            }
        }
    }
}