package LinkedList;

public class MergeSort extends SinglyLinkedList{
    public Node sortList(Node head) {
        if(head == null || head.next == null){
            return head;
        }

        Node mid = middleNode(head);
        Node left = sortList(head);
        Node right = sortList(mid);
        return mergeTwoLists(left, right);
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node head = new Node(-1);
        Node temp = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }

        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }
        return head.next;
    }

    public Node middleNode(Node head) {
        Node midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null)? head : midPrev.next;
            head = head.next.next;
        }

        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}
