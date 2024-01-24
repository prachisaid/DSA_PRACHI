package LinkedList;

public class DeleteDuplicates {
    public void deleteDuplicates(Node head) {
        if(head == null){
            return;
        }

        Node ptr1 = head, ptr2 = ptr1.next;

        while(ptr2 != null){
            if(ptr1.val == ptr2.val){
                ptr1.next = ptr2.next;
                ptr2 = ptr2.next;
            }
            else{
                ptr1 = ptr1.next;
            }
        }
    }

    public Node deleteDuplicatesII(Node head) {
        if(head == null){
            return null;
        }

        Node node = head;
        Node temp = null;

        while(node.next != null){
            if(node.val == node.next.val){
                temp = node.next.next;
                node = temp;
            }
            else{
                node = node.next;
                temp = node;
            }
        }

        return head;
    }
}
