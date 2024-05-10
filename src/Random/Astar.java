package Random;

import java.util.*;

public class Astar {
	static class Node {
		Node parent;
		int[][] matrix = new int[3][3];
		int x, y;
		int level, cost;
	}

	public static class Comp implements Comparator<Node> {
		public int compare(Node left, Node right) {
			return (left.cost + left.level) > (right.cost + right.level) ? 1 : -1;
		}
	}

	public static void main(String[] args) {
		int[][] initial = {
			{1, 2, 3},
			{5, 6, 0},
			{7, 8, 4}
		};

		int[][] goal = {
			{1, 2, 3},
			{5, 8, 6},
			{0, 7, 4}
		};

		astar(initial, goal, 1, 2);
	}

	public static void astar(int[][] initial, int[][] goal, int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comp());

		Node root = newNode(initial, x, y, x, y, 0, null);
		root.cost = calculateCost(initial, goal);
		pq.add(root);

		boolean first = true;

		int[] delRow = {1, 0, -1, 0};
		int[] delCol = {0, -1, 0, 1};

		while(!pq.isEmpty()) {
			Node node = pq.poll();

			if(first) {
				printMatrix(node.matrix);
				printValues(node.level, node.cost);
				first = false;
			}
			else {
				System.out.println("Selected optimal path");
				printMatrix(node.matrix);
				printValues(node.level, node.cost);
			}

			if(node.cost == 0) {
				System.out.println("Final optimal path");
				printPath(node);
				return;
			}

			int possible = 0;
			for(int i = 0; i < 4; i++) {
				if(isValid(node.x + delRow[i], node.y + delCol[i])) {
					possible += 1;
				}
			}

			System.out.println("Total possible moves " + possible);

			for(int i = 0; i < 4; i++) {
				if(isValid(node.x + delRow[i], node.y + delCol[i])) {
					Node child = newNode(node.matrix, node.x, node.y, node.x + delRow[i], node.y +delCol[i], node.level + 1, node);
					child.cost = calculateCost(child.matrix, goal);

					pq.add(child);

					printMatrix(child.matrix);
					printValues(child.level, child.cost);
					System.out.println();
				}
			}
		}
	}

	private static boolean isValid(int row, int col) {
		return (row >= 0 && row < 3 && col >= 0 && col < 3);
	}

	private static Node newNode(int[][] mat, int x1, int y1, int x2, int y2, int level, Node parent) {
		Node node = new Node();
		node.parent = parent;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				node.matrix[i][j] = mat[i][j];
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

	private static int calculateCost(int[][] initial, int[][] goal) {
		int cost = 0;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(initial[i][j] != 0 && initial[i][j] != goal[i][j]) cost += 1;
			}
		}

		return cost;
	}

	private static void printPath(Node root) {
		if(root == null) {
			return;
		}

		printPath(root.parent);
		printMatrix(root.matrix);
		printValues(root.level, root.cost);
	}

	private static void printMatrix(int[][] matrix) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printValues(int g, int h) {
		System.out.println("g(n) : " + g + " h(n) : " + h + " f(n) : " + (int)(h + g));
		System.out.println();
	}
}
