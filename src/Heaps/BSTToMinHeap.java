package Heaps;

import Trees.BinarySearchTree;

import java.util.ArrayList;

public class BSTToMinHeap extends BinarySearchTree {

    public static int ind = 0;
    public static Node convertBST(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        System.out.println(arr);
        postorder(root, arr);
        return root;
    }

    private static void inorder(Node root, ArrayList<Integer> arr){
        if(root == null) return;

        inorder(root.left, arr);
        arr.add(root.value);
        inorder(root.right, arr);
    }

    private static void preorder(Node root, ArrayList<Integer> arr){
        if(root == null) return;

        root.value = arr.get(ind++);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }

    private static void postorder(Node root, ArrayList<Integer> arr){
        if(root == null) return;

        postorder(root.left, arr);
        postorder(root.right, arr);
        root.value = arr.get(ind++);
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
//        16 8 24 4 12 20 28

        System.out.println(convertBST(bst.root).value);
        bst.bfs();
    }
}
