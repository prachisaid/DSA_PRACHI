package recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int [] arr = {3, 9, 18, 9, 9};

        System.out.println(linearSearch2(arr, 19, 0));

        findAllIndex(arr, 9, 0);
        System.out.println(l);

        ArrayList<Integer> ls = new ArrayList<>();
        ArrayList<Integer> lst = findAllIndex1(arr, 9, 0, ls);
        lst = findAllIndex2(arr, 9, 0);
        System.out.println(lst);
    }

    // Linear Search using recursion
    static boolean linearSearch(int[] arr, int target, int n){
        if(n == arr.length){
            return false;
        }

        return ((arr[n] == target) || linearSearch(arr, target, ++n));
    }

    // Linear Search returning index
    static int linearSearch2(int[] arr, int target, int n){
        if(n == arr.length){
            return -1;
        }

        if(arr[n] == target){
            return n;
        }

        return linearSearch2(arr, target, ++n);
    }

    //Finding all indexes of the number
    static ArrayList<Integer> l = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int n){
        if(n == arr.length){
            return;
        }

        if(arr[n] == target){
            l.add(n);
        }

        findAllIndex(arr, target, ++n);
    }

    // Finding all occurrences and returning
    static ArrayList findAllIndex1(int[] arr, int target, int n, ArrayList<Integer> list){
        if(n == arr.length){
            return list;
        }

        if(arr[n] == target){
            list.add(n);
        }

        return findAllIndex1(arr, target, ++n, list);
    }

    // Return the list, don't take it in the argument
    static ArrayList findAllIndex2(int[] arr, int target, int n){
        ArrayList<Integer> list = new ArrayList<>();
        if(n == arr.length){
            return list;
        }

        // Contains answer for that function call only
        if(arr[n] == target){
            list.add(n);
        }

        ArrayList<Integer> ansFromBelow = findAllIndex2(arr, target, ++n);

        list.addAll(ansFromBelow);

        return list;
    }

    //Find index from last as well
}
