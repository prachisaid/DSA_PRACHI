package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayWinner {
    public static void main(String[] args) {

        int[] arr = {2, 1, 3, 5, 4, 6, 7};
        System.out.println((0 + (3 - 0) / 2));

        ArrayWinner ar = new ArrayWinner();
        System.out.println(ar.getWinner(arr, 100));
    }

    public int getWinner(int[] arr, int k) {
        ArrayList<Integer> lst = new ArrayList<>();
        if(k >= arr.length) return Arrays.stream(arr).max().getAsInt();

        for(int a : arr){
            lst.add(a);
        }

        int ans = 0;
        int prev = -1;

        while(ans != (k-1)){

            if(lst.get(0) > lst.get(1)){
                lst.add(lst.get(1));
                lst.remove(1);

                if(prev == lst.get(0)){
                    ans++;
                }

                prev = lst.get(0);
            }
            else{
                if (prev == lst.get(1)) {
                    ans++;
                }
                prev = lst.get(1);

                lst.add(lst.get(0));
                lst.remove(0);

            }
        }

        return prev;
    }
}
