package DynamicProgramming;

public class BuyAndSellStockWithFee {
    public static void main(String[] args) {
        int[] arr = {1,3,2,8,4,9};
        System.out.println(new BuyAndSellStockWithFee().maxProfit(arr, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        return recursive(0, 1, prices.length, prices, fee);
    }

    private int recursive(int ind, int buy, int n, int[] prices, int fee) {
        if(ind == n) return 0;

        int profit = 0;

        if(buy == 1) {
            profit =  Math.max(-prices[ind] + recursive(ind + 1, 0, n, prices, fee),
                    recursive(ind + 1, 1, n, prices, fee));
        }
        else {
            profit = Math.max(prices[ind] - fee + recursive(ind + 1, 1, n, prices, fee),
                    recursive(ind + 1, 0, n, prices, fee));
        }

        return profit;
    }
}
