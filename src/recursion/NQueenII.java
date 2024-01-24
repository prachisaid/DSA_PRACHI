package recursion;

public class NQueenII {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
    
    public static int totalNQueens(int n) {
        char [][] board = new char[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        return dfs(0, board);
    }

    private static int dfs(int col, char[][] board) {
        if(col == board.length){
            return 1;
        }

        int cnt = 0;

        for (int row = 0; row < board.length; row++) {
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                cnt += dfs(col+1, board);
                board[row][col] = '.';
            }
        }

        return cnt;
    }

    private static boolean isSafe(int row, int col, char[][] board) {
        int duprow = row;
        int dupcol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        
        while(col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            col--;
        }

        row = duprow;
        col = dupcol;
        
        while(row < board.length && col >= 0){
            if(board[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        
        return true;
    }
}
