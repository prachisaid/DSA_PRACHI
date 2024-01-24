package LinkedList;

public class BinaryToDecimal extends SinglyLinkedList{
    public int getDecimalValue(Node head){
        Node temp = head;

        int length = -1;

        while(temp != null){
            temp = temp.next;
            length++;
        }

        int ans = 0;
        temp = head;

        while(temp != null){
            if(temp.val != 0){

                ans += Math.pow(2, length);
            }
            length--;
            temp = temp.next;
        }

        return ans;
    }
}
