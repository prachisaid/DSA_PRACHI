package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class FloydWarshall {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 3, -1, -1},
                {3, 0, 1, 1},
                {-1, 1, 0, 1},
                {-1, 4, 1, -1}
        };

        new FloydWarshall().shortest_distance(matrix);
        for(int[] mat : matrix) {
            System.out.println(Arrays.toString(mat));
        }

    }

    public void shortest_distance(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == -1) matrix[i][j] = Integer.MAX_VALUE;
                if(i == j) matrix[i][j] = 0;
            }
        }


        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) continue;
                    matrix[i][j] = Math.min(matrix[i][j] , (matrix[i][k] + matrix[k][j]));
                }
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] ==  (int) (1e9)){
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
