package StackQueue;

public class CelebrityBrute {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 0},
                     {0, 0, 0},
                     {0, 1, 0}};

        System.out.println(celebrity(M, M.length));
    }

    static int celebrity(int M[][], int n)
    {
        int pos = -1;
//        int count = 0;

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < M[i].length; j++){
                if(i != j) {
                    if (M[i][j] == 0) {
                        count++;
                    }
                }
            }

            if(count == n-1){
                pos = i;
            }
        }

        if(pos == -1){
            return -1;
        }
        int flag = 0;
        for(int i = 0; i < n; i++){
            if(M[i][pos] != 1 && i != pos){
                flag = 1;
                break;
            }
        }

        if(flag == 0){
            return pos;
        }

        return -1;
    }
}
