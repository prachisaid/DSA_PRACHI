package Contest.Weekly393;

public class LatestTimeToObtainAfterReplacingChars {
    public static void main(String[] args) {

    }

    public String findLatestTime(String s) {
        String ans = "";

        if(s.charAt(0) == '?' && s.charAt(1) == '?' && s.charAt(3) == '?' && s.charAt(4) != '?' && Integer.parseInt(s.substring(4, 5)) <= 9) {
            return "11:5" + s.charAt(4);
        }

        if(s.charAt(0) == '?' && s.charAt(1) == '?' && s.charAt(4) == '?' && s.charAt(3) != '?' && Integer.parseInt(s.substring(3, 4)) <= 5) {
            return "11:" + s.charAt(3) + "9";
        }

        if(s.charAt(0) == '?' && s.charAt(3) == '?' && s.charAt(4) == '?' && s.charAt(1) != '?' && Integer.parseInt(s.substring(1, 2)) <= 1) {
            return "1" + s.charAt(1) + ":59";
        }

        if(s.charAt(0) == '?' && s.charAt(3) == '?' && s.charAt(4) == '?' && s.charAt(1) != '?' && Integer.parseInt(s.substring(1, 2)) > 1) {
            return "0" + s.charAt(1) + ":59";
        }

        if(s.charAt(1) == '?' && s.charAt(3) == '?' && s.charAt(4) == '?' && s.charAt(0) != '?' && Integer.parseInt(s.substring(0, 1)) == 1) {
            return s.charAt(0) + "1" + ":59";
        }

        if(s.charAt(1) == '?' && s.charAt(3) == '?' && s.charAt(4) == '?' && s.charAt(0) != '?' && Integer.parseInt(s.substring(0, 1)) == 0) {
            return s.charAt(0) + "9" + ":59";
        }

        if(s.charAt(0) == '?' && s.charAt(1) == '?' && s.charAt(3) == '?' && s.charAt(4) == '?') {
            return "11:59";
        }

        if(s.charAt(0) == '?' && s.charAt(1) == '?' && s.charAt(3) != '?' && s.charAt(4) != '?' && Integer.parseInt(s.substring(3, 5)) <= 59) {
            return "11:" + s.substring(3, 5);
        }

        if(s.charAt(3) == '?' && s.charAt(4) == '?' && s.charAt(0) != '?' && s.charAt(1) != '?' && Integer.parseInt(s.substring(0, 2)) <= 11) {
            return s.substring(0, 3) + "59";
        }

        if(s.charAt(0) == '?' && (s.charAt(1) == '1' || s.charAt(1) == '0')) {
            ans += "1" + s.charAt(1) + ":";
        }

        if(s.charAt(0) == '?' && s.charAt(1) != '?' && Integer.parseInt(s.substring(1, 2)) > 1) {
            ans += "0" + s.charAt(1) + ":";
        }

        if(s.charAt(1) == '?' && s.charAt(0) == '0' && s.charAt(0) != '?') {
            ans += s.charAt(0) + "9" + ":";
        }

        if(s.charAt(1) == '?' && s.charAt(0) != '0' && s.charAt(0) != '?') {
            ans += s.charAt(0) + "1" + ":";
        }

        if(s.charAt(0) !='?' && s.charAt(1) != '?') {
            ans += s.substring(0, 3);
        }

        if(s.charAt(3) == '?' && s.charAt(4) != '?') {
            ans += "5" + s.charAt(4);
        }

        if(s.charAt(4) == '?' && s.charAt(3) != '?' && Integer.parseInt(s.substring(3, 4)) <= 5) {
            ans += s.charAt(3) + "9";
        }

        if(s.charAt(3) !='?' && s.charAt(4) != '?') {
            ans += s.substring(3, 5);
        }

        return ans;
    }
}
