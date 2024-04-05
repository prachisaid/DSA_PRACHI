package recursion;

public class PalindromPartitionsCount {
    public static void main(String[] args) {
        System.out.println(palindromicPartition("aaabba"));
    }

    static int palindromicPartition(String str){
        return recursion(0, str, 0);
    }

    public static int recursion(int ind, String s, int count) {
        if(ind == s.length()) {
            return count;
        }

        int cnt = Integer.MAX_VALUE;

        for(int i = ind; i < s.length(); i++) {
            if(isPalindrome(ind, i, s)) {
                cnt = Math.min(cnt, recursion(i + 1, s, count + 1));
            }
        }

        return cnt;
    }

    private static boolean isPalindrome(int i, int j, String s) {
        while(i <= j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}
