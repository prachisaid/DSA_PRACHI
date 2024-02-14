package questions;

public class LicenceKey {
    public static void main(String[] args) {
        String s = "--a-a-a-a--";
        System.out.println(new LicenceKey().licenseKeyFormatting(s, 2));
    }

    public String licenseKeyFormatting(String s, int k1) {
        s = s.toUpperCase();
        String ans = "";
        int i = s.length()-1;
        while(i >= 0) {
            int k = k1;
            while(i >= 0 && k != 0) {
                if(s.charAt(i) != '-') {
                    ans += s.charAt(i);
                    k--;
                }

                i--;
            }
            ans += "-";
        }

        StringBuilder str = new StringBuilder(ans);

        while(str.charAt(str.length() - 1) == '-') {
            str.deleteCharAt(str.length() - 1);
        }

        System.out.println(str);
        return str.reverse().toString();
    }
}
