package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";

//        System.out.println(str.substring(0, 1));

        permutation("", "abc");
        System.out.println(permutation2("", "abc"));
        System.out.println(permutationCount1("", "abc"));
    }

    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        for (int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            permutation(first + ch + second, up.substring(1));
        }
    }

    static ArrayList<String> permutation2(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
//            System.out.pri
//            ntln(p);
            return list;

        }

        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(permutation2(first + ch + second, up.substring(1)));
        }

        return ans;
    }

    static int permutationCount(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return 1;
        }

        char ch = up.charAt(0);
        int count = 0;

        for (int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            count = count + permutationCount(first + ch + second, up.substring(1));
        }

        return count;
    }

    static int permutationCount1(String p, String up){
        return helper(p, up, 0);
    }

    static int helper(String p, String up, int count){
        if(up.isEmpty()){
            System.out.println(p);
            return count;
        }

        char ch = up.charAt(0);
        int cnt = 0;

        for (int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            cnt = helper(first + ch + second, up.substring(1), ++count);
        }
        return cnt;
    }

}
