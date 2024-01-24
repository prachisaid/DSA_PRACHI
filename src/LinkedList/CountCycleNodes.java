package LinkedList;

public class CountCycleNodes {
    public int countNodesInLoop(Node head)
    {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                Node temp = slow;
                int count = 1;

                while(temp.next != fast){
                    temp = temp.next;
                    count++;
                }

                return count;
            }
        }

        return 0;
    }
}
