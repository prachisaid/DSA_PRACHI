package LinkedList;

public class ReverseAlternate extends SinglyLinkedList{
    public Node reverseKGroup(Node head, int k) {
        if(k <= 1 || head == null || head.next == null){
            return head;
        }

        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        System.out.println(count);

        Node current = head;
        Node prev = null;

        while (current != null) {
            Node last = prev;
            Node newEnd = current;

            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;

                if (next != null) {
                    next = next.next;
                }
                count--;
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }

            if(count < k){
                break;
            }
        }

        return head;
    }
}
