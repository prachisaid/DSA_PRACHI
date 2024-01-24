package StackQueue;

public class VowelString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    public static String reverseVowels(String s) {
        int store = -1;
        int temp = -1;
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i))){
                temp = i;
            }

            if(isVowel(s.charAt(s.length()-i-1))){
                store = s.length()-i-1;
            }

            if(temp != -1 && store != -1){
                int temp1 = temp;
                s.replace(s.charAt(temp), s.charAt(store));
                s.replace(s.charAt(store), s.charAt(temp1));
                store = -1;
                temp = -1;
            }
        }

        return s;
    }

    public static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }

        return false;
    }
}
