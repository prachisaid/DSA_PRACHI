package recursion;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
//        System.out.println(subSeq("", "ahbgdc"));
        ArrayList<String> lst = subSeq("", "ahbgdc");
        System.out.println(lst.contains("abc"));

    }

    static ArrayList<String> subSeq(String p, String up){

        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = subSeq(p + ch, up.substring(1));
        ArrayList<String> right = subSeq(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    static void subSeq1(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subSeq1(p + ch, up.substring(1));
        subSeq1(p, up.substring(1));
    }
}
