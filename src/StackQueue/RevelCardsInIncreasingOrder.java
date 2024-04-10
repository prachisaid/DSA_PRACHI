package StackQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevelCardsInIncreasingOrder {
    public static void main(String[] args) {

    }

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int i = 0, j = deck.length - 1;

        while(i < j) {
            int temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;

            i++;
            j--;
        }

        Deque<Integer> dq = new LinkedList<>();
        dq.add(deck[0]);

        for(int i1 = 1; i1 < deck.length; i1++) {
            int back = dq.removeLast();
            dq.addFirst(back);
            dq.addFirst(deck[i1]);
        }

        int[] ans = new int[deck.length];
        int ind = 0;

        while(!dq.isEmpty()) {
            ans[ind++] = dq.removeFirst();
        }

        return ans;
    }
}
