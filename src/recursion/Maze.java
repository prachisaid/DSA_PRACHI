package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        // System.out.println(maze(3, 3));
        // mazePattern("", 3, 3);
//         System.out.println(mazePatternReturn("", 3, 3));
         System.out.println(mazePatternDiagonal("", 3, 3));

        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        // mazePatternObstacle("", maze, 0, 0);

    }

    static int maze(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }

        return maze(row-1, col) + maze(row, col-1);
    }

    static void mazePattern(String p, int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row != 1) {
            mazePattern(p + "D", row - 1, col);
        }

        if(col != 1) {
            mazePattern(p + "R", row, col - 1);
        }
    }

    // Maze Pattern returning the paths
    static ArrayList<String> mazePatternReturn(String p, int row, int col){
        if(row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

         ArrayList<String> left = new ArrayList<>();
         ArrayList<String> right = new ArrayList<>();

        if(row != 1) {
            left = (mazePatternReturn(p + "D", row - 1, col));
        }

        if(col != 1) {
            right = (mazePatternReturn(p + "R", row, col - 1));
        }
         left.addAll(right);

//        return list;
        return left;
    }

    // Maze with Diagonal paths included
    static ArrayList<String> mazePatternDiagonal(String p, int row, int col){
        if(row == 1 && col == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if(row > 1 && col > 1){
            list.addAll(mazePatternDiagonal(p + "D", row - 1, col - 1));
        }

        if(row > 1) {
            list.addAll(mazePatternDiagonal(p + "V", row - 1, col));
        }

        if(col > 1) {
            list.addAll(mazePatternDiagonal(p + "H", row, col - 1));
        }

        return list;
    }

    // Maze with some Obstacles
    static void mazePatternObstacle(String p, boolean[][] maze, int row, int col){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        if(maze[row][col] == false){
            return;
        }

        if(row < maze.length-1) {
            mazePatternObstacle(p + "D", maze, row + 1, col);
        }

        if(col < maze[0].length-1) {
            mazePatternObstacle(p + "R", maze, row, col + 1);
        }
    }

}
