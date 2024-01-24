package DynamicProgramming;

public class RodCutting {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 10};

        System.out.println(cutRod(arr, 5));
    }

    public static int cutRod(int[] price, int n) {
        return recursive(price.length - 1, n, price);
    }

    private static int recursive(int ind, int N, int[] price) {
        if(ind == 0) {
            return N * price[0];
        }

        int notTake = recursive(ind - 1, N, price);
        int take = Integer.MIN_VALUE;
        int indLength = ind + 1;

        if(indLength <= N) take = price[ind] + recursive(ind - 1, N - indLength, price);

        return Math.max(take, notTake);
    }
}
