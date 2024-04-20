package Graphs;

import java.util.*;

class Pair{
    int first;
    int second;

    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class NoOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '0', '0'},
                {'0', '1', '1'},
                {'0', '1', '1'},
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int cnt = 0;

		ArrayList<int[]> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    ans.add(bfs(i, j, visited, grid));
                }
            }
        }

		int[][] arr = new int[ans.size()][];
		int i = 0;

		for(int[] lst : ans) {
			arr[i++] = lst;
		}

        return cnt;
    }

    private static int[] bfs(int ro, int co, int[][] visited, char[][] grid){
        Queue<Pair> q = new LinkedList<Pair>();
        visited[ro][co] = 1;
        q.add(new Pair(ro, co));

		int[] arr = new int[4];
		arr[0] = ro;
		arr[1] = co;

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;

            q.remove();

			int[] delrow = {-1, 0, 1, 0};
			int[] delcol = {0, 1, 0, -1};

			for(int i = 0; i < delrow.length; i++) {
				int nrow = row + delrow[i];
				int ncol = col + delcol[i];

				if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && visited[nrow][ncol] == 0){
					visited[nrow][ncol] = 1;
					q.add(new Pair(nrow, ncol));
				}
			}

			arr[2] = row;
			arr[3] = col;
        }

//		System.out.println(Arrays.toString(arr));
		return arr;
    }
}
