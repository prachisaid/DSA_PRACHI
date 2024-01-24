package LinkedList;

public class DoublyLinkedList {
    DblNode head;
    int size;

    DoublyLinkedList(){
        size = 0;
    }

    public void insertFirst(int val){
        DblNode node = new DblNode(val);

        node.next = head;
        node.prev = null;

        if(head != null){
            head.prev = node;
        }

        head = node;
        size++;
    }

    public void insertLast(int val){
        DblNode node = new DblNode(val);
        if(head == null){
            insertFirst(val);
            return;
        }
        DblNode temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        node.prev = temp;
        node.next = null;
        temp.next = node;
        size++;
    }

    public void insert(int val, int position){
        if(position == 0){
            insertFirst(val);
        }

        if(position == size){
            insertLast(val);
        }

        DblNode temp = head;
        DblNode node = new DblNode(val);

        for (int i = 1; i < position-1; i++) {
            temp = temp.next;
        }

        temp.next.prev = node;
        node.next = temp.next;
        node.prev = temp;
        temp.next = node;
        size++;
    }

    public void display(){
        DblNode node = head;
        DblNode last = null;

        while(node != null){
            System.out.print(node.value + " -> ");
            last = node;
            node = node.next;
        }

        System.out.println("END");

        while(last != null){
            System.out.print(last.value + " -> ");
            last = last.prev;
        }

        System.out.println("END");
    }
}

class DblNode{
    int value;
    DblNode next;
    DblNode prev;

    DblNode(int value){
        this.value = value;
    }

    DblNode(int value, DblNode next, DblNode prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
