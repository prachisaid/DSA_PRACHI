package LinkedList;
import java.util.*;
import java.util.HashMap;

public class CopyLinkedList extends SinglyLinkedList{
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        if(head.next == null){
            Node newHead = new Node(head.val);
            if(head.random == null){
                newHead.random = null;
            }
            else{
                newHead.random = newHead;
            }
            return newHead;
        }

        Node temp = head.next;
        Node newHead = new Node(head.val);
        Node temp2 = newHead;

        while(temp != null){
            Node newNode = new Node(temp.val);
            temp2.next = newNode;
            temp = temp.next;
            temp2 = temp2.next;
        }

        temp2.next = null;

        temp = head;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        while(temp != null){
            if(temp.random == null){
                map.put(cnt, -1);
            }
            else{
                map.put(cnt, temp.random.val);
            }

            temp = temp.next;
            cnt += 1;
        }

        temp2 = newHead;
        cnt = 0;

        while(temp2 != null){
            int val = map.get(cnt);

            Node ptr = newHead;

            while(ptr != null){
                if(ptr.val == val){
                    break;
                }

                ptr = ptr.next;
            }

            if(ptr != null)
            {temp2.random = ptr;
            }
            else{
                temp2.random = null;
            }
            temp2 = temp2.next;
            cnt += 1;
        }

        return newHead;
    }
}
