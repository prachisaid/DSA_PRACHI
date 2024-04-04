package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Smallest {
    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }

        @Override
        public int compareTo(Pair comp) {
            int cmp = comp.first;
            return this.first - cmp;
        }
    }

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        ArrayList<Long> ans = new ArrayList<>();
        ArrayList<Pair> lst = new ArrayList<Pair>();
        long total = 0;

        for(int j = 0; j < nums.length; j++) {
            lst.add(new Pair(nums[j], j));
            total += nums[j];
        }

        Collections.sort(lst);

        boolean[] vis = new boolean[nums.length];

        int count = 0;

        for(int i = 0; i < queries.length; i++) {
            int ind = queries[i][0];
            int k = queries[i][1];

            while(count < lst.size() && k > 0) {
                if(!vis[lst.get(count).second]) {
                    vis[lst.get(count).second] = true;
                    total -= lst.get(count).first;
                    k--;
                }
            }

            if(!vis[ind]) {
                vis[ind] = true;
                total -= nums[ind];
            }

            ans.add(total);
        }

        long[] arr = new long[ans.size()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = ans.get(i);
        }

        return arr;
    }
}
