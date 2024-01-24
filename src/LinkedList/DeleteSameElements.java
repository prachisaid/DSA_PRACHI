package LinkedList;

public class DeleteSameElements extends SinglyLinkedList{
    public Node removeElements(Node head, int val) {
        if(head == null) return head;

        Node current = head;
        Node prev = null;

        while(current != null){
            if(current.val == val){
                if(current == head){
                    head = head.next;
                }
                else{
                    prev.next = current.next;
                }
                current = current.next;
            }
            else{
                prev = current;
                current = current.next;
            }
        }

        return head;
    }
}
