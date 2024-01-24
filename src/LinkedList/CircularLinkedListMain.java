package LinkedList;

public class CircularLinkedListMain {
    public static void main(String[] args) {
        CircularLinkedList lst = new CircularLinkedList();
//        lst.insert(12);
//        lst.insert(13);
//        lst.insert(14);
//        lst.insert(23);
//        lst.insert(1);
//        lst.insert(4);
        lst.display();
        lst.delete(1);
        lst.delete(12);
        lst.display();
    }
}
