package StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(4);
        lst.add(2);
        lst.add(4);
        lst.add(6);
        lst.add(1);

        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(1);
        b.add(8);
        b.add(5);

        System.out.println(twoStacks(10, lst, b));
    }

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        int[] first = new int[a.size()];
        for (int i = 0; i < a.size(); i++)
            first[i] = a.get(i);

        int[] second = new int[b.size()];
        for (int i = 0; i < b.size(); i++)
            second[i] = b.get(i);

        return twoStackHelper(maxSum, 0, 0, first, second) - 1;

    }

    private static int twoStackHelper(int maxSum, int sum, int count, int[] first, int[] second) {
        if(sum > maxSum){
            return count;
        }

        if(first.length == 0 || second.length == 0){
            return count;
        }

        int f = twoStackHelper(maxSum, sum + first[0], count + 1, Arrays.copyOfRange(first, 1, first.length), second);
        int s = twoStackHelper(maxSum, sum + second[0], count + 1, first, Arrays.copyOfRange(second, 1, second.length));

        return Math.max(f, s);

    }
}
