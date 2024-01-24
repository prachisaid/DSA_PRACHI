package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenLeetCode {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens1(board, 0));
    }

    static List<List<String>> queens1(boolean[][] board, int row){
        if(row == board.length){
            List<List<String>> lst = new ArrayList<>();
            lst.add(display1(board));
            return lst;
        }

        List<List<String>> lst = new ArrayList<>();

        for (int col = 0; col < board.length; col++) {
            // place the queen if it is safe

            if(isSafe1(board, row, col)){
                board[row][col] = true;
                lst.addAll(queens1(board, row+1));
                board[row][col] = false;
            }
        }

        return lst;
    }

    private static boolean isSafe1(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }

        //Left Diagonal
        int shiftLeft = Math.min(row, col);

        for (int i = 1; i <= shiftLeft; i++){
            if(board[row-i][col-i] == true){
                return false;
            }
        }

        // Right Diagonal
        int shiftRight = Math.min(row,board.length-col-1);
        for (int i = 1; i <= shiftRight; i++){
            if(board[row-i][col+i] == true){
                return false;
            }
        }

        return true;
    }

    private static List<String> display1(boolean[][] board) {
        List<String> lst = new ArrayList<>();
        for(boolean arr[] : board){
            String ans = "";
            for(boolean element : arr){
                if(element){
//                    l1.add("Q");
                    ans += "Q";
                }
                else{
//                    l1.add(".");
                    ans += ".";
                }
            }
            lst.add(ans);
        }

        return lst;
    }
}
