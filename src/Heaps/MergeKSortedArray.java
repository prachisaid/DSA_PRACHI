package Heaps;

import java.util.* ;
import java.io.*;
import java.util.ArrayList;

class Node{
    public int data;
    public int row;
    public int col;

    Node(int a, int b, int c){
        data = a;
        row = b;
        col = c;
    }
}
public class MergeKSortedArray {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> arr, int k){
        PriorityQueue<Node> pq = new PriorityQueue<Node>((Node n1, Node n2) -> n1.data-n2.data);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < k; i++){
            Node temp = new Node(arr.get(i).get(0), i, 0);
            pq.add(temp);
        }

        while(pq.size() > 0){
            Node temp = pq.poll();
            ans.add(temp.data);

            int row = temp.row;
            int col = temp.col;

            if((col + 1) < arr.get(row).size()){
                Node next = new Node(arr.get(row).get(col + 1), row, col+1);
                pq.add(next);
            }
        }

        return ans;
    }
}
