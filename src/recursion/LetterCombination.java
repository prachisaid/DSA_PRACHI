package recursion;
import java.util.ArrayList;
import java.util.List;

public class LetterCombination {
    public static void main(String[] args) {
        letterCombination("", "12");
//        System.out.println(letterCombinations( ""));
    }

    static void letterCombination(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        System.out.println(digit);

        for (int i = (digit - 1) * 3; i < (digit) * 3; i++){
            char ch = (char) ('a' + i);
            letterCombination(p + ch, up.substring(1));
        }
    }

    static List<String> letterCombination2(String p, String up){
        if(up.isEmpty()){
            List<String> lst = new ArrayList<>();
//            System.out.println(p);
            lst.add(p);
            return lst;
        }

        int digit = up.charAt(0) - '0';
        List<String> lst = new ArrayList<>();

        for (int i = (digit - 1) * 3; i < digit * 3; i++){
            char ch = (char) ('a' + i);
            lst.addAll(letterCombination2(p + ch, up.substring(1)));
        }

        return lst;
    }

    static List<String> letterCombinations(String digits) {
        List<String> lst = new ArrayList<>();
        if(digits.length() == 0){
            return lst;
        }
        return letterCombination3("", digits);
    }

    static List<String> letterCombination3(String p, String up){
        if(up.isEmpty()){
            List<String> lst = new ArrayList<>();
            lst.add(p);
            return lst;
        }

        int digit = up.charAt(0) - '0';
        int i = (digit - 2) * 3;

        if(digit > 7){
            i += 1;
        }

        int len = i + 3;

        if(digit == 7 || digit == 9){
            len += 1;
        }
        List<String> lst = new ArrayList<>();

        for (;i < len; i++){
            char ch = (char) ('a' + i);
            lst.addAll(letterCombination3(p + ch, up.substring(1)));
        }

        return lst;
    }
}
