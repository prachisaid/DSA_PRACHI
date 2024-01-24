package DynamicProgramming;

public class MinimumCoinsII {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};

        MinimumCoinsII obj = new MinimumCoinsII();
        System.out.println(obj.change(5, coins));
    }

    public int change(int amount, int[] coins) {
        return recursive(coins.length - 1, amount, coins);
    }

    private static int recursive(int ind, int T, int[] coins) {
        if (ind == 0) {
            if (T % coins[0] == 0) return 1;
            else return 0;
        }

        int notTake = recursive(ind - 1, T, coins);
        int take = 0;

        if(coins[ind] <= T) take = recursive(ind, T - coins[ind], coins);

        return notTake + take;
    }


}
