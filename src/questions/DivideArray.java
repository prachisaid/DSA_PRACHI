package questions;

import java.util.Arrays;

public class DivideArray {
    public static void main(String[] args) {
        int[][] ans = new DivideArray().divideArray();

        for(int[] temp : ans) {
            System.out.println(Arrays.toString(temp));
        }
    }

    public int[][] divideArray(){
        int[] arr = {1, 2, 3, 3, 3, 7};
        int n = arr.length;
        int[][] ans = new int[n/3][3];
        int ind = 0;
        int k = 2;

        for(int i = 0; i < n; i++) {
            ans[ind][0] = arr[i];
            ans[ind][1] = arr[i + 1];
            ans[ind][2] = arr[i + 2];

            i += 2;
            ind++;
        }

        for(int i = 0; i < ans.length; i++) {
            if(!(Math.abs(ans[i][0] - ans[i][1]) <= k && Math.abs(ans[i][1] - ans[i][2]) <= k && Math.abs(ans[i][0] - ans[i][2]) <= k)){
                return new int[0][0];
            }
        }

        return ans;
    }
}
