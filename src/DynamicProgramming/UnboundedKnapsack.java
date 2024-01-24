package DynamicProgramming;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] wt = {7, 2, 4};
        int[] val = {5, 10, 20};

        System.out.println(unboundedKnapsack(wt.length, 15, wt, val));
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return recursive(n - 1, w, profit, weight);
    }

    private static int recursive(int ind, int W, int[] wt, int[] val) {
        if(ind == 0) {
            int times = W / wt[0];
            return val[0] * times;
        }

        int notTake = recursive(ind - 1, W, wt, val);
        int take = 0;

        if(wt[ind] <= W) take = val[ind] + recursive(ind, W - wt[ind], wt, val);

        return Math.max(take, notTake);
    }
}
