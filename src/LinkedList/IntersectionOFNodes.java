package LinkedList;

public class IntersectionOFNodes extends SinglyLinkedList{
    public Node getIntersectionNode(Node headA, Node headB) {
        Node l1 = headA;
        int len2 = 0;
        int len1 = 0;
        Node l2 = headB;

        while(l1 != null){
            l1 = l1.next;
            len1++;
        }

        while(l2 != null){
            l2 = l2.next;
            len2++;
        }

        l1 = headA;
        l2 = headB;

        while(len1 != len2 && l1 != null && l2 != null){
            if(len1 > len2){
                l1 = l1.next;
                len1--;
            }
            else{
                l2 = l2.next;
                len2--;
            }
        }

        while(l1 != null && l2 != null){
            if(l1 == l2){
                return l2;
            }

            l2 = l2.next;
            l1 = l1.next;
        }

        return null;
    }
}
