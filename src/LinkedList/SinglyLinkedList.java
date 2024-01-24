package LinkedList;
public class SinglyLinkedList {
    Node head;
    Node tail;
    int size;

    SinglyLinkedList(){
        int size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;

        if(head == null){
            head = tail;
        }

        size++;
    }

    public void insert(int val){
        Node node = new Node(val);
        if(head == null){
            head = node;
            return;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = node;
        size++;
    }

    public void helper(int val, int index){
//        Node temp = head;
//        insertRec(val, index, 0, temp);
        head = insertRec1(val, index, head);
    }
    private void insertRec(int val, int index, int cnt, Node temp){
        if(head == null){
            Node node = new Node(val);
            head = node;
            return;
        }

        if(cnt == index-1){
            Node node = new Node(val);
            node.next = temp.next;
            temp.next = node;
            return;
        }

        insertRec(val, index, ++cnt, temp.next);
    }

    public Node get(int val){
        Node temp = head;

        for (int i = 0; i < val; i++) {
            temp = temp.next;
        }

        return temp;
    }
    private Node insertRec1(int val, int index, Node node){
        if(index == 0){
            Node ans = new Node(val);
            ans.next = node;
            return ans;
        }

        node.next = insertRec1(val, --index, node.next);
        return node;
    }

    public void insertBetween(int val, int pos){
        if(pos == 0){
            insertFirst(val);
            return;
        }

        if(pos == size){
            insertLast(val);
        }
        int cnt = 0;
        Node node = new Node(val);
        Node temp = head;

        while(cnt < pos-1){
            temp = temp.next;
            cnt++;
        }

        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public int deleteFirst(){
        int item = head.val;
        head = head.next;

        if(head == null){
            tail = null;
        }

        size--;
        return item;
    }

    public int deleteLast(){
        Node node = head;
        for (int i = 0; i < size-2; i++) {
            node = node.next;
        }

        int item = tail.val;
        tail = node;
        tail.next = null;
        size--;
        return item;
    }

    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if(index == size-1){
            return deleteLast();
        }

        Node prev = head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }

        int item = prev.next.val;
        prev.next = prev.next.next;
        return item;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}


class Node{
    int val;
    Node next;
    Node random;
    Node bottom;

    Node(int val){
        this.val = val;
        this.next = null;
    }

    Node(int val, Node next){
        this.val = val;
        this.next = next;

    }
}