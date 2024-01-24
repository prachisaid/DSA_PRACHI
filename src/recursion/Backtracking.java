package recursion;

import java.util.Arrays;

public class Backtracking {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

//        mazeAllPaths("", maze, 0, 0);
        int[][] path = new int[maze.length][maze[0].length];
        printPathsMatrix("", maze, 0, 0, path, 1);
    }

    static void mazeAllPaths(String p, boolean[][] maze, int row, int col){

        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(maze[row][col] == false){
            return;
        }

        maze[row][col] = false;

        if(row < maze.length-1) {
            mazeAllPaths(p + "D", maze, row + 1, col);
        }

        if(col < maze[0].length-1) {
            mazeAllPaths(p + "R", maze, row, col + 1);
        }

        if(row > 0) {
            mazeAllPaths(p + "U", maze, row - 1, col);
        }

        if(col > 0){
            mazeAllPaths(p + "L", maze, row, col - 1);
        }

        // This line is where the function will be over so before removing the function also changes the changes
        // that were made

        maze[row][col] = true;
    }

    static void printPathsMatrix(String p, boolean[][] maze, int row, int col, int[][] path, int step){

        if(row == maze.length - 1 && col == maze[0].length - 1){
            path[row][col] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(maze[row][col] == false){
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;

        if(row < maze.length-1) {
            printPathsMatrix(p + "D", maze, row + 1, col, path, step+1);
        }

        if(col < maze[0].length-1) {
            printPathsMatrix(p + "R", maze, row, col + 1, path, step+1);
        }

        if(row > 0) {
            printPathsMatrix(p + "U", maze, row - 1, col, path, step+1);
        }

        if(col > 0){
            printPathsMatrix(p + "L", maze, row, col - 1, path, step+1);
        }

        // This line is where the function will be over so before removing the function also changes the changes
        // that were made

        maze[row][col] = true;
        path[row][col] = 0;
    }
}
