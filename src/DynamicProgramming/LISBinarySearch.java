package DynamicProgramming;

import java.util.ArrayList;

public class LISBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 7, 8, 4, 5, 6, -1, 9};
        System.out.println(new LISBinarySearch().lis(arr, arr.length));
    }

    public int lis(int[] arr, int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        for(int i = 1; i <arr.length; i++) {
            if(arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
            }
            else{
                int ind = binarySearch(temp, 0, temp.size() - 1, arr[i]);
                temp.remove(ind);
                temp.add(ind, arr[i]);
            }
        }

        return temp.size();
    }

    private int binarySearch(ArrayList<Integer> arr, int s, int e, int target) {
        while(s <= e) {
            int m = (s + e) / 2;

            if(arr.get(m) == target) return m;
            else if(arr.get(m) > target) e = m - 1;
            else s = m + 1;
        }

        return s;
    }
}
