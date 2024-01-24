package LinkedList;

public class IsPalindrome extends SinglyLinkedList{
    public boolean isPalindrome(Node head) {
        Node mid = getMiddle(head);
        Node headSecond = reverseList(mid);

        Node reverseHead = headSecond;

        while(head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }

            head = head.next;
            headSecond = headSecond.next;
        }

        reverseList(reverseHead);

        if(head == null || headSecond == null){
            return true;
        }
        else{
            return false;
        }
    }

    private Node reverseList(Node head) {
        if(head == null) return head;
        if(head.next == null) return head;

        Node prev = null;
        Node present = head;
        Node next = present.next;;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;

            if(next != null){
                next = next.next;
            }
        }

        head = prev;
        return head;
    }

    private Node getMiddle(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
