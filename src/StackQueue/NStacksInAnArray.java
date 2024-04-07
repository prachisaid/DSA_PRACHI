package StackQueue;

import java.util.*;
public class NStacksInAnArray {

    int[] arr;
    int[] next;
    int[] top;
    int freeSpot;

    public NStacksInAnArray(int N, int S) {
        arr = new int[S];
        next = new int[S];
        top = new int[N];

        for(int i = 0; i < next.length - 1; i++) {
            next[i] = i + 1;
        }

        next[next.length - 1] = -1;

        Arrays.fill(top, -1);

        freeSpot = 0;
    }
    public static void main(String[] args) {
        NStacksInAnArray obj = new NStacksInAnArray(3, 6);

        System.out.println(obj.push(10, 1));
        System.out.println(obj.push(20, 1));
        System.out.println(obj.push(30, 2));
        System.out.println(obj.pop(1));
        System.out.println(obj.pop(2));
    }

    public boolean push (int x, int m) {
        if(freeSpot == -1) {
            return false;
        }

        int index = freeSpot;
        freeSpot = next[index];
        arr[index] = x;
        next[index] = top[m - 1];
        top[m - 1] = index;

        return true;
    }

    public int pop (int m) {
        if(top[m - 1] == -1) {
            return -1;
        }

        int index = top[m - 1];
        int elem = arr[index];
        top[m - 1] = next[index];
        next[index] = freeSpot;
        freeSpot = index;

        return elem;
    }
}
