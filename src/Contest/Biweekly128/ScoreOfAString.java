package Contest.Biweekly128;

public class ScoreOfAString {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public int scoreOfString(String s) {
        int ans = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            int sum = Math.abs((s.charAt(i) - '0') - (s.charAt(i + 1) - '0'));

            ans += sum;
        }

        return ans;
    }
}
