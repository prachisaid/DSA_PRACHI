package LinkedList;

public class ReverseRecursive extends SinglyLinkedList{
    public void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }

        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
}
