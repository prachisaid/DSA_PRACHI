package questions;

public class CommonPrefix {
    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(new CommonPrefix().prefixString(str));
    }

    public String prefixString(String[] str) {
        String comp = str[0];

        for(int i = 1; i < str.length; i++) {
            String temp = "";
            int i1 = 0, j1 = 0;

            while(i1 < comp.length() && j1 < str[i].length()) {
                if(str[i].charAt(j1) == comp.charAt(i1)) {
                    temp += str[i].charAt(j1);
                    i1++;
                    j1++;
                }
                else {
                    break;
                }
            }

            comp = temp;
        }

        return comp;
    }
}
