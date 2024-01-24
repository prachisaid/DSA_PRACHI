package recursion;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        partitionHelper(0, s, path, res);
        return res;
    }

    private static void partitionHelper(int ind, String s, List<String> path, List<List<String>> res) {
        if(ind == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = ind; i < s.length(); i++){
            if(isPalindrome(s, ind, i)){
                path.add(s.substring(ind, i+1));
                partitionHelper(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

}
