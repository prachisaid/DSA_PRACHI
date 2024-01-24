package recursion;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
//        mergeSortInPlace(arr, 0, arr.length);
        mergeSortInPlace(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int[] arr, int s, int e){
        if(e - s == 1){
            return;
        }

        int mid = (s + e) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        merge(arr, s, mid, e);
    }

    private static void merge(int[] arr, int s, int m, int e) {
        int[] ans = new int[e - s];

        int i = s;
        int j = m;  // because our next array starts from mid
        int k = 0;

        while(i < m && j < e){
            if(arr[i] < arr[j]){
                ans[k] = arr[i];
                i++;
                k++;
            }
            else{
                ans[k] = arr[j];
                j++;
                k++;
            }
        }

        //It may be possible that one of the array is not completely traversed
        //Copy the remaining elements
        while(i < m){
            ans[k] = arr[i];
            i++;
            k++;
        }

        while(j < e){
            ans[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < k; l++) {
            arr[s+l] = ans[l];
        }
    }

    static void mergeSortInPlace1(int[] arr, int s, int e){
        if(s >= e){
            return;
        }

        int mid = (s + e) / 2;

        mergeSortInPlace1(arr, s, mid);
        mergeSortInPlace1(arr, mid+1, e);

        merge1(arr, s, mid, e);
    }

    private static void merge1(int[] arr, int s, int m, int e) {
        int[] ans = new int[e + 1];

        int i = s;
        int j = m+1;  // because our next array starts from mid
        int k = 0;

        while(i < m+1 && j < e+1){
            if(arr[i] < arr[j]){
                ans[k] = arr[i];
                i++;
                k++;
            }
            else{
                ans[k] = arr[j];
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
    }
}
