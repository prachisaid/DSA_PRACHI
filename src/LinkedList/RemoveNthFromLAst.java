package LinkedList;

public class RemoveNthFromLAst {
    public Node removeNthFromEnd(Node head, int n) {
        if(head == null) return head;
        if(n == 0) return head;

        Node node = head;
        int count = 0;

        while(node != null){
            node = node.next;
            count += 1;
        }

        if(n == count){
            head = head.next;
            return head;
        }

        node = head;
        while(node != null){
            if(count == (n+1)){
                node.next = node.next.next;
            }

            node = node.next;
            count--;
        }

        return head;
    }
}
