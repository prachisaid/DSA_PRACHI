package recursion;


import java.util.Arrays;

public class CountInversion {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        System.out.println(mergeSortInPlace1(arr, 0, arr.length-1));
    }

    static int mergeSortInPlace1(int[] arr, int s, int e){
        int cnt = 0;
        if(s >= e){
            return cnt;
        }

        int mid = (s + e) / 2;

        cnt += mergeSortInPlace1(arr, s, mid);
        cnt += mergeSortInPlace1(arr, mid+1, e);

        cnt += merge1(arr, s, mid, e);
        return cnt;
    }

    private static int merge1(int[] arr, int s, int m, int e) {
        int[] ans = new int[e + 1];

        int i = s;
        int j = m+1;  // because our next array starts from mid
        int k = 0;

        int cnt = 0;
        while(i < m+1 && j < e+1){
            if(arr[i] < arr[j]){
                ans[k] = arr[i];
                i++;
                k++;
            }
            else{
                ans[k] = arr[j];
                cnt += (m - i + 1);
                j++;
                k++;
            }
        }

        //It may be possible that one of the array is not completely traversed
        //Copy the remaining elements
        while(i < m+1){
            ans[k] = arr[i];
            i++;
            k++;
        }

        while(j < e+1){
            ans[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < k; l++) {
            arr[s+l] = ans[l];
        }

        return cnt;
    }
}
