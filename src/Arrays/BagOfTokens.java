package Arrays;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {

    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, maxScore = 0;
        int i = 0, j = tokens.length - 1;

        while(i <= j) {
            if(power >= tokens[i]) {
                power -= tokens[i];
                i++;
                score++;
                maxScore = Math.max(score, maxScore);
            }
            else if(score > 0) {
                score--;
                power += tokens[j];
                maxScore = Math.max(score, maxScore);
                j--;
            }
            else{
                i++;
                j--;
            }
        }

        return maxScore;
    }
}
