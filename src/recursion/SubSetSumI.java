package recursion;

import java.util.ArrayList;

public class SubSetSumI {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);

        int n  = arr.size();
        System.out.println(subsetSums(arr, 0, 0));
    }

    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n, int sum){
        if(n == arr.size()){
            ArrayList<Integer> sumArr = new ArrayList<>();
            sumArr.add(sum);
            return sumArr;
        }

        ArrayList<Integer> left = new ArrayList<>();
        sum += arr.get(n);
        left.addAll(subsetSums(arr, n+1, sum));

        ArrayList<Integer> right = new ArrayList<>();
        sum -= arr.get(n);
        right.addAll(subsetSums(arr, n+1, sum));

        left.addAll(right);
        return left;
    }
}
