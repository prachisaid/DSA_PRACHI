package LinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        IntersectionOFNodes ll = new IntersectionOFNodes();
        SinglyLinkedList l2 = new SinglyLinkedList();
        SinglyLinkedList l3 = new SinglyLinkedList();

//        ll.insertLast(12);
//        ll.insertLast(20);
//        ll.insertFirst(7);
//        ll.insertFirst(6);
//        ll.insertFirst(5);
//        ll.insertFirst(4);
//        ll.insertFirst(3);
//        ll.insertFirst(2);
//        ll.insertFirst(1);

        l2.insertFirst(8);
        l2.insertFirst(7);
        l2.insertFirst(6);
        l2.insertFirst(5);
//
        l3.insertFirst(9);
        l3.insertFirst(4);
        l3.insertFirst(3);
        l3.insertFirst(2);
//        ll.insertFirst(14);
//        ll.display();
//        ll.insert(4);
//        ll.insert(2);
//        ll.insert(1);
//        ll.insert(3);
//        ll.insertBetween(100, 3);
//        ll.insertBetween(200, 5);
//        System.out.println(ll.delete(1));
//        ll.helper(12, 0);
//        ll.helper(13, 1);
//        ll.helper(14, 1);
//        ll.helper(2, 3);
//        ll.display();

//        Node[] node= new Node[3];
//        node[0] = ll.head;
//        node[1] = l2.head;
//        node[2] = l3.head;
//        ll.getDecimalValue(ll.head);
//        MergeKSortedElement merge = new MergeKSortedElement();
//        Node head = merge.mergeKLists(node);
//        merge.head = head;
//        merge.display();

        System.out.println(ll.getIntersectionNode(l2.head, l3.head));
        ll.display();
    }
}
