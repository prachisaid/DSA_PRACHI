package LinkedList;

public class CircularLinkedList {
    private Node head;
    int size;

    public CircularLinkedList() {
       this.size = 0;
    }

    public void insert(int val){
        Node node = new Node(val);

        if(head == null){
            head = node;
            head.next = node;
            return;
        }

        Node temp = head;

        while(temp.next != head){
//            System.out.println(temp.next.val);
            temp = temp.next;
        }

        temp.next = node;
        node.next = head;

//        System.out.println(node.next.val);
    }

    public int delete(int val){
        if(head == null){
            return -1;
        }

        Node temp = head;

        do{
            if(temp.next.val == val){
                break;
            }
            temp = temp.next;
        }while(temp != head);

        int item = temp.next.val;

        if(temp.next == head){
            head = temp.next.next;
        }
        temp.next = temp.next.next;

        return item;
    }

    public void display(){
        if(head == null){
            return;
        }
        Node temp = head;

        do{
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        while(temp != head);

        System.out.println("HEAD");
    }
}
