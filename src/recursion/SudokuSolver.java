package recursion;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
                {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
                {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
                {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
                {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
                {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
                {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
        };

        System.out.println();
        if(solve(board)){
            display(board);
        }

    }
    static boolean solve(char[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean emptyLeft = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == '.'){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }

            // if you found some empty element in row, then break

            if(emptyLeft == false){
                break;
            }
        }

        if(emptyLeft == true){
            return true;
        }

        // Backtrack

        for (char number = '1'; number <= '9'; number++) {
            if(isSafe(board, row, col, number)){
                board[row][col] = number;
                if(solve(board)){
                    return true;
                }
                else{
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    private static void display(char[][] board) {
        for (char[] row : board){
            for(char num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(char[][] board, int row, int col, char num){
        // check the row
        for (int i = 0; i < board.length; i++) {
            // check if number is in board

            if(board[row][i] == num){
                return false;
            }
        }

        // check the col
        for (int i = 0; i < board.length; i++) {
            // check if number is in board

            if(board[i][col] == num){
                return false;
            }
        }

        // check the particular box;
        int sqrt = (int) Math.sqrt(board.length);
        int start = row - (row % sqrt);
        int end = col - (col % sqrt);

        for (int r = start; r < (start + sqrt); r++) {
            for (int c = end; c < (end + sqrt) ; c++) {
                if(board[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
