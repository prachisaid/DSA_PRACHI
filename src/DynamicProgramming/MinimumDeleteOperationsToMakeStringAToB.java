package DynamicProgramming;

public class MinimumDeleteOperationsToMakeStringAToB {
    public static void main(String[] args) {
        MinimumDeleteOperationsToMakeStringAToB obj = new MinimumDeleteOperationsToMakeStringAToB();
        System.out.println(obj.minDistance("sea", "eat"));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int lcs = recursive(n - 1, m - 1, word1, word2);
        return Math.abs((n - lcs) + (m - lcs));
    }

    private int recursive(int i, int j, String s, String t) {
        if(i < 0 || j < 0) return 0;

        if(s.charAt(i) == t.charAt(j)) return 1 + recursive(i - 1, j - 1, s, t);
        return Math.max(recursive(i - 1, j, s, t), recursive(i, j - 1, s, t));
    }
}
