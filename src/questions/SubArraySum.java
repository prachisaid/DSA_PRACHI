package questions;

public class SubArraySum {
    public static void main(String[] args) {
        int arr[] = {-1, -1, 1, 1};
        System.out.println(subarraySum(arr, 0, 0, 0));
    }

    static int subarraySum(int[] arr, int k, int ind, int cnt) {
        if(ind == arr.length){
            return cnt;
        }

        int sum = 0;
        for (int i = ind; i < arr.length; i++){
            sum += arr[i];
            if(sum == k){
                cnt++;
            }
        }

        return subarraySum(arr, k, ind+1, cnt);
    }
}
