package LinkedList;

public class RotateList extends SinglyLinkedList {
    public Node rotateRight(Node head, int k) {

        int length = 0;
        Node temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }

        for (int i = 0; i < k % length; i++) {
            Node first = head;
            Node current = head;
            Node prev = null;
            while(current.next != null){
                prev = current;
                current = current.next;
            }

            current.next = first;
            prev.next = null;
            head = current;
        }

        return head;
    }
}
