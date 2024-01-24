package LinkedList;

public class FlatteningList{
    public static void main(String[] args) {

    }

    static Node flatten(Node head){
        if(head == null || head.next == null){
            return head;
        }

        head.next = flatten(flatten(head.next));

        head = mergeList(head, head.next);

        return head;
    }

    static Node mergeList(Node a, Node b){
        Node temp = new Node(-1);
        Node res = temp;

        while(a != null && b != null){
            if(a.val < b.val){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else{
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }

        if(a != null) temp.bottom = a;
        else temp.bottom = b;

        return res.bottom;
    }
}
