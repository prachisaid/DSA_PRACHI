package Trees;

import java.util.*;
import java.util.stream.Collectors;

public class ZigZagTraversal extends BinaryTreeDemo {

    public static void zigzagLevelOrder(Node node) {

        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        boolean flag = true;

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int level = queue.size();

            ArrayList<Integer> lst = new ArrayList<>();
            for(int i = 0; i < level; i++) {
                lst.add(0);
            }

            System.out.println(lst);

            for (int i = 0; i < level; i++) {
                Node n = queue.poll();

                int index = flag ? i : (level - 1 - i);
//                arr[index] = n.value;
                lst.set(index, n.value);

                if(n.left != null){
                    queue.add(n.left);
                }
                if(n.right != null){
                    queue.add(n.right);
                }
            }
            flag = !flag;
//            ans.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            ans.add(new ArrayList<>(lst));
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        BinaryTreeDemo bt = new BinaryTreeDemo();
        bt.insert();
        zigzagLevelOrder(bt.root);
    }
}
