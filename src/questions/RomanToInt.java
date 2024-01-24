package questions;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    static int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += romanCheck(s.charAt(i));
        }

        return sum;
    }

    static private int romanCheck(char ch){
        if(ch == 'I'){
            return 1;
        }

        else if(ch == 'V'){
            return 5;
        }

        else if(ch == 'X'){
            return 10;
        }

        else if(ch == 'X'){
            return 10;
        }

        else if(ch == 'L'){
            return 50;
        }

        else if(ch == 'C'){
            return 100;
        }

        else if(ch == 'D'){
            return 500;
        }

        else if(ch == 'M'){
            return 1000;
        }

        else {
            return 0;
        }
    }
}
