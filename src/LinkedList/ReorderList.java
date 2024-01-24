package LinkedList;

public class ReorderList extends SinglyLinkedList {
    public void reorderList(Node head) {
        Node mid = getMiddle(head);
        Node headSecond = reverseList(mid);

        Node headfirst = head;

        while(headfirst != null && headSecond != null){
            Node temp = headfirst.next;
            headfirst.next = headSecond;
            headfirst = temp;
            temp = headSecond.next;
            headSecond.next = headfirst;
            headSecond = temp;
        }
    }

    private Node reverseList(Node head) {
        if(head == null) return head;
        if(head.next == null) return head;

        Node prev = null;
        Node present = head;
        Node next = present.next;;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;

            if(next != null){
                next = next.next;
            }
        }

        head = prev;
        return head;
    }

    private Node getMiddle(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
