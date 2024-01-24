package recursion;

public class MColoring {
    public static void main(String[] args) {
        boolean[][] g = {
                {false, true, true, true},
                {true, false, true, true},
                {true, true, false, false},
                {true, true, false, false}
        };
        System.out.println(graphColoring(g, 3, 4));
//        int node = 3;
//        int[] color = {1, 2, 3, 0};
//        int col = 3;
//        for(int i = node; i <= node; i++){
//            for(int j = 0; j < g[i].length; j++){
//                if(g[i][j]){
//                    if(color[j] == col){
//                        System.out.println(false);
//                    }
//                }
//            }
//        }
    }

    private static boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        if(solve(0, graph, color, m , n)){
            return true;
        }
        return false;
    }

    private static boolean solve(int node, boolean[][] graph, int[] color, int m, int n){
        if(node == n){
            return true;
        }

        for(int i = 1; i <= m; i++){
            if(isSafe(node, graph, color, n , i)){
                color[node] = i;
                if(solve(node+1, graph, color, m, n)){
                    return true;
                }
                color[node] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int node, boolean[][] graph, int[] color, int n, int col){
        for(int i = node; i <= node; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(graph[i][j]){
                    if(color[j] == col){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
