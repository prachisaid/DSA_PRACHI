package recursion;

import java.util.ArrayList;

public class Triangle {
    public static void main(String[] args) {
//        triangle1(2, 0);
        ArrayList<String> lst = new ArrayList<>();
//        lst.add("hee");
        lst.add("ba");
        lst.add("ab");
        String str = "eidboaoo";

        for(String n : lst){
            if(str.contains(n)){
                System.out.println("true");
            }
        }
        System.out.println(str.contains("ab"));
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
