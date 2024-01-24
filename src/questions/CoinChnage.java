package questions;

public class CoinChnage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        int[] n = new int[1];
        change(5, 0, arr, n, 0);
        System.out.println(n[0]);
    }

    public static void change(int amount, int sum, int[] coins, int[] n, int index) {
        if(sum == amount){
            n[0] += 1;
            return;
        }

        if(index == coins.length){
            return;
        }

        sum += coins[index];
        change(amount, sum, coins, n, index + 1);
        sum -= coins[index];
        change(amount, sum, coins, n, index + 1);
    }
}
