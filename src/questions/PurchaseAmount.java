package questions;

public class PurchaseAmount {
    public static void main(String[] args) {
        System.out.println(accountBalanceAfterPurchase(99));
    }

    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        int val = findMultiple(purchaseAmount);
        int ans = 100 - (val * 10);
        return ans;
    }

    private static int findMultiple(int n){
        int mod = n % 10;

        if(mod < 5){
            int val = n / 10;
            return val;
        }
        else {
            int val = n / 10;
            return val + 1;
        }
    }
}
