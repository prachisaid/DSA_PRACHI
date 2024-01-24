package Trees;

import java.util.HashMap;
import java.util.*;

public class AmountOfTimeForBTToBeInfected extends BinarySearchTree{
    public static void main(String[] args) {
        AmountOfTimeForBTToBeInfected bst = new AmountOfTimeForBTToBeInfected();
        bst.insert(9);
        bst.insert(3);
        bst.insert(6);
        bst.insert(4);
        bst.insert(7);
        bst.insert(12);
        bst.insert(10);
        bst.insert(13);


        System.out.println(bst.amountOfTime(bst.root, 3));
    }

    public int amountOfTime(Node root, int start) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        dfs(root, graph);

        System.out.println(graph);
        return bfs(graph, start);
    }

    private void dfs(Node root, HashMap<Integer, List<Integer>> graph) {
        if(root == null) return;

        if(!graph.containsKey(root.value)) {
            graph.put(root.value, new ArrayList<>());
        }

        if(root.left != null) {
            if(!graph.containsKey(root.left.value)) {
                graph.put(root.left.value, new ArrayList<>());
            }
            graph.get(root.left.value).add(root.value);
            graph.get(root.value).add(root.left.value);

        }

        if(root.left != null) {
            if(!graph.containsKey(root.right.value)) {
                graph.put(root.right.value, new ArrayList<>());
            }
            graph.get(root.right.value).add(root.value);
            graph.get(root.value).add(root.right.value);
        }

        dfs(root.left, graph);
        dfs(root.right, graph);
    }

    private int bfs(HashMap<Integer, List<Integer>> graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);

        int time = -1;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int value = q.remove();
                List<Integer> temp = graph.get(value);

                for(int adjNode : temp) {
                    if(!visited.contains(adjNode)) {
                        q.offer(adjNode);
                        visited.add(adjNode);
                    }
                }
            }

            time++;
        }

        return time;
    }
}
