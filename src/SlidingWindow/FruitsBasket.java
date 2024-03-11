package SlidingWindow;

import java.util.HashMap;

// Alternative of Pick Toys
public class FruitsBasket {
    public static void main(String[] args) {

    }

    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int len = 0;

        while(j < fruits.length) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            if(map.size() <= 2) {
                len = Math.max(len, (j - i + 1));
                j++;
            }

            else if(map.size() > 2) {
                while(map.size() > 2) {
                    map.put(fruits[i], map.get(fruits[i]) - 1);

                    if(map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                    }

                    i++;
                }

                j++;
            }
        }

        return len;
    }
}
