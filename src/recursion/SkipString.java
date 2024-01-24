package recursion;

public class SkipString {
    public static void main(String[] args) {
        System.out.println(skipWord("baccappledh", ""));
    }

    static String skipWord(String str, String up){
        if(str.isEmpty()){
            return up;
        }

        char ch = str.charAt(0);

        if(str.startsWith("apple")){
            return skipWord(str.substring(5), up);
        }
        else{
            return skipWord(str.substring(1), up + ch);
        }
    }
}
