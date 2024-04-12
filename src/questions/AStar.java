package questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar {
    public static class Node {
        Node parent;
        int[][] matrix = new int[3][3];
        int x, y;
        int cost, level;
    }

    public static class Comp implements Comparator<Node> {
        public int compare(Node left, Node right) {
            return (left.cost + left.level) > (right.cost + right.level) ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        int[][] initial = {
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5}
        };

        int[][] goal = {
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        };

        AStar obj = new AStar();
        obj.aStar(initial, goal, 2, 1);
    }

    public void aStar(int[][] initial, int[][] goal, int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comp());

        Node root = newNode(initial, x, y, x, y, 0, null);
        root.cost = calculateCost(initial, goal);
        pq.add(root);
        System.out.println(pq);

        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, -1, 0, 1};

        while(!pq.isEmpty()) {
            Node node = pq.peek();
            pq.poll();

            if(node.cost == 0) {
                printPath(node);
                return;
            }

            for(int i = 0; i < 4; i++) {
                if(isValid(node.x + delRow[i], node.y + delCol[i])) {
                    Node child = newNode(node.matrix, node.x, node.y, node.x + delRow[i],
                            node.y + delCol[i], node.level + 1, node);

                    child.cost = calculateCost(child.matrix, goal);
                    pq.add(child);
                }
            }
        }
    }

    private Node newNode(int[][] initial, int x1, int y1, int x2, int y2, int level, Node parent) {
        Node node = new Node();
        node.parent = parent;

        node.matrix = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                node.matrix[i][j] = initial[i][j];
            }
        }

        int temp = node.matrix[x1][y1];
        node.matrix[x1][y1] = node.matrix[x2][y2];
        node.matrix[x2][y2] = temp;

        node.cost = Integer.MIN_VALUE;
        node.level = level;

        node.x = x2;
        node.y = y2;

        return node;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }

    private int calculateCost(int[][] initial, int[][] goal) {
        int ans = 0;
        for(int i = 0; i < initial.length; i++) {
            for(int j = 0; j < initial[i].length; j++) {
                if(initial[i][j] != 0 && initial[i][j] != goal[i][j]) {
                    ans += 1;
                }
            }
        }

        return ans;
    }

    public void printPath(Node root1){
        if(root1 == null){
            return;
        }
        printPath(root1.parent);
        printMatrix(root1.matrix);
        printValues(root1.level, root1.cost);
    }

    public void printMatrix(int[][] initial){
        for(int i1 = 0; i1 < 3; i1++){
            for(int j1 = 0; j1 < 3; j1++){
                System.out.print(initial[i1][j1]+" ");
            }
            System.out.println();
        }
    }

    public void printValues(int level, int cost) {
        System.out.println("g(n) " + level + " | " + "h(n) " + cost + " | " + "f(n) " + (int) (level + cost));
        System.out.println();
    }
}