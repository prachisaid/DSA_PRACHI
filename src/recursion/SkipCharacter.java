package recursion;

public class SkipCharacter {
    public static void main(String[] args) {
        System.out.println(skipChar("paaabbccc", ""));
        System.out.println(skipChar1("baccad"));
    }

    static String skipChar(String str, String newStr){
        if(str.length() == 0){
            return newStr;
        }

        if(str.charAt(0) != 'a'){
            newStr += str.charAt(0);
        }

        return skipChar(str.substring(1), newStr);
    }

    static String skipChar1(String str){
        String newStr = "";

        if(str.length() == 0){
            return newStr;
        }

        if(str.charAt(0) != 'a'){
            newStr += str.charAt(0);
        }

        return newStr + (skipChar1(str.substring(1)));
    }

    static void skip(String p, String up){
        if(up.isEmpty()){
            return;
        }

        char ch = up.charAt(0);

        if(ch == 'a'){
            skip(p, up.substring(1));
        }
        else{
            skip(p + ch, up.substring(1));
        }
    }
}
