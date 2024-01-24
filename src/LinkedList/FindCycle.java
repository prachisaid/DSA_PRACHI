package LinkedList;

public class FindCycle {
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }

        return false;
    }

    public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                Node temp = head;
                int count = 0;

                while(temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                    count++;
                }

                return slow;

            }
        }
        return null;
    }
}
