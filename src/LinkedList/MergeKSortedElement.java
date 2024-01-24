package LinkedList;

import java.util.PriorityQueue;

public class MergeKSortedElement extends SinglyLinkedList{
    public Node mergeKLists(Node[] lists){
        PriorityQueue<Node> heap = new PriorityQueue<Node>((Node n1, Node n2) -> n1.val-n2.val);

        for(Node list : lists){
            if(list != null){
                heap.add(list);
            }
        }

        System.out.println(heap.size());

        Node temp = new Node(-1);
        Node tail = temp;

        while(!heap.isEmpty()){
            tail.next = heap.poll();
            tail = tail.next;

            if(tail.next != null){
                heap.add(tail.next);
            }
        }
        return temp.next;
    }
}
