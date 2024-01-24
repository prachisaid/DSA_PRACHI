package DynamicProgramming;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

        System.out.println(new BuyAndSellStocks().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }

        return profit;
    }
}
