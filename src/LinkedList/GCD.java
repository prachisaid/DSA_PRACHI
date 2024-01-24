package LinkedList;

public class GCD extends SinglyLinkedList{
    public Node insertGreatestCommonDivisors(Node head) {
        if(head == null) return head;
        if(head.next == null) return head;

        Node n1 = head;
        Node n2 = head.next;

        while(n2 != null){
            int val = gcd(n1.val, n2.val);
            Node newNode = new Node(val);
            n1.next = newNode;
            newNode.next = n2;

            n1 = newNode.next;
            n2 = n2.next;
        }

        return head;
    }

    private int gcd(int a, int b){
        int ans = 1;
        for(int i = 1; i <= a && i <= a; i++)
        {
            if(a % i == 0 && b % i == 0) {
                ans = i;
            }
        }

        return ans;
    }
}
