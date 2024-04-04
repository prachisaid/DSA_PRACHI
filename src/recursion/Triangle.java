package recursion;

import java.util.ArrayList;

public class Triangle {
    public static void main(String[] args) {
        triangle1(2, 0);
    }

    static void triangle1(int r, int c){
        if(r == 0){
            return;
        }

        if (c < r){
            triangle1(r, c + 1);
            System.out.print("*");
        }
        else{
            triangle1(r - 1, 0);
            System.out.println();
        }
    }
}
