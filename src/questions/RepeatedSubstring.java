package questions;

public class RepeatedSubstring {
    public static boolean repStr(String s){
        if(s.length() % 2 == 1) return false;
        int i = 0;
        int j = 1;

        while(j != s.length() && s.charAt(i) != s.charAt(j)){
            j++;
        }

        String substr = s.substring(i, j);

        for(int k = 0; k < s.length(); k += substr.length()){
            String sub = s.substring(k, k + substr.length());

            if(!sub.equals(substr)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(repStr("abcabcabc"));
    }
}
