package LinkedList;

public class AddTwoLinkedList {
    public Node addTwoNumbers(Node l1, Node l2) {
        Node node = new Node(-1);
        Node temp = node;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;

            carry = sum / 10;

            Node newNode = new Node(sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }

        return node.next;
    }
}
