package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSortStriver {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(6);
        arr.add(2);
        arr.add(5);
        arr.add(7);
        arr.add(9);
        arr.add(1);
        arr.add(3);

        System.out.println(qs(arr));
    }

    static List<Integer> qs(List<Integer> arr){
        quickSort(arr, 0, arr.size()-1);
        return arr;
    }

    static void quickSort(List<Integer> arr, int low, int high){
        if(low < high){
            int index = partition(arr, low, high);

            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while(i < j){
            while(arr.get(i) <= pivot && i < high){
                i++;
            }

            while(arr.get(j) > pivot && j > low){
                j--;
            }

            if(i < j){
                Collections.swap(arr, i, j);
            }
        }

        Collections.swap(arr, low, j);
        return j;
    }
}
