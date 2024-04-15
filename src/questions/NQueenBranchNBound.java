package questions;

public class NQueenBranchNBound {
    public static int cnt = 1;
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];

        boolean[] colCheck = new boolean[n];
        boolean[] rightDiagonal = new boolean[2 * n - 1];
        boolean[] leftDiagonal = new boolean[2 * n - 1];

        queens(board, 0, colCheck, leftDiagonal, rightDiagonal);
    }

    public static void queens(boolean[][] board, int row, boolean[] colCheck, boolean[] leftDiagonal, boolean[] rightDiagonal) {
        if(row == board.length) {
            System.out.println("FINAL Arrangement " + cnt);
            cnt += 1;
            display(board);
            return;
        }

        for(int col = 0; col < board[row].length; col++) {
            if(!colCheck[col] && !leftDiagonal[row + col] && !rightDiagonal[row - col + board.length - 1]) {
                board[row][col] = true;
                colCheck[col] = true;
                leftDiagonal[row + col] = true;
                rightDiagonal[row - col + board.length - 1] = true;

                queens(board, row + 1, colCheck, leftDiagonal, rightDiagonal);

                board[row][col] = false;
                leftDiagonal[row + col] = false;
                colCheck[col] = false;
                rightDiagonal[row - col + board.length - 1] = false;
            }
        }
    }

    private static void display(boolean[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j]) {
                    System.out.print("Q ");
                }
                else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}
