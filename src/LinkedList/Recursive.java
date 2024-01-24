package LinkedList;

public class Recursive {
    Node head;
    public void helper(int val, int index){
        head = insertRec1(val, index, head);
    }

    private Node insertRec1(int val, int index, Node node) {
        if (index == 0) {
            Node ans = new Node(val);
            ans.next = node;
            return ans;
        }

        node.next = insertRec1(val, --index, node.next);
        return node;
    }
}
