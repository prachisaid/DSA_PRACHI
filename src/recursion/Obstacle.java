package recursion;

public class Obstacle {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0},
                {0, 1}
        };

        System.out.println(uniquePathsWithObstacles(maze));
    }

    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1){
            return 0;
        }
        return handler("", 0, 0, obstacleGrid);
    }
    static int handler(String p, int row, int col, int[][] obstacle){
        if(row == obstacle.length-1 && col == obstacle[0].length-1){
            return 1;
        }

        if(obstacle[row][col] == 1){
            return 0;
        }

        int count1 = 0, count2 = 0;

        if(row < obstacle.length-1){
            count1 = handler(p + "D", row + 1, col, obstacle);
        }

        if(col < obstacle[0].length-1){
            count2 = handler(p + "R", row, col + 1, obstacle);
        }

        return count1 + count2;
    }
}
