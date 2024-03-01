package BinarySearch;

public class SearchIn2DRowAndColumnWise {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3}
        };

        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix[0].length - 1;

        int row = matrix.length;
        int col = matrix[0].length;

        while(start < row && end >= 0) {
            if(matrix[start][end] == target) {
                return true;
            }
            if(matrix[start][end] > target) {
                end--;
            }
            else if(matrix[start][end] < target) {
                start++;
            }
        }

        return false;
    }
}
