package recursion;

import java.util.ArrayList;

public class ArraySeubSeq {
    public static void main(String[] args) {
        int[] arr = {3,5,6,7};
        ArrayList<Integer> lst =  new ArrayList<>();
        SubSeq(arr, 0, lst, 0, 9);
        System.out.println(SubSeq1(arr, 0, 0, 9 ));
    }

    static void SubSeq(int[] arr, int index, ArrayList list, int sum, int target){
        if(index == arr.length){
            if(sum <= target && sum != 0){
                System.out.println(list);
            }
            return;
        }

        // Take the index
        list.add(arr[index]);
        sum += arr[index];
        SubSeq(arr, index+1, list, sum, target);

        // Not to take the index
        list.remove(list.size()-1);
        sum -= arr[index];
        SubSeq(arr, index+1, list, sum, target);
    }

    static int SubSeq1(int[] arr, int index, int sum, int target){
        if(index != arr.length && sum > target){
            return 0;
        }

        if(index == arr.length){
            if(sum <= target){
                return 1;
            }

            return 0;
        }

        int list1 = 0;
        int list2 = 0;

        // Take the index
        sum += arr[index];
        list1 = SubSeq1(arr, index+1, sum, target);

        // Not to take the index
        sum -= arr[index];
        list2 = SubSeq1(arr, index+1, sum, target);

        return list1 + list2;
    }
}
