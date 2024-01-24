package Heaps;


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//compareTo Method gives lexicographical sorting of strings
public class FoodRatings {
    public String[] foods;
    public String[] cuisines;
    public int[] ratings;
//    int n;

//    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//        this.n = foods.length;
//        for(int i = 0; i < foods.length; i++) {
//            this.foods = foods.clone();
//            this.cuisines = cuisines.clone();
//            this.ratings = ratings.clone();
//        }
//    }
//
//    public void changeRating(String food, int newRating) {
//        for(int i = 0; i < n; i++) {
//            if(foods[i].equals(food)) {
//                ratings[i] = newRating;
//            }
//        }
//    }
//
//    public String highestRated(String cuisine) {
//        String ans = "";
//        int max = 0;
//        int ind = 0;
//
//        for(int i = 0; i < n; i++) {
//            if(cuisines[i].equals(cuisine)) {
//                if(max < ratings[i]) {
//                    max = ratings[i];
//                    ind = i;
//                }
//                else if(max == ratings[i]) {
//                    if(foods[ind].compareTo(foods[i]) > 0) {
//                        max = ratings[i];
//                        ind = i;
//                    }
//                }
//            }
//        }
//
//        return foods[ind];
//    }

    class Pair {
        String first;
        String second;
        int r;

        Pair(String a, String c, int b) {
            this.first = a;
            this.second = c;
            this.r = b;
        }
    }

    HashMap<String, PriorityQueue<Pair>> cuisineMap = new HashMap<>();
    HashMap<String, Pair> foodMap = new HashMap<>();
    int n;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.n = foods.length;
        for(int i = 0; i < n; i++) {
            Pair p = new Pair(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], p);

            if(cuisineMap.containsKey(cuisines[i])) {
                cuisineMap.get(cuisines[i]).add(p);
            }
            else{
                PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
                    public int compare(Pair a, Pair b) {
                        int result = b.r - a.r;
                        if(result == 0) {
                            return (a.first).compareTo(b.first);
                        }

                        return result;
                    }
                });

                pq.add(p);
                cuisineMap.put(cuisines[i], pq);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        Pair prev = foodMap.get(food);
        Pair curr = new Pair(food, prev.second, newRating);
        foodMap.put(food, curr);
        cuisineMap.get(prev.second).add(curr);
    }

    public String highestRated(String cuisine) {
        while(cuisineMap.get(cuisine).peek().first.equals("")) {
            cuisineMap.get(cuisine).remove();
        }

        return cuisineMap.get(cuisine).peek().first;
    }

    public static void main(String[] args) {

    }
}
