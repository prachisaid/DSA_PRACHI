package recursion;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetIterative {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4};
//        System.out.println(subset(arr));
        System.out.println(subsetDuplicates(arr));
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        System.out.println(outer);

        for(int nums : arr){
            int n = outer.size();
            for(int i = 0; i < n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                System.out.println(internal +  " internal ");
                internal.add(nums);
                outer.add(internal);
            }
        }

        return outer;
    }

    static List<List<Integer>> subsetDuplicates(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for(int j = 0; j < arr.length; j++){
            start = 0;

            //If current and previous element is same start = end + 1
            if(j > 0 && arr[j] == arr[j-1]){
                start = end + 1;
            }

            end = outer.size() - 1;
            int n = outer.size();

            for(int i = start; i < n; i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(arr[j]);
                outer.add(internal);
            }
        }

        return outer;
    }
}
