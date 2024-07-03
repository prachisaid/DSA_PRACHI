package REVISION.Recursion;

public class MatrixWithObstacle {
	public static void main(String[] args) {
		boolean[][] maze = {
			{false, false, false},
			{false, true, false},
			{false, false, false}
		};
		paths("", maze, 0, 0);
	}

	public static void paths(String p, boolean[][] maze, int row, int col) {
		if(row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(p);
			return;
		}

		if(maze[row][col]) return;

		if(row < maze.length - 1) {
			paths(p + "D", maze, row + 1, col);
		}

		if(col < maze[0].length - 1) {
			paths(p + "R", maze, row, col + 1);
		}
	}
}
