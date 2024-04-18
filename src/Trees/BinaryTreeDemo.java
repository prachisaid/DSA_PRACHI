package Trees;

import java.util.*;

public class BinaryTreeDemo {

    public static class Node {
        Node left;
        Node right;
        int value;

        Node(int val) {
            this.value = val;
        }
    }

    public Node root;
    Scanner sc = new Scanner(System.in);

    public void insert() {
        System.out.println("Enter root node value ");
        int val = sc.nextInt();
        root = new Node(val);

        insertChild(root);
    }

    private void insertChild(Node root) {
        System.out.println("Do you want to insert at the left of " + root.value);
        int left = sc.nextInt();

        if(left == 1) {
            System.out.println("Enter value of left node ");
            int val = sc.nextInt();
            root.left = new Node(val);
            insertChild(root.left);
        }

        System.out.println("Do you want to insert at the right of " + root.value);
        int right = sc.nextInt();

        if(right == 1) {
            System.out.println("Enter value of right node ");
            int val = sc.nextInt();
            root.right = new Node(val);
            insertChild(root.right);
        }
    }

    public void inorder() {
        inorderTraversal(root);
        inorderIterative(root);
    }

    private void inorderTraversal(Node root) {
        if(root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }

    public void preorder() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public void postorder() {
//        postorderTraversal(root);
        postOrderIterativeTwoStack(root);
    }

    private void postorderTraversal(Node root) {
        if(root == null) {
            return;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    public void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> lst = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                lst.add(node.value);

                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(lst);
        }
        System.out.println(ans);
    }

    private void inorderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> lst = new ArrayList<>();
        Node node = root;

        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }

            else{
                if(stack.isEmpty()) break;
                node = stack.pop();
                lst.add(node.value);
                node = node.right;
            }
        }

        System.out.println(lst);
    }

    private void postOrderIterativeTwoStack(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        List<Integer> ans = new ArrayList<>();

        stack1.push(root);

        while(!stack1.isEmpty()) {
            Node node = stack1.pop();

            stack2.push(node);

            if(node.left != null) {
                stack1.push(node.left);
            }
            if(node.right != null) {
                stack1.push(node.right);
            }
        }

        while(!stack2.isEmpty())  {
            ans.add(stack2.pop().value);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        BinaryTreeDemo bt = new BinaryTreeDemo();

        bt.insert();
        bt.postorder();
    }
}
