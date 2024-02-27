package questions;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        arr.get(0).add(1);

        for(int i = 1; i < n; i++) {
            arr.get(i).add(1);

            for(int j = 1; j < i; j++) {
                arr.get(i).add(arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j));
            }

            arr.get(i).add(i, 1);
        }

        return arr;
    }
}
