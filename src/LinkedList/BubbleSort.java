package LinkedList;

public class BubbleSort extends SinglyLinkedList{
    public Node sortList(Node head){
        bubbleSort(size, 0);
        return head;
    }

    private void bubbleSort(int row, int col) {
        if(row == 0){
            return;
        }

        if(col < row){
            Node first = get(col);
            Node second = get(col + 1);

            if(first.val > second.val){
                //swap

                if(first == head){
                    head = second;
                    first.next = second.next;
                    second.next = first;
                }

                else{
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }

            bubbleSort(row, col + 1);
        }

        bubbleSort(row - 1, 0);
    }
}
