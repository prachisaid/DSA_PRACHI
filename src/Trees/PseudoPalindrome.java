package Trees;

import java.util.*;

public class PseudoPalindrome extends BinarySearchTree{
    public static void main(String[] args) {
        PseudoPalindrome obj = new PseudoPalindrome();
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(3);
        obj.insert(1);
        obj.insert(1);

//        System.out.println(obj.inorder());
//        obj.inorder();
        System.out.println(obj.pseudoPalindromicPaths(obj.root));
    }

    public int pseudoPalindromicPaths (Node root) {
        List<List<Integer>> lst = new ArrayList<>();
        path(root, new ArrayList<>(), lst);
        int count = 0;

        for(List<Integer> temp : lst) {
            if(checkPalindrome(temp)) count++;
        }

        return count;
    }

    private static void path(Node root, List<Integer> ans, List<List<Integer>> lst) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            ans.add(root.value);
            List<Integer> temp = new ArrayList<>(ans);
            lst.add(temp);
            ans.remove(ans.size() - 1);
            return;
        }

        ans.add(root.value);
        path(root.left, ans, lst);
        path(root.right, ans, lst);
        ans.remove(ans.size() - 1);
    }

    private static boolean checkPalindrome(List<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int elem : arr) {
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }

        System.out.println(map);
        int odd = 0;

        if(arr.size() % 2 == 0) {
            for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
                if(mp.getValue() % 2 == 1) return false;
            }
        }

        else {
            for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
                if(mp.getValue() % 2 == 1 && odd == 0){
                    odd = 1;
                }
                else if(mp.getValue() % 2 == 1 && odd == 1) return false;
            }
        }

        return true;
    }
}
