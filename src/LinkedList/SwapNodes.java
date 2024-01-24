package LinkedList;

public class SwapNodes extends SinglyLinkedList {
    public void deleteNode(Node node) {
        if(node.next == null){
            node = null;
            return;
        }

        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;

        node.next = node.next.next;
    }
}
