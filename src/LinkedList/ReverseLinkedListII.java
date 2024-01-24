package LinkedList;

public class ReverseLinkedListII extends SinglyLinkedList{
    public Node reverseBetween(Node head, int left, int right) {
        if(left == right){
            return head;
        }

        Node current = head;
        Node prev = null;

        for (int i = 0; i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;

        Node next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;

            if(next != null){
                next = next.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }

        newEnd.next = current;
        return head;
    }
}
