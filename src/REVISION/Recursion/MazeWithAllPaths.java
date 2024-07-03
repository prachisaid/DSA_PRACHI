package REVISION.Recursion;

public class MazeWithAllPaths {
	public static void main(String[] args) {
		boolean[][] maze = {
			{false, false, false},
			{false, false, false},
			{false, false, false}
		};
		paths(maze, 0, 0, "");
	}

	public static void paths(boolean[][] maze, int row, int col, String p) {
		if(row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(p);
			return;
		}

		if(maze[row][col]) return;

		maze[row][col] = true;

		if(row < maze.length - 1) {
			paths(maze, row + 1, col, p + "D");
		}

		if(col < maze[0].length - 1) {
			paths(maze, row, col + 1, p + "R");
		}

		if(row > 0) {
			paths(maze, row - 1, col, p + "U");
		}

		if(col > 0) {
			paths(maze, row, col - 1, p + "L");
		}

		maze[row][col] = false;
	}
}
